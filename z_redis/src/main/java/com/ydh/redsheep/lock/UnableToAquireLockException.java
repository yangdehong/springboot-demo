package com.ydh.redsheep.lock;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/2/12.
 */
public class UnableToAquireLockException extends RuntimeException {

    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
