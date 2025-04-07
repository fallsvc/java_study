package com.fallsvc.demo.common.advice;

import com.fallsvc.demo.common.exception.BlogException;
import com.fallsvc.demo.pojo.response.Result;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:14
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        log.error("发生异常，e:",e);
        return Result.fail(e.getMessage());
    }
    @ExceptionHandler
    public Result exceptionHandler(BlogException e){
        log.error("发生异常，e:",e);
        return Result.fail(e.getMessage());
    }
    @ExceptionHandler
    public Result exceptionHandler(HandlerMethodValidationException e){
        String messageSourceResolvable = e.getAllErrors()
                .stream().findFirst().get().getDefaultMessage();
        log.error("发生异常，e:{}",e.getMessage());
        return Result.fail(messageSourceResolvable);
    }
    @ExceptionHandler
    public Result exceptionHandler(MethodArgumentNotValidException e){
        String msg=e.getBindingResult().getFieldError().getDefaultMessage();
        log.error("发生异常，e:{}",e.getMessage());
        return Result.fail(msg);
    }
}
