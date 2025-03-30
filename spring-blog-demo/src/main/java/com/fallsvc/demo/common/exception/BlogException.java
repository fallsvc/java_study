package com.fallsvc.demo.common.exception;

import lombok.Data;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:12
 */
@Data
public class BlogException extends RuntimeException{
    private int code;
    private String message;

    public BlogException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
