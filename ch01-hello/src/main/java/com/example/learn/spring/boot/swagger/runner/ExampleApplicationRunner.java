package com.example.learn.spring.boot.swagger.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@Component
public class ExampleApplicationRunner implements ApplicationRunner, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ExampleApplicationRunner.class);

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, HandlerMapping> handlerMappingMap = applicationContext.getBeansOfType(HandlerMapping.class);
        logger.info("handlerMappingMap: {}", handlerMappingMap);
    }
}
