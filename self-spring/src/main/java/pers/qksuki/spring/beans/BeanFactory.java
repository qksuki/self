package pers.qksuki.spring.beans;

/**
 * bean工厂
 *
 * @author qksuki
 * @date 2025-04-24 05:44:15
 */
public interface BeanFactory {

	/**
	 * 获取 bean
	 *
	 * @param beanName bean名字
	 * @return {@link Object }
	 * @throws BeansException bean异常
	 */
	Object getBean(String beanName) throws BeansException;

	/**
	 * 获取 bean
	 *
	 * @param beanName bean名字
	 * @param args     arg游戏
	 * @return {@link Object }
	 * @throws BeansException bean异常
	 */
	Object getBean(String beanName, Object... args) throws BeansException;
}

