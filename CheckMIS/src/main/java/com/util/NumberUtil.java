package com.util;

import java.math.BigDecimal;

public class NumberUtil {
	public static Double add(Double d1,Double d2){
		if(null==d1) d1=0d;
		if(null==d2) d2=0d;
		BigDecimal bd1=new BigDecimal(d1.toString());
		BigDecimal bd2=new BigDecimal(d2.toString());
		return bd1.add(bd2).doubleValue();
	}
	
	public static String format2StrCut(double d){
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");  
		d=format2dCut(d);
		String ds=df.format(d);
		return ds;
	}
	public static Double format2dCut(double d){
		String doublestr=d+"";//转换字符串
		if(doublestr.indexOf(".")>-1){
			String[]xx=doublestr.split("\\.");//拆分
			if(xx[1].length()>2){//判断小数位
				xx[1]=xx[1].substring(0, 2);//截取
				d=Double.parseDouble(xx[0]+"."+xx[1]);//合并
			}
		}
		return d;
	}
	
	public static Double divide2d(Double d1,Double d2){
		if(null==d1) d1=0d;
		if(null==d2) return 0d;
		BigDecimal bd1=new BigDecimal(d1.toString());
		BigDecimal bd2=new BigDecimal(d2.toString());
		return format2dCut(bd1.divide(bd2).doubleValue());
	}
	public static Double multi2d(Double d1,Double d2){
		if(null==d1) d1=0d;
		if(null==d2) return 0d;
		BigDecimal bd1=new BigDecimal(d1.toString());
		BigDecimal bd2=new BigDecimal(d2.toString());
		return format2dCut(bd1.multiply(bd2).doubleValue());
	}
	
}
