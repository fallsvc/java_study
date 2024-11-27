package work3;

public class Calculator {
  public double add(Number x, Number y) {
    // 提示：转换成double类型计算
    return x.doubleValue()+y.doubleValue();
  }
  // sub
  public double sub(Number x,Number y){
    return x.doubleValue()-y.doubleValue();
  }
  // div
  public double div(Number x,Number y){
    return x.doubleValue()/y.doubleValue();
  }
  // mul
  public double mul(Number x,Number y){
    return x.doubleValue()*y.doubleValue();
  }
}
