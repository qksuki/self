package pers.qksuki.spring.core.io;

import cn.hutool.core.lang.Assert;
import lombok.AllArgsConstructor;
import pers.qksuki.spring.utils.ClassUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * 类路径资源
 *
 * @author qksuki
 * @date 2025-04-28 01:45:57
 */
public class ClassPathResource implements Resource {
	private final String path;

	private final ClassLoader classLoader;

	public ClassPathResource(String path) {
		this(path, null);
	}

	public ClassPathResource(String path, ClassLoader classLoader) {
		Assert.notNull(path, "path must not be null");
		this.path = path;
		this.classLoader = classLoader != null ? classLoader : ClassUtil.getDefaultClassLoader();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return Optional.ofNullable(classLoader.getResourceAsStream(path))
				.orElseThrow(() -> new FileNotFoundException(
						String.format("Resource '%s' not found", path)
				));
	}
}

