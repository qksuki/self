package pers.qksuki.spring.beans.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import pers.qksuki.spring.BeansException;
import pers.qksuki.spring.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Cglib子类化实例化策略
 *
 * @author qksuki
 * @date 2025-04-25 02:40:58
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
	@Override
	public Object instantiate(BeanDefinition beanDefinition,
	                          String beanName,
	                          Constructor constructor,
	                          Object[] args) throws BeansException {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(beanDefinition.getBeanClass());
		enhancer.setCallback(new NoOp() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		});
		return constructor == null
				? enhancer.create()
				: enhancer.create(constructor.getParameterTypes(), args);
	}
}

