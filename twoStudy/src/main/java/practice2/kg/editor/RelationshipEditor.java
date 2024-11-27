package practice2.kg.editor;

import practice2.kg.core.Entity;
import practice2.kg.core.Relationship;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/6  8:54
 */
public class RelationshipEditor extends Editor<Relationship> {
    public String[] values() {
        Relationship e=this.getTarget();
        return new String[]{e.getName(),e.getAttribute()};
    }

    @Override
    public String[] fieldNames() {
        return new String[]{"名称","属性"};
    }

    @Override
    public void update(String[] values) {
        Relationship e=this.getTarget();
        e.setName(values[0]);
        e.setAttribute(values[1]);
    }
}
