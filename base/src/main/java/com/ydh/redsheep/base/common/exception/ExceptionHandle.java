package com.ydh.redsheep.base.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/7/19.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandle(Exception e){
        System.out.println(e.getMessage());
        return e.getMessage();
    }

}
