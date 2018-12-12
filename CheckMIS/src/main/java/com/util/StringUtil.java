package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class StringUtil {
	private static Logger logger=Logger.getLogger(StringUtil.class);
	public  static final String ISNULL="isNull";
	public static final String ISNOTNULL="isNotNull";
	public static final String EMPTYID="-1";
	public static final String DAILYSALARY="dailysalary";
	public static  boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}
	public static  boolean equal(Object obj1, Object obj2) {
		return obj1 == null ? obj2 == null : obj1.toString().equalsIgnoreCase(toStr(obj2));
	}
	public static String toStr(Object o){
		return o==null?"":o.toString();
	}
	public static <K,V>HashMap<K, V> newmapinstance(){
		return new HashMap<K, V>();
	}
	public static <E>List<E> newListInstance(){
		return new ArrayList<E>();
	}
	
	public static boolean isEmpty(String str){
		return str==null?true:"".equals(str);
	}
	public static String checkNullForQuery(String obj){
		return obj==null?ISNULL:obj;
	}
	public static Integer checkNullForQuery(Integer obj){
		return obj==null?-1:obj;
	}
	public static String getStringCell(Row row,int index){
		return getStringCellNull(row, index, null, "");
	}
	public static Double getDoubleCellNull(Row row,int index,StringBuilder sb,String column){
		String str= getStringCellNull(row, index, sb, column);
		if(null!=str){
			try {
				return Double.parseDouble(str);
			} catch (NumberFormatException e) {
				sb.append(column+"必须是数字");
			}
		}
		return 0d;
	}
	public static Double getDoubleCellNull(Row row,int index,StringBuilder sb,Row rowtitle){
		String column=getStringCell(rowtitle, index);
		return getDoubleCellNull(row, index, sb, column);
	}
	public static String getStringCellNull(Row row,int index,StringBuilder sb,String column) {
		Cell cell=row.getCell(index);
		if(null==cell){
			logger.info(row.getRowNum()+"cell"+index +"is null");
			return null;
		}
		DataFormatter FORMATTER = new DataFormatter();
		String result=null;
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
			result= FORMATTER.formatCellValue(cell);
		else //if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
			result= cell.getStringCellValue();
		if(null!=sb && column!=null && isEmpty(result)){
			sb.append(column+"不能为空  ");
		}
		if(!isEmpty(result)){
			result=result.trim();
		}
		return result;
	}
	public static String getStringCellNull(Row row,int index,StringBuilder sb,Row rowtitle) {
		String column=getStringCell(rowtitle, index);
		return getStringCellNull(row, index, sb, column);
	}
	public static String getNonNullStringCell(Row row,int index,StringBuilder sb,String column) {
		Cell cell=row.getCell(index);
		if(null==cell){
			logger.info(row.getRowNum()+"cell"+index +"is null");
			if (sb != null && column!=null) {
				sb.append(column+" 不能为空  ");
			}
			return null;
		}
		DataFormatter FORMATTER = new DataFormatter();
		String result=null;
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
			result= FORMATTER.formatCellValue(cell);
		else //if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
			result= cell.getStringCellValue();
		if(null!=sb && column!=null && isEmpty(result)){
			sb.append(column+"不能为空  ");
		}
		if(!isEmpty(result)){
			result=result.trim();
		}
		return result;
	}
	public static String getStringCeleValid(Row row,int index,StringBuilder sb,String column,Map<String,String>map){
		String result=getStringCellNull(row, index, sb, column);
		if(!isEmpty(result)){
			String tmp=result;
			if("实用门幅".equals(column)){
				result=result.trim()+"cm";//代码中添加cm
			}
			result=map.get(result);
			if(isEmpty(result)){
				sb.append(column+"内容不正确，找不到对应的下拉项目:"+tmp+"  ");
			}
		}
		return result;
	}
	
	public static Integer  getIntegerCell(Row row,int index){
		return Integer.parseInt(getStringCell(row, index));
	}
	public static Double getDoubleCell(Row row,int index){
		String cell=getStringCell(row, index);
		if(StringUtil.isEmpty(cell)){
			return null;
		}
		return Double.parseDouble(cell);
	}
	public static Double parseDouble(String dd){
		try {
			return isEmpty(dd)?null:Double.parseDouble(dd);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(dd+"不是正确的数字");
		}
	}
	public static Integer parseInteger(String dd){
		try {
			return isEmpty(dd)?null:Integer.parseInt(dd);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(dd+"不是正确的数字");
		}
	}
}
