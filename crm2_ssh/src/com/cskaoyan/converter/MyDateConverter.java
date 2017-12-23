package com.cskaoyan.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConverter extends StrutsTypeConverter {

	//��ǰ̨�û�����������
	//1999-10-12
	//10-12-1999
	//mm-dd-yyyy
	DateFormat  format = new  SimpleDateFormat("yyyy-MM-dd");
	//10-31-1998  arg1  
	//Date.class  arg2
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		Date parse=null;
		if (arg2==Date.class) {//��Ҫת��Ϊʱ�����Ͳ�ȥ����
			
			 try {
				  parse = format.parse(arg1[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
 		}
		return parse;
	}

	
	//�����ͣ�����ַ�
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("MyDateConverter.convertToString()"+arg1);
		return  "11";
	}

}
