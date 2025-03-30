package com.fallsvc.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  21:33
 */
@AllArgsConstructor
public enum ResultCodeEnums {
    SUCCESS(200),
    FAIL(-1);
    @Getter @Setter
    private int code;
}
