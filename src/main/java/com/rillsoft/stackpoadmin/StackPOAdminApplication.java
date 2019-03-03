package com.rillsoft.stackpoadmin;
// package hello;		// commented by crane zhou on 10.08.2018

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;

/*
  added by crane zhou on 09.29.2018 for logback functions
  refer to: 
  https://wiki.base22.com/btg/how-to-setup-slf4j-and-logback-in-a-web-app-fast-35488048.html
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.rillsoft.stackpoadmin.mapper")
public class StackPOAdminApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(StackPOAdminApplication.class);

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(StackPOAdminApplication.class, args);
        
        LOG.trace("Hello World!");
        LOG.debug("How are you today?");
        LOG.info("I am fine.");
        LOG.warn("I love programming.");
        LOG.error("I am programming.");
    }
}
