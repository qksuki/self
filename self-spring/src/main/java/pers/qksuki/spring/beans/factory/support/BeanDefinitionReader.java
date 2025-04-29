package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.core.io.Resource;
import pers.qksuki.spring.core.io.ResourceLoader;

/**
 * Bean定义读取器
 *
 * @author qksuki
 * @date 2025-04-28 03:01:06
 */
public interface BeanDefinitionReader {

	BeanDefinitionRegistry getRegistry();

	ResourceLoader getResourceLoader();

	/**
	 * 加载bean定义
	 *
	 * @param resource 资源
	 * @throws BeansException bean异常
	 */
	void loadBeanDefinitions(Resource resource) throws BeansException;

	/**
	 * 加载bean定义
	 *
	 * @param resource 资源
	 * @throws BeansException bean异常
	 */
	void loadBeanDefinitions(Resource... resource) throws BeansException;


	/**
	 * 加载bean定义
	 *
	 * @param location 位置
	 * @throws BeansException bean异常
	 */
	void loadBeanDefinitions(String location) throws BeansException;

}

