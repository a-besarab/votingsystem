package ru.votingsystem;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        //UserRepository userRepository = (UserRepository) appCtx.getBean("userRepository");
        //userRepository = appCtx.getBean(UserRepository.class);
        appCtx.close();
    }
}