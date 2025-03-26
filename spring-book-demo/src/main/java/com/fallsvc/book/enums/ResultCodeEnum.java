package com.fallsvc.book.enums;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/20  19:16
 */
public enum ResultCodeEnum {
    UNLOGIN(-1),
    FAIL(-2),
    SUCCESS(200);
    private int code;

    ResultCodeEnum(int code) {
        this.code=code;
    }

}
