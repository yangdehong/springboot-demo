//package com.ydh.redsheep.base.common.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @description:
// * @author: yangdehong
// * @version: 2017/9/14.
// */
//@Aspect
//@Component
//public class MyAspect {
//
//    @Pointcut("execution(public * com.ydh.redsheep.test.controller.*Controller.*(..))")
//    public void pointcut(){
//    }
//
//    @Before("pointcut()")
//    public void doBefore(){
//        System.out.println("before before before before before ");
//    }
//
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//
//        String url = request.getRequestURL().toString();
//        String method = request.getMethod();
//        String uri = request.getRequestURI();
//        String queryString = request.getQueryString();
//
//        String log = String.format("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
//        System.out.println(log);
//
//        // result的值就是被拦截方法的返回值
//        Object result = proceedingJoinPoint.proceed();
//        return result;
//    }
//
//    @After("pointcut()")
//    public void doAfter(){
//        System.out.println("after after after after after ");
//    }
//
//    @AfterReturning(pointcut = "pointcut()", returning = "object")
//    public void doAfterReturn(Object object){
//        System.out.println("return return return return return " + object.toString());
//    }
//
//    @AfterThrowing("pointcut()")
//    public void doAfterThrowing(){
//        System.out.println("exception exception exception exception exception ");
//    }
//
//}
