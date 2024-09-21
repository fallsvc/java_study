package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/25  15:45
 */
class Food {

}
class Fruit extends Food {

}
class Apple extends Fruit {

}
class Banana extends Fruit {

}



class Message2<T> { // 设置泛型
    private T message ;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

public class Test2 {
    public static void main(String[] args) {

    }
    //下界
    public static void func2(Message<? super Fruit> message){
        message.setMessage(new Apple());
        message.setMessage(new Banana());

        //向下转型
        Fruit fruit=(Fruit) message.getMessage();
    }
    //上界
    public static void func(Message<? extends Fruit> message){
//        Apple apple=message.getMessage();//error
        Fruit fruit=message.getMessage();
        //message继承Fruit 但是不知道是哪一个类
//        message.setMessage(new Banana());//error

    }
}