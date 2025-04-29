package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.core.io.DefaultResourceLoader;
import pers.qksuki.spring.core.io.ResourceLoader;

/**
 * 抽象bean定义读取器
 *
 * @author qksuki
 * @date 2025-04-28 03:04:13
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
	private final BeanDefinitionRegistry registry;
	private final ResourceLoader resourceLoader;

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
		this.resourceLoader = new DefaultResourceLoader();
	}

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
		this.registry = registry;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public BeanDefinitionRegistry getRegistry() {
		return this.registry;
	}

	@Override
	public ResourceLoader getResourceLoader() {
		return this.resourceLoader;
	}
}

