package com.fallsvc.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/19  14:46
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

@Import(MySelector.class)
public @interface EnableConfigs {
}
