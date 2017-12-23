package com.cskaoyan.crm.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtils;



public class CrmBeanUtils {

	public static void changeProperty(Object sourceBean, Object targetBean) {
		try {
			Class sourceClass = sourceBean.getClass();
			Class targetClass = targetBean.getClass();
			if(sourceClass != targetClass){
				throw new RuntimeException("sourceBean 和  targetBean 不是同一种javabean");
			}
			BeanInfo beanInfo = Introspector.getBeanInfo(sourceClass,Object.class);
			PropertyDescriptor[] allPD = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : allPD) {
				//1 获得属性名
				String propName = pd.getName();
				//2 获得属性值
				//String propValue = BeanUtils.getProperty(sourceBean, propName);
				Object propValue = pd.getReadMethod().invoke(sourceBean);
				//3 如果不为null，修改值
				if(propValue != null){
					BeanUtils.setProperty(targetBean, propName, propValue);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
