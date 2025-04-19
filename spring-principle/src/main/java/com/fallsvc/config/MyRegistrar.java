package com.fallsvc.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/19  21:51
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar{
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition beanDefinition=new GenericBeanDefinition();
        beanDefinition.setBeanClass(Config.class);
        registry.registerBeanDefinition("config1",beanDefinition);
    }
}
