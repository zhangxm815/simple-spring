package com.example.ioc;

import com.example.ioc.util.RegisterUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.lang.reflect.Field;

public class XmlBeanFactory extends AbstractBeanFactory {

    protected final Log logger = LogFactory.getLog(getClass());

    public XmlBeanFactory(String path) {

        try {
            loadBeans(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBeans(String path) throws Exception {
        InputStream is = getInputStream(path);
        Document doc = doLoadDocument(is);
        parseBeans(doc.getDocumentElement());

    }

    protected InputStream getInputStream(String path) throws Exception {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        return is;
    }


    private Document doLoadDocument(InputStream is) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);
        return document;
    }

    private void parseBeans(Element root) throws Exception {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                if (logger.isDebugEnabled()) {
                    logger.debug(ele.getTagName());
                }
                parseRegisterBean(ele);
            }
        }
    }

    private void parseRegisterBean(Element ele) throws Exception {

        String id = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        if (logger.isDebugEnabled()) {
            logger.debug("id:" + id + " class:" + className);
        }
        Class beanClass = Class.forName(className);
        Object bean = beanClass.newInstance();
        NodeList pns = ele.getElementsByTagName("property");
        for (int j = 0; j < pns.getLength(); j++) {
            Node propertyNode = pns.item(j);
            if (propertyNode instanceof Element) {
                Element pe = (Element) propertyNode;
                String name = pe.getAttribute("name");
                String value = pe.getAttribute("value");
                Field declaredField = bean.getClass().getDeclaredField(name);
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
        RegisterUtil.getRegister().registerBeans(id, bean);
    }

}
