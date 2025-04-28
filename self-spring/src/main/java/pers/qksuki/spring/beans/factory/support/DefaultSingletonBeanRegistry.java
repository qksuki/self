package pers.qksuki.spring.beans.factory.support;

import pers.qksuki.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例bean注册
 *
 * @author qksuki
 * @date 2025-04-25 10:14:01
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	/**
	 * 单例对象
	 */
	private Map<String, Object> singletonObjects = new HashMap<>();

	/**
	 * 获取单例
	 *
	 * @param beanName bean名字
	 * @return {@link Object }
	 */
	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}

	/**
	 * 添加单例
	 *
	 * @param beanName        bean名字
	 * @param singletonObject 单例对象
	 */
	protected void addSingleton(String beanName, Object singletonObject) {
		this.singletonObjects.put(beanName, singletonObject);
	}
}

