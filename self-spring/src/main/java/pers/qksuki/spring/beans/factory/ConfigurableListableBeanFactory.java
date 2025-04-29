package pers.qksuki.spring.beans.factory;

import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.factory.config.AutowireCapableBeanFactory;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;
import pers.qksuki.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * 可配置可列表bean工厂
 *
 * @author qksuki
 * @date 2025-04-28 01:49:30
 */
public interface ConfigurableListableBeanFactory extends
		ConfigurableBeanFactory, ListableBeanFactory, AutowireCapableBeanFactory {

	BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}

