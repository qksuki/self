package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 * @author qksuki
 * @date 2025-04-25 02:02:40
 */
public interface InstantiationStrategy {

	/**
	 * 实例化
	 *
	 * @param beanDefinition bean定义
	 * @param beanName       bean名字
	 * @param constructor    构造函数
	 * @param args           args
	 * @return {@link Object }
	 * @throws BeansException bean异常
	 */
	Object instantiate(BeanDefinition beanDefinition,
	                   String beanName,
	                   Constructor constructor,
	                   Object[] args) throws BeansException;
}

