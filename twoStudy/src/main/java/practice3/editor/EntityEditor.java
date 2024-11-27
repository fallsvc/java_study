package practice3.editor;


import practice3.core.Entity;

public class EntityEditor extends Editor<Entity>{
  @Override
  public String[] values() {
    Entity e = this.getTarget();
    return new String[] {e.getType(), e.getName(), e.getAttribute()};
  }
  @Override
  public String[] fieldNames() {
    return new String[] {"类型", "名称", "属性"};
  }
  @Override
  public void update(String[] values) {
    Entity e = this.getTarget();
    e.setType(values[0]);
    e.setName(values[1]);
    e.setAttribute(values[2]);
  }
}
