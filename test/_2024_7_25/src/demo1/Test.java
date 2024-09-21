package demo1;

import java.lang.reflect.Method;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/25  8:48
 */
class Message<T>{
    private T message;

    public T getMessage(){
        return message;
    }
    public void setMessage(T message){
        this.message=message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message=" + message +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Message<String> message=new Message<>();
        message.setMessage("hello boys ");

        fun(message);

        Message<Integer> message2=new Message<>();
        message2.setMessage(10);

        fun(message2);


    }

    private static void fun(Message<?> message) {
//        System.out.println(message.getMessage());
        System.out.println(message);
    }

    public static void main1(String[] args) {
        //手动入池string.intern();
        String s=new String("asd");
        s.intern();
        String a="asd";
        System.out.println(s==a);
    }
}
