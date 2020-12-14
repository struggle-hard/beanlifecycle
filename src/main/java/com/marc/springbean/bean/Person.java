package com.marc.springbean.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @Author: marc
 * @Date: 2020/12/14 10:25
 * bean的生命周期
 */

//BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这些接口属于Bean级别声明周期接口的方法
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private String address;
    private int phone;
    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("[构造器]调用person的构造器实例化");
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        System.out.println("[注入属性]注入属性name");
        this.name=name;
    }
    public String getAddress(){
        return  address;
    }
    public void setAddress(String address){
        System.out.println("[注入属性]注入属性address");
        this.address=address;
    }
    public int getPhone(){
        return phone;
    }
    public void setPhone(int phone){
        System.out.println("【注入属性】注入属性phone");
        this.phone=phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    //这个是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory=arg0;
    }

    //这是BeanNameAware接口方法
    @Override
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName=s;
    }

    //这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiseSet()");
    }

    //这是DiposibleBean接口方法 diposible（一次性的）
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }
    //通过<bean>的init-method属性指定的初始化方法
    private void myInit(){
        System.out.println("【inti-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestory(){
        System.out.println("【destory-method】调用<bean>的destory-method属性指定的初始化方法");
    }
}
