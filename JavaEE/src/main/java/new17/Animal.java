package new17;
// final 密封类，使该类无法被继承


// sealed 密封类
// permits 密封类对permits的类开放可以继承

 sealed class Animal permits Dog{
     public String name;
     public int age;
     public void eat() {
     System.out.println("eat()....");
     }
 }

 //继承的类也要加上密封限制 non-sealed表⽰不限制
non-sealed class Dog extends Animal{
    @Override
    public void eat() {
    System.out.println(this.name+ " 正在吃狗粮....");
    }
 }

//sealed class Animal1 {
//    public String name;
//    public int age;
//    public void eat() {
//        System.out.println("eat()....");
//    }
//}
// Sealed class must have subclasses sealed密封类必须要有子类
//sealed class Dog1 extends Animal1{
//    @Override
//    public void eat() {
//    }
//}