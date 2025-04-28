package pers.qksuki.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.PropertyValue;
import pers.qksuki.spring.beans.PropertyValues;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;
import pers.qksuki.spring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.util.Arrays;

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
			applyPropertyValues(beanName, bean, beanDefinition);
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}

		addSingleton(beanName, bean);
		return bean;
	}

	/**
	 * 应用属性值
	 *
	 * @param beanName       bean名字
	 * @param bean           豆
	 * @param beanDefinition bean定义
	 */
	protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
		try {
			PropertyValues propertyValues = beanDefinition.getPropertyValues();
			PropertyValue[] pvs = propertyValues.getPropertyValues();
			Arrays.stream(pvs)
					.forEach(pv -> {
						String propertyName = pv.getName();
						Object propertyValue = pv.getValue();

						if (propertyValue instanceof BeanReference) {
							// A 依赖 B，获取 B 的实例
							BeanReference beanReference = (BeanReference) propertyValue;
							propertyValue = getBean(beanReference.getBeanName());
						}

						// 属性填充
						BeanUtil.setFieldValue(bean, propertyName, propertyValue);
					});
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed: " + beanName, e);
		}
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

