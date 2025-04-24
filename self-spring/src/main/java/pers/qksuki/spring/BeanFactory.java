package pers.qksuki.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean工厂
 *
 * @author qksuki
 * @date 2025-04-24 05:44:15
 */
public class BeanFactory {
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	public Object getBean(String beanName) {
		return beanDefinitionMap.get(beanName).getBean();
	}

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
}

