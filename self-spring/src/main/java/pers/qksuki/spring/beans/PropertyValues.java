package pers.qksuki.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性值
 *
 * @author qksuki
 * @date 2025-04-27 03:53:09
 */
public class PropertyValues {
	private final List<PropertyValue> propertyValueList = new ArrayList<>();

	/**
	 * 添加属性值
	 *
	 * @param propertyValue 属性值
	 */
	public void addPropertyValue(PropertyValue propertyValue) {
		propertyValueList.add(propertyValue);
	}

	/**
	 * 获取属性值
	 *
	 * @return {@link PropertyValue[] }
	 */
	public PropertyValue[] getPropertyValues() {
		return propertyValueList.toArray(new PropertyValue[0]);
	}

	/**
	 * 获取属性值
	 *
	 * @param propertyName 属性名
	 * @return {@link PropertyValue }
	 */
	public PropertyValue getPropertyValue(String propertyName) {
		return this.propertyValueList.stream()
				.filter(pv -> pv.getName().equals(propertyName))
				.findFirst()
				.orElse(null);
	}
}

