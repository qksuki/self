package pers.qksuki;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.qksuki.spring.beans.PropertyValue;
import pers.qksuki.spring.beans.PropertyValues;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;
import pers.qksuki.spring.beans.factory.config.BeanReference;
import pers.qksuki.spring.beans.factory.support.DefaultListableBeanFactory;
import pers.qksuki.spring.beans.factory.xml.XMLBeanDefinitionReader;
import pers.qksuki.spring.core.io.ClassPathResource;
import pers.qksuki.spring.core.io.DefaultResourceLoader;
import pers.qksuki.spring.core.io.Resource;
import pers.qksuki.test.dao.UserDAO;
import pers.qksuki.test.service.UserService;

import java.io.IOException;
import java.io.InputStream;

class ApiTest {
	private final DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

	@Test
	void test_classpath() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:important.properties");
		InputStream inputStream = resource.getInputStream();
		String s = IoUtil.readUtf8(inputStream);
		System.out.println(s);
	}

	@Test
	void test_file() throws IOException {
		Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
		InputStream inputStream = resource.getInputStream();
		String s = IoUtil.readUtf8(inputStream);
		System.out.println(s);
	}

	@Test
	void test_xml() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("classpath:spring.xml");

		UserService userService = beanFactory.getBean("userService", UserService.class);
		userService.queryUserName("10001");
	}

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

