package work3;

public class Symbol {
  private int color; // 颜色代码
  public String symbol() {
    return "*"; // 默认的符号实现
  }
  public String line(int length) {
    // 完成代码：返回特定长度的符号串来表示线段
    StringBuilder stringBuilder=new StringBuilder();
    String s=symbol();
    for (int i = 0; i < length; i++) {
      stringBuilder.append(s);
    }
    return stringBuilder.toString();
  }
  public int getColor() {
    return color;
  }
  public void setColor(int color) {
    this.color = color;
  }
}

class PlusSymbol extends Symbol{
  @Override
  public String symbol() {
    // 完成代码
    return "+";
  }
}
class SubSymbol extends Symbol{
  // 完成代码
  @Override
  public String symbol(){
    return "-";
  }
}