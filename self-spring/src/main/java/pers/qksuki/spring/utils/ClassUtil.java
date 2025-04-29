package pers.qksuki.spring.utils;

/**
 * 类工具类
 *
 * @author qksuki
 * @date 2025-04-28 01:42:55
 */
public class ClassUtil {
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back to system class loader...
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = ClassUtil.class.getClassLoader();
		}
		return cl;
	}
}

