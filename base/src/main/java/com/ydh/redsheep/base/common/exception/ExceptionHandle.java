package com.ydh.redsheep.base.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/7/19.
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandle(Exception e){
        log.error("{}", "错误信息", e);
        return e.getMessage();
    }

}
