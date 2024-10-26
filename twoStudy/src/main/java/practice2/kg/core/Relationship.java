package practice2.kg.core;

import java.util.Objects;

public class Relationship extends Edge{
    // 字段声明，String类型
    private String name;
    private String attribute;

    public Relationship(Node from,Node to){
        this(from,to,"关系",null);
    }
// 全参数构造器
    public Relationship(Node from,Node to,String name,String attribute){
        super(from,to);
        this.name=name;
        this.attribute=attribute;
    }
// 省略Getter、Setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Relationship that = (Relationship) o;
        return name.equals(that.name) && attribute.equals(that.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, attribute);
    }
}
