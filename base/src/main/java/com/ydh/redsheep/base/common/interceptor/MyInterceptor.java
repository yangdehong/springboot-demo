//package com.ydh.redsheep.base.common.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @description: 自定义拦截器
// * @author: yangdehong
// * @version: 2017/9/22.
// */
//@WebServlet
//public class MyInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                             Object o) throws Exception {
//        System.out.println("拦截器11111");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                           Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("拦截器22222");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                                Object o, Exception e) throws Exception {
//        System.out.println("拦截器33333");
//    }
//
//}
