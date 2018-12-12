package com.util;

import com.biz.dto.gzjl.GzjhDto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	private static SimpleDateFormat sdfday=new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf8=new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdfmonth=new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat sdfmonth2=new SimpleDateFormat("MM.dd");

	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat onlyMonth = new SimpleDateFormat("MM");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat sdfTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static  String formateDate10(Date date){
		return sdfday.format(date);
	}
	public static  String formateDate18(Date date){
		return sdfTime.format(date);
	}

	public static  String formateDate14(Date date){
		return sdfTime2.format(date);
	}
	public static  String formateDate7(Date date){
		return sdfmonth.format(date);
	}
	public static  String formateDatesdf8(Date date){
		return sdf8.format(date);
	}

	public static Date parseDate10(String date){
		try {
			return sdfday.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date parseDate18(String date){
		try {
			return sdfTime.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date parseDate14(String date){
		try {
			return sdfTime2.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date parseDate7(String date){
		try {
			return sdfmonth.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getMonth(){
		return onlyMonth.format(new Date());
	}

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        
        return dateStr;
    }

    public static String getMonthDay(Date date){
    	return sdfmonth2.format(date);
	}
    

	public static List<Date> datesListInRange(Date start,Date end){
		List<Date>r=new ArrayList<>();
		Calendar endcal=Calendar.getInstance();
		endcal.setTime(end);
		r.add(start);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(start);
		while (true){
			calendar.add(Calendar.DATE,1);
			if(calendar.compareTo(endcal)>0){
				break;
			}
			r.add(calendar.getTime());
		}
		return r;
	}
//	public static  boolean isDateBetween(Date d,Date s,Date e){
//    	return d
//	}
	public static Map<String,Integer> getHourMinute(Date d){
    	Calendar c=Calendar.getInstance();
    	c.setTime(d);
    	Map<String,Integer>m=new HashMap<>();
    	m.put("h",c.get(Calendar.HOUR_OF_DAY));
    	m.put("m",c.get(Calendar.MINUTE));
    	return m;
	}
	public static boolean hourMinuteCheck(Date check1,Date check2,Date range1,Date range2){
    	Date d1=DateUtil.parseDate18("2018-10-23"+DateUtil.formateDate18(check1).substring(10));
    	Date d2=DateUtil.parseDate18("2018-10-23"+DateUtil.formateDate18(check2).substring(10));
    	Date d3=DateUtil.parseDate18("2018-10-23"+DateUtil.formateDate18(range1).substring(10));
    	Date d4=DateUtil.parseDate18("2018-10-23"+DateUtil.formateDate18(range2).substring(10));
    	return d1.getTime()>=d4.getTime() || d2.getTime()<=d3.getTime();

	}
	public static boolean dayCheck(Date check1,Date check2,Date range1,Date range2){
		return check1.getTime()>=range2.getTime() || check2.getTime()<=range1.getTime();
	}


    public static boolean dateInRange(Date c1,Date c2, GzjhDto range){
    	Date s=range.getStart();
    	Date e=range.getEnd();
    	if(!dayCheck(c1,c2,range.getStart(),range.getEnd())){//天在包含范围
//			判断时间
			if(!hourMinuteCheck(c1,c2,s,e)){
				return true;
			}

		}
    	return false;
	}
	public static boolean dateInRange(Date c1,Date c2, List<GzjhDto>ranges){
		System.out.println(formateDate18(c1));
		System.out.println(formateDate18(c2));
    	for(GzjhDto r:ranges){
    		if(dateInRange(c1,c2,r)){
    			String t="工作";
    			if("1".equals(r.getJhlx())){
    				t="休息";
				}
				if("2".equals(r.getJhlx())){
					t="其他";
				}
    			throw new BaseException("选择时间和"+formateDate14(r.getStart())+"-"+DateUtil.formateDate14(r.getEnd())+"的"+t+"计划有重合");
			}
		}
		return false;
	}

	public static Date getDayEndOfDay(Date date){
    	String d=formateDate10(date)+" 23:59:59";
		return parseDate18(d);
	}
	public static Date getDayTime(Date date,String time){
		String d=formateDate10(date)+" "+time+":00";
		return parseDate18(d);
	}

	public static void main(String[] args) {
		Date dx = parseDate18("2018-10-22  08:09:00");
		Date dx2 = parseDate18("2018-10-23  08:10:00");
		Date d = parseDate18("2018-10-23 08:05:00");
		Date d2 = parseDate18("2018-10-23  08:10:00 ");
		GzjhDto g=new GzjhDto();
		g.setJhlx("3");
		g.setStart(d);
		g.setEnd(d2);
		System.out.println(dateInRange(dx,dx2,g));
	}
	
}
