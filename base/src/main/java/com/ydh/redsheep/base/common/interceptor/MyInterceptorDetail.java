//package com.ydh.redsheep.base.common.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * @description: 拦截器 设置拦截
// * @author: yangdehong
// * @version: 2017/9/22.
// */
//@Configuration
//public class MyInterceptorDetail extends WebMvcConfigurationSupport {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/**")/*.excludePathPatterns("/test/test")*/;
//
//        super.addInterceptors(registry);
//
//    }
//}
