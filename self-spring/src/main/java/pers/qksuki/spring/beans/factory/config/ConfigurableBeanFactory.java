package pers.qksuki.spring.beans.factory.config;

import pers.qksuki.spring.beans.factory.BeanFactory;

/**
 * 可配置bean工厂
 *
 * @author qksuki
 * @date 2025-04-28 02:01:13
 */
public interface ConfigurableBeanFactory extends BeanFactory {
	String SCOPE_SINGLETON = "singleton";
	String SCOPE_PROTOTYPE = "prototype";
}
