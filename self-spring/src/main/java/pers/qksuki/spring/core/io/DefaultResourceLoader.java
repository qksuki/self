package pers.qksuki.spring.core.io;

import cn.hutool.core.io.resource.UrlResource;
import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认资源加载器
 *
 * @author qksuki
 * @date 2025-04-28 01:46:15
 */
public class DefaultResourceLoader implements ResourceLoader {

	@Override
	public Resource getResource(String location) {
		Assert.notNull(location, "location must not be null");

		if (location.startsWith(CLASSPATH_URL_PREFIX)) {
			return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
		} else {
			try {
				URL url = new URL(location);
				return new URLResource(url);
			} catch (MalformedURLException e) {
				return new FileSystemResource(location);
			}
		}
	}
}

