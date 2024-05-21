package cn.falls.test;

import cn.falls.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  20:44
 */
public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("init...");
    }
    @After
    public void des(){
        System.out.println("destroy...");
    }
    @Test
    public void testAdd(){
        System.out.println("执行了。。。。");
        //创建对象
        Calculator calculator=new Calculator();
        //调用方法
        int result= calculator.add(2,3);
        Assert.assertEquals(5,result);
    }
    @Test
    public void testSub(){
        System.out.println("sub...");
        //创建对象
        Calculator calculator=new Calculator();
        //调用方法
        int result= calculator.sub(2,3);
        Assert.assertEquals(-1,result);
    }
}
