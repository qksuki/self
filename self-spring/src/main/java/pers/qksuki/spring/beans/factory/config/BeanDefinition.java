package pers.qksuki.spring.beans.factory.config;

import lombok.Data;
import pers.qksuki.spring.beans.PropertyValues;

/**
 * bean定义
 *
 * @author qksuki
 * @date 2025-04-24 05:44:13
 */
@Data
public class BeanDefinition {
	/**
	 * bean class
	 */
	private Class beanClass;

	private PropertyValues propertyValues;

	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
		this.propertyValues = new PropertyValues();
	}

	public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
		this.beanClass = beanClass;
		this.propertyValues = propertyValues != null
				? propertyValues
				: new PropertyValues();
	}
}

