package com.ydh.redsheep.base.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
@Configuration
public class MyFilterDetail {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        MyFilter myFilter = new MyFilter();
        registrationBean.setFilter(myFilter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/say/hello");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}
