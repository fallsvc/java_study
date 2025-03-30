package com.fallsvc.demo.pojo.response;

import com.fallsvc.demo.enums.ResultCodeEnums;
import lombok.Data;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  21:32
 */
@Data
public class Result {
    private ResultCodeEnums code;
    private String errMsg;
    private Object data;
    public static Result success(Object object){
        Result result=new Result();
        result.setData(object);
        result.setCode(ResultCodeEnums.SUCCESS);
        return result;
    }

    public static Result fail(String errMsg){
        Result result=new Result();
        result.setCode(ResultCodeEnums.FAIL);
        result.setErrMsg(errMsg);
        return result;
    }
    public static Result fail(String errMsg,Object object){
        Result result=new Result();
        result.setCode(ResultCodeEnums.FAIL);
        result.setErrMsg(errMsg);
        result.setData(object);
        return result;
    }


}
