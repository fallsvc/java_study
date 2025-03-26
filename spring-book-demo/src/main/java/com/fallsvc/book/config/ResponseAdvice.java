package com.fallsvc.book.config;

import com.fallsvc.book.model.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.aopalliance.aop.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/24  20:51
 */

/**
 * 同一返回规定
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;// 定义需要统一返回
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof String){
            return objectMapper.writeValueAsString(Result.success(body));// 对象转json
        }
        // 已经是Result对象就直接处理json，不需要再封装
        if(body instanceof Result){
            return body;
        }

        return Result.success(body);
    }
}
