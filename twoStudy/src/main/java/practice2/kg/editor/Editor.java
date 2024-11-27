package practice2.kg.editor;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/6  8:46
 */
public abstract class Editor<T> {
    private T target;// 待编辑的目标对象
    public abstract String[] values();// 返回实体 数据
    public abstract String[] fieldNames();// 返回实体字段名称
    public abstract void update(String[] values);// 更新数据
    public T getTarget(){
        return this.target;
    }
    public void setTarget(T target){
        this.target=target;
    }
}
