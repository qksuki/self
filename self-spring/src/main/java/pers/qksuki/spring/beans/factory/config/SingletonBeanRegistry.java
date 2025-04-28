package pers.qksuki.spring.beans.factory.config;

/**
 * 单例 bean 注册借口
 *
 * @author qksuki
 * @date 2025-04-24 06:36:29
 */
public interface SingletonBeanRegistry {

	/**
	 * 获取单例 bean
	 *
	 * @param beanName bean名字
	 * @return {@link Object }
	 */
	Object getSingleton(String beanName);
}

