package com.core.interceptors;

import com.core.pageModel.PageHelper;
import com.util.ReflectHelper;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PageInterceptor implements Interceptor {

    private String dialect = "oracle"; // 数据库方言

    @Override

    public Object intercept(Invocation ivk) throws Throwable {
        if (ivk.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");

            BoundSql boundSql = delegate.getBoundSql();
            //System.out.println(boundSql.getSql());
            Object parameterObject = boundSql.getParameterObject();// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
            if (parameterObject != null) {
                PageHelper page = null;
                if (parameterObject instanceof Map && ((Map) parameterObject).containsKey("page")) {
                    page = (PageHelper) ((Map) parameterObject).get("page");
                } else if (PageHelper.class.isAssignableFrom(parameterObject.getClass())) {
                    page = (PageHelper) parameterObject;
                }
                if (page == null || page.getPage() == 0 || page.getRows() == 0)
                    return ivk.proceed();
                Connection connection = (Connection) ivk.getArgs()[0];
                String sql = boundSql.getSql();

                String countSql = generateCountSql(sql);

//                if (page.getOrder() != null && page.getOrder().length() > 0) {
//                    sql += " order by " + page.getOrder();
//                }

                if (countSql != null && countSql.length() > 0) {
                    ReflectHelper.setValueByFieldName(boundSql, "sql", countSql); // 将分页sql语句反射回BoundSql.
                    PreparedStatement countStmt = connection.prepareStatement(countSql);
                    // BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    // boundSql.getParameterMappings(),parameterObject);
                    setParameters(countStmt, mappedStatement, boundSql, parameterObject);
                    ResultSet rs = countStmt.executeQuery();
                    Integer count = 0;
                    if (rs.next()) {
                        count = rs.getInt(1);
                    }
                    rs.close();
                    countStmt.close();
                    page.setTotal(count);
                }
                String pageSql = generatePageSql(sql, page);
                ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); // 将分页sql语句反射回BoundSql.
            }
            // }
        }
        return ivk.proceed();
    }

    private final static Pattern SQL_PATTERN = Pattern.compile("(select)(?:(?!select|from)[\\s\\S])*?from", Pattern.CASE_INSENSITIVE);
    private final static Pattern ORDERBY_PATTERN = Pattern.compile("order\\s+by(?:(?!select |from |group |order |\\))[\\s\\S])*", Pattern.CASE_INSENSITIVE);
    private final static Pattern GROUPBY_PATTERN = Pattern.compile("group\\s+by(?:(?!select |from |group |order |\\))[\\s\\S])*", Pattern.CASE_INSENSITIVE);

    private static String generateCountSql(String sql) {
        String tmpSql = sql.trim();
        //含group by
        Matcher matcher = GROUPBY_PATTERN.matcher(sql);
        if (matcher.find()) {
            return "select count(0) from (" + sql + ") a "; // 记录统计
        }

        matcher = SQL_PATTERN.matcher(tmpSql);
        Map<String, String> his = new HashMap<String, String>();
        int i = 0;
        while (matcher.find()) {
            if (tmpSql.indexOf(matcher.group()) == 0) {
                String matched = matcher.group();
                if (his.isEmpty() == false) {
                    for (String key : his.keySet())
                        matched = matched.replace(key, his.get(key));
                }
                sql = sql.replace(matched, "SELECT count(0) FROM");
                break;
            }
            String key = "{" + i + "}";
            his.put(key, matcher.group());
            tmpSql = tmpSql.replace(matcher.group(), key);
            matcher = SQL_PATTERN.matcher(tmpSql);
        }
        //去掉order by
        matcher = ORDERBY_PATTERN.matcher(sql);
        if (matcher.find()) return matcher.replaceFirst("");
        return sql;
    }

    /**
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler
     *
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject)
            throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);

        /*
         * ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
         * List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
         * if (parameterMappings != null) {
         * Configuration configuration = mappedStatement.getConfiguration();
         * TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
         * MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);
         * for (int i = 0; i < parameterMappings.size(); i++) {
         * ParameterMapping parameterMapping = parameterMappings.get(i);
         * if (parameterMapping.getMode() != ParameterMode.OUT) {
         * Object value;
         * String propertyName = parameterMapping.getProperty();
         * PropertyTokenizer prop = new PropertyTokenizer(propertyName);
         * if (parameterObject == null) {
         * value = null;
         * } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
         * value = parameterObject;
         * } else if (boundSql.hasAdditionalParameter(propertyName)) {
         * value = boundSql.getAdditionalParameter(propertyName);
         * } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) {
         * value = boundSql.getAdditionalParameter(prop.getName());
         * if (value != null) {
         * value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
         * }
         * } else {
         * value = metaObject == null ? null : metaObject.getValue(propertyName);
         * }
         * TypeHandler typeHandler = parameterMapping.getTypeHandler();
         * if (typeHandler == null) {
         * throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+
         * mappedStatement.getId());
         * }
         * try{
         * typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
         * }catch(SQLException e){
         * e.printStackTrace();
         * }
         * }
         * }
         * }
         */
    }

    /**
     * 根据数据库方言，生成特定的分页sql
     *
     * @param sql
     * @param page
     * @return
     */
    private String generatePageSql(String sql, PageHelper page) {
        if (page != null && dialect != null) {
            int currentPage = page.getPage() - 1;
            StringBuffer pageSql = new StringBuffer();
            if ("mysql".equals(dialect)) {
                pageSql.append(sql);
                pageSql.append(" limit " + currentPage * page.getPage() + "," + page.getRows());
            } else if ("oracle".equals(dialect)) {
                pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
                pageSql.append(sql);
                pageSql.append(") tmp_tb where ROWNUM<=");
                pageSql.append(page.getPageEnd());
                pageSql.append(") where row_id>");
                pageSql.append(page.getPageOffset());
            }
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    @Override
    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, this);
    }

    @Override
    public void setProperties(Properties p) {
        dialect = p.getProperty("dialect");
        if (dialect == null || dialect.length() == 0) {
            try {
                throw new Exception("dialect property is not found!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

}
