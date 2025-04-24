package pers.qksuki;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pers.qksuki.spring.BeanDefinition;
import pers.qksuki.spring.BeanFactory;
import pers.qksuki.test.service.UserService;

@ExtendWith(MockitoExtension.class)
public class ApiTest {
	@Test
	void test_BeanFactory() {
		// 1.初始化 BeanFactory
		BeanFactory beanFactory = new BeanFactory();

		// 2.注册 bean
		BeanDefinition beanDefinition = new BeanDefinition(new UserService());
		beanFactory.registerBeanDefinition("userService", beanDefinition);

		// 3.获取 bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		Assertions.assertNotNull(userService);
	}
}

