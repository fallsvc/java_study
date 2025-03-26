package com.fallsvc.book.model;

import com.fallsvc.book.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/20  19:04
 */
@Data
public class Result<T> {
    private ResultCodeEnum code;// -1 未登录 -2后端错误 200 后端正常响应
    private String errMsg;
    private T data;

    public static <T> Result success(T data){
        Result<T> result=new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }
    public static <T> Result fail(String msg){
        Result<T> result=new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(msg);
        result.setData(null);
        return result;
    }
    public static <T> Result unlogin(){
        Result<T> result=new Result();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("用户未登录");
        return result;
    }
}
