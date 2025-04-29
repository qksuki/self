package pers.qksuki.spring.beans.factory;

import pers.qksuki.spring.beans.BeansException;

import java.util.Map;

/**
 * 可列bean工厂
 *
 * @author qksuki
 * @date 2025-04-28 01:53:04
 */
public interface ListableBeanFactory extends BeanFactory {

	/**
	 * 按照类型返回 Bean 实例
	 *
	 * @param type 类型
	 * @return {@link Map }<{@link String }, {@link T }>
	 * @throws BeansException bean异常
	 */
	<T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


	/**
	 * 获取bean定义名称
	 *
	 * @return {@link String[] }
	 */
	String[] getBeanDefinitionNames();

}

