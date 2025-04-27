package pers.qksuki.spring;

/**
 * bean 异常
 *
 * @author qksuki
 * @date 2025-04-24 06:36:02
 */
public class BeansException extends RuntimeException {
	public BeansException(String message) {
		super(message);
	}

	public BeansException(String message, Throwable cause) {
		super(message, cause);
	}
}

