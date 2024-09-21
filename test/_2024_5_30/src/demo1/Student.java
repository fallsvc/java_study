package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/30  20:43
 */
public class Student implements Cloneable{

    public String name;
    public void checkName(String name) throws NameException{
        if(!this.name.equals(name)){
            throw new NameException();
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


