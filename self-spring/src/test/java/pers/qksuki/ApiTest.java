package pers.qksuki;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pers.qksuki.spring.beans.factory.BeanDefinition;
import pers.qksuki.spring.beans.support.DefaultListableBeanFactory;
import pers.qksuki.test.service.UserService;

public class ApiTest {
	@Test
	void test_BeanFactory() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		beanFactory.registerBeanDefinition("userService", beanDefinition);

		UserService userService_1 = (UserService) beanFactory.getBean("userService", "dingzhen");
		Assertions.assertEquals("dingzhen",userService_1.getName());
	}
}

