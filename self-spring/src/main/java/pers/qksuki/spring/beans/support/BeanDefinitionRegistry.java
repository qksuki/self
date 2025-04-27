package pers.qksuki.spring.beans.support;

import pers.qksuki.spring.beans.factory.BeanDefinition;

/**
 * Bean定义注册中心
 *
 * @author qksuki
 * @date 2025-04-24 06:37:23
 */
public interface BeanDefinitionRegistry {

	/**
	 * 注册 bean 定义
	 *
	 * @param beanName       bean名字
	 * @param beanDefinition bean定义
	 */
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

