package com.github.akazver.poc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

@Aspect
public class SpringBootInterceptAspect {

    private static final Logger LOGGER = Logger.getLogger(SpringBootInterceptAspect.class.getName());

    @Before("execution(* main(..)) && within(com.example.demo..*)")
    public void execute() {
        LOGGER.info("Hello from AspectJ");
    }

}
