package ph.test.cc;

import ph.test.cc.Animal;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/13  21:01
 */
public class Dog extends Animal {

    public String name;
    public void bark(){
        System.out.println(this.name+" zaijiao....");
        System.out.println(super.name+" zaijiao....");

    }

}
