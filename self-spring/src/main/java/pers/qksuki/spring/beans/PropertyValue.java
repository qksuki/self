package pers.qksuki.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 属性值
 *
 * @author qksuki
 * @date 2025-04-27 03:53:14
 */
@Data
@AllArgsConstructor
public class PropertyValue {
	private final String name;
	private final Object value;
}

