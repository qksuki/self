package pers.qksuki.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源
 *
 * @author qksuki
 * @date 2025-04-28 01:46:35
 */
public interface Resource {

	/**
	 * 获取输入流
	 *
	 * @return {@link InputStream }
	 * @throws IOException ioexception
	 */
	InputStream getInputStream() throws IOException;
}

