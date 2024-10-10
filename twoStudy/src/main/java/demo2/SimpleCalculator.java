package demo2;

import java.util.Scanner;

public class SimpleCalculator {
  // 计算方法，根据操作符进行相应的计算
  public static double calculate(double num1, double num2, String operator) {
    // 逻辑实现：运算符解析与计算过程
    double ret=0;// 记录结果
    switch(operator){
      case "+"->ret=num1+num2;
      case "-"->ret=num1-num2;
      case "*"->ret=num1*num2;
      case "/"->ret=num1/num2;
    }

    return ret;
  }

  // 主方法
  public static void main(String[] args) {
    if(args.length != 3) {
      System.out.println("输入错误");
    }else {
      double v1 = Double.parseDouble(args[0]);
      double v2 = Double.parseDouble(args[2]);
      String operator = args[1];
      System.out.println(calculate(v1, v2, operator));
    }
  }

  public static void test(){
    Scanner scanner=new Scanner(System.in);
    while (scanner.hasNext()) {
      double d1=scanner.nextDouble();
      double d2=scanner.nextDouble();
      String s=scanner.next();
      System.out.println(calculate(d1, d2, s));
    }
  }

}