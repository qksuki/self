package pers.qksuki.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pers.qksuki.spring.beans.BeansException;
import pers.qksuki.spring.beans.PropertyValue;
import pers.qksuki.spring.beans.factory.config.BeanDefinition;
import pers.qksuki.spring.beans.factory.config.BeanReference;
import pers.qksuki.spring.beans.factory.support.AbstractBeanDefinitionReader;
import pers.qksuki.spring.beans.factory.support.BeanDefinitionRegistry;
import pers.qksuki.spring.core.io.Resource;
import pers.qksuki.spring.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Xml bean 定义阅读器
 *
 * @author qksuki
 * @date 2025-04-28 01:47:44
 */
public class XMLBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XMLBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}

	public XMLBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
		super(registry, resourceLoader);
	}

	@Override
	public void loadBeanDefinitions(Resource resource) throws BeansException {
		try {
			try (InputStream inputStream = resource.getInputStream()) {
				doLoadBeanDefinitions(inputStream);
			}
		} catch (IOException | ClassNotFoundException e) {
			throw new BeansException("IOException occurred while loading XML definitions", e);
		}
	}

	@Override
	public void loadBeanDefinitions(Resource... resource) throws BeansException {
		Arrays.stream(resource).forEach(this::loadBeanDefinitions);
	}

	@Override
	public void loadBeanDefinitions(String location) throws BeansException {
		ResourceLoader resourceLoader = getResourceLoader();
		Resource resource = resourceLoader.getResource(location);
		loadBeanDefinitions(resource);
	}

	protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
		Document document = XmlUtil.readXML(inputStream);
		Element root = document.getDocumentElement();
		NodeList childNodes = root.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {
			// 判断元素
			if (!(childNodes.item(i) instanceof Element)) {
				continue;
			}

			// 判断对象
			if (!"bean".equals(childNodes.item(i).getNodeName())) {
				continue;
			}

			// 解析标签
			Element bean = (Element) childNodes.item(i);
			String id = bean.getAttribute("id");
			String className = bean.getAttribute("class");
			String name = bean.getAttribute("name");

			Class<?> clazz = Class.forName(className);
			// id > name
			String beanName = StrUtil.isNotEmpty(id) ? id : name;
			if (StrUtil.isNotEmpty(beanName)) {
				beanName = StrUtil.lowerFirst(clazz.getSimpleName());
			}

			// 定义 bean
			BeanDefinition beanDefinition = new BeanDefinition(clazz);
			// 读取属性
			for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
				// 判断元素
				if (!(bean.getChildNodes().item(j) instanceof Element)) {
					continue;
				}

				if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
					continue;
				}

				// 解析 property
				Element property = (Element) bean.getChildNodes().item(j);
				String attrName = property.getAttribute("name");
				String attrValue = property.getAttribute("value");
				String attrRef = property.getAttribute("ref");

				Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
				PropertyValue propertyValue = new PropertyValue(attrName, value);
				beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
			}

			if (getRegistry().containsBeanDefinition(beanName)) {
				throw new BeansException("Bean [" + beanName + "] already exists");
			}

			// 注册 bean
			getRegistry().registerBeanDefinition(beanName, beanDefinition);
		}
	}
}

