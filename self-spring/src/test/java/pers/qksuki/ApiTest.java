package pers.qksuki;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pers.qksuki.spring.beans.PropertyValue;
import pers.qksuki.spring.beans.PropertyValues;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;
import pers.qksuki.spring.beans.factory.config.BeanReference;
import pers.qksuki.spring.beans.factory.support.DefaultListableBeanFactory;
import pers.qksuki.test.dao.UserDAO;
import pers.qksuki.test.service.UserService;

public class ApiTest {
	@Test
	void test_BeanFactory() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition userDAOBeanDefinition = new BeanDefinition(UserDAO.class);
		beanFactory.registerBeanDefinition("userDAO", userDAOBeanDefinition);

		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("userDAO", new BeanReference("userDAO")));

		BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
		beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);

		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserName("10001");
	}
}

