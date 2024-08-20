package com.check;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//import com.check.DTO.UsersCheckedIn;
import com.check.models.User;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@ComponentScan(basePackages = {
                "com.common.*","com.logger.*","com.check.*"
})
public class CheckWorkApplication {
//    private static final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    public static void main(String[] args) {
//        UsersCheckedIn.getInstance();
        SpringApplication.run(CheckWorkApplication.class, args);
//        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanFactory);
//        String scanPackages = "com.common.*,com.logger.*,com.check.*";
//        String[] basePackages = scanPackages.split(",");
//        for (String basePackage : basePackages) {
//            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
//            for (BeanDefinition candidate : candidates) {
//                String beanName = this.beanNameGenerator.generateBeanName(candidate, beanFactory);
//                System.out.println(beanName);
//            }
//        }
    }
}