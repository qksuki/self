package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认可列表bean工厂
 * 核心
 *
 * @author qksuki
 * @date 2025-04-25 11:04:03
 */
public class DefaultListableBeanFactory
		extends AbstractAutowireCapableBeanFactory
		implements BeanDefinitionRegistry {

	/**
	 * Bean 定义 Map
	 */
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		this.beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		return Optional.ofNullable(beanDefinitionMap.get(beanName))
				.orElseThrow(() -> new BeansException("No such bean: " + beanName));
	}
}

