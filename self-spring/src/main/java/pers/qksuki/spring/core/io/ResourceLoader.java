package pers.qksuki.spring.core.io;

/**
 * 资源加载器
 *
 * @author qksuki
 * @date 2025-04-28 01:46:55
 */
public interface ResourceLoader {
	String CLASSPATH_URL_PREFIX = "classpath:";

	Resource getResource(String location);
}

