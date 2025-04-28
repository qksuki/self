package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 简单实例化策略
 *
 * @author qksuki
 * @date 2025-04-25 02:34:04
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
	@Override
	public Object instantiate(BeanDefinition beanDefinition,
	                          String beanName,
	                          Constructor constructor,
	                          Object[] args) throws BeansException {
		Class beanClass = beanDefinition.getBeanClass();
		try {
			return constructor != null
					? beanClass.getDeclaredConstructor(
					constructor.getParameterTypes()).newInstance()
					: beanClass.getDeclaredConstructor().newInstance();
		} catch (NoSuchMethodException
		         | InstantiationException
		         | IllegalAccessException
		         | InvocationTargetException e) {
			throw new BeansException("Failed to instantiate bean " + beanName, e);
		}
	}
}

