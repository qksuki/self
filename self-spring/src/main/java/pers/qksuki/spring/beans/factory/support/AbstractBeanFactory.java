package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.beans.factory.BeanFactory;
import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;

/**
 * 抽象bean工厂模板方法
 *
 * @author qksuki
 * @date 2025-04-24 06:37:08
 */
public abstract class AbstractBeanFactory
		extends DefaultSingletonBeanRegistry
		implements BeanFactory {

	@Override
	public Object getBean(String beanName) throws BeansException {
		return doGetBean(beanName, null);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return (T) getBean(name);
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		return doGetBean(name, args);
	}

	protected <T> T doGetBean(final String name, final Object[] args) {
		Object bean = getSingleton(name);
		if (bean != null) {
			return (T) bean;
		}

		BeanDefinition beanDefinition = getBeanDefinition(name);
		return (T) createBean(name, beanDefinition, args);
	}

	/**
	 * 获取bean定义
	 *
	 * @param beanName bean名字
	 * @return {@link BeanDefinition }
	 * @throws BeansException bean异常
	 */
	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	/**
	 * 创建bean
	 *
	 * @param beanName       bean名字
	 * @param beanDefinition bean定义
	 * @param args           arg游戏
	 * @return {@link Object }
	 * @throws BeansException bean异常
	 */
	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}

