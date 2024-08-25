package com.ydh.redsheep.database.common.bo;

import lombok.Data;

@Data
public class Result<T> {

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "成功";
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "失败";

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success() {
        return success(SUCCESS_CODE, null, SUCCESS_MESSAGE);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(200);
        return result;
    }

    public static <T> Result<T> success(T data, String msg) {
        return success(SUCCESS_CODE, data, msg);
    }

    public static <T> Result<T> success(int code, T data, String msg) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error() {
        return error(ERROR_CODE, ERROR_MESSAGE);
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
