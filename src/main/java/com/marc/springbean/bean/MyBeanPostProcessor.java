package com.marc.springbean.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: marc
 * @Date: 2020/12/14 10:55
 */
//BeanPostProcessor称为容器级生命周期接口方法，一般称为“后置处理器”
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor(){
        super();
        System.out.println("这是BeanPostProcess实现类构造器");
    }

    //第一个参数都是要处理的Bean对象，第二个参数都是bean的Name，返回值都是要处理的Bean对象
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcess接口方法postProcessBeforeInitialization对属性进行更改");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcess接口方法postProcessAfterInitialization对属性进行更改");
        return null;
    }
}
