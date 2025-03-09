package com.fallsvc.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/9  20:19
 */
public class CaptchaTest {
    public static void main(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

//图形验证码写出，可以写出到文件，也可以写出到流
//        lineCaptcha.write("/line.png");
        System.out.println(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");

//重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("C:/Users/12092/Pictures/line.png");
//新的验证码
//        Console.log(lineCaptcha.getCode());
//验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
//CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
//图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("C:/Users/12092/Pictures/circle.png");
//验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }
}
