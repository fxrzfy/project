package com.util;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCustomDateEditor extends PropertyEditorSupport {
	private static SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd"); 
	private static SimpleDateFormat dateTime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
	@Override
	public String getAsText() {
		Object v=getValue();
		if(null==v){
			return null;
		}
		Date value = (Date) getValue();
		String dateStr=dateTime.format(value);
		if(dateStr.endsWith("00:00:00")){
			return date.format(value);
		}else{
			return dateStr;
		}
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Date d=null;
		if(StringUtil.isEmpty(text)){
			setValue(null);
		}
		try {
			d=dateTime.parse(text);
		} catch (Exception e) {
		}
		if(d==null){
			try {
				d=dateTime.parse(text);
			} catch (Exception e) {
			}
		}
		if(d==null){
			throw new IllegalArgumentException("日期格式不正确:"+text);
		}
		setValue(d);
	}
	
}
