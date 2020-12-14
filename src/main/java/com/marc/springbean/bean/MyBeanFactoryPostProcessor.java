package com.marc.springbean.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author: marc
 * @Date: 2020/12/14 15:36
 */
//工厂后置处理器  工厂后置处理器也是容器级的。在应用上下文装配配置文件之后立即调用
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor(){
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition person = beanFactory.getBeanDefinition("person");
        person.getPropertyValues().addPropertyValue("phone","110");
    }
}
