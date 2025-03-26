package com.fallsvc.book.config;

import com.fallsvc.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/24  22:34
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
//    @ExceptionHandler
//    public Result handler(Exception e){
//        log.error("发生异常，e:",e);
//        return Result.fail("内部错误");
//    }
//
//    @ExceptionHandler
//    public Result handler(NullPointerException e){
//        log.error("发生异常，e:",e);
//        return Result.fail("空指针异常");
//    }
//
//    @ExceptionHandler
//    public Result handler(ArithmeticException e){
//        log.error("发生异常，e:",e);
//        return Result.fail("算术异常");
//    }
    @ExceptionHandler(Exception.class)
    public Result handler(Exception e){
        log.error("发生异常，e:",e);
        return Result.fail("内部错误");
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handler1(Exception e){
        log.error("发生异常，e:",e);
        return Result.fail("空指针异常");
    }

    @ExceptionHandler(ArithmeticException.class)
    public Result handler2(Exception e){
        log.error("发生异常，e:",e);
        return Result.fail("算术异常");
    }
}
