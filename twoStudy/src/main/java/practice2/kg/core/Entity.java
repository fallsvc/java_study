package practice2.kg.core;

import java.util.Objects;

public class Entity extends Node {
    // 字段声明，String类型
    private String type;// 实体类型
    private String name;// 实体名
    private String attribute;// 实体属性
// 单参数构造器
    public Entity(int id){
        super(id);
        this.type=null;
        this.name=null;
        this.attribute=null;
    }
// 全参数构造器
    public Entity(int id,String type,String name,String attribute){
        super(id);
        this.type=type;
        this.name=name;
        this.attribute=attribute;
    }
// 省略Getter、Setter方法

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
        Entity entity = (Entity) o;
        return type.equals(entity.type) && name.equals(entity.name) && attribute.equals(entity.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, name, attribute);
    }
}
