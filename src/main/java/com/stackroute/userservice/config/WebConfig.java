//package com.stackroute.userservice.config;
//
//
//import org.apache.catalina.servlets.WebdavServlet;
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.ServletRegistration;
//
//@Configuration
//public class WebConfig {
//    @Bean
//    ServletRegistrationBean h2servlet()
//    {
//        ServletRegistrationBean registrationBean= new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }
//};
