package pers.qksuki.spring.beans.support;

import pers.qksuki.spring.BeansException;
import pers.qksuki.spring.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 自动装配 bean 工厂
 *
 * @author qksuki
 * @date 2025-04-24 06:36:57
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;

		try {
			bean = createBeanInstance(beanDefinition, beanName, args);
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}

		addSingleton(beanName, bean);
		return bean;
	}

	protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
		Constructor ctor = null;
		Class beanClass = beanDefinition.getBeanClass();
		Constructor[] dctors = beanClass.getDeclaredConstructors();
		for (Constructor dctor : dctors) {
			if (args != null && dctor.getParameterTypes().length == args.length) {
				ctor = dctor;
				break;
			}
		}
		return this.instantiationStrategy.instantiate(
				beanDefinition,
				beanName,
				ctor,
				args
		);
	}
}

