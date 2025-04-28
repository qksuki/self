package pers.qksuki.spring.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * bean引用
 *
 * @author qksuki
 * @date 2025-04-27 03:50:40
 */
@Getter
@AllArgsConstructor
@ToString
public class BeanReference {
	private final String beanName;
}

