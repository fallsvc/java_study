import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/9  18:48
 */
class PetDog {
    public String name;//名字
    public String color;//颜色
    public PetDog(){

        this("hikk","black");
        System.out.println("无参");
    }
    public PetDog(String name,String color){
        this.name=name;
        this.color=color;
    }
    public PetDog(PetDog a){
        this.name=a.name;
        this.color=a.color;
    }
    public void setDog(String a,String b){
        name=a;
        color=b;
    }
    public void printDog(){
        System.out.println(name);
        System.out.println(color);
    }
    // 狗的属性
    public void barks() {
        System.out.println(name + ": 旺旺旺~~~");
    }
    // 狗的行为
    public void wag() {
        System.out.println(name + ": 摇尾巴~~~");
    }
}

 public class Test {
    public void add(){
        System.out.println("fd");
    }

     public static void main(String[] args) {
         PetDog dog=new PetDog("hell","red");
         PetDog dog2=new PetDog(dog);
         dog2.printDog();
     }
     public static void main4(String[] args) {
         Test test=new Test();
         test.add();
         String a="ashdhs";
         String b=a;
         String c=new String("ashdhs");
         System.out.println(a);
         System.out.println(b);
         System.out.println(c);
         System.out.println(a.hashCode());
         System.out.println(b.hashCode());
         System.out.println(c.hashCode());
     }
    //
     public static int[] func(int[] array,int val){
        int[] ret={-1,-1};
         for (int i = 0; i < array.length; i++) {
             for (int j = i+1; j < array.length; j++) {
                 if(array[i]+array[j]==val){
                     ret[0]=i;
                     ret[1]=j;
                 }
             }
         }
         return ret;
     }

     public static void main3(String[] args) {
         int[] array={1,2,3,4};
         int[] ret=func(array,6);
         System.out.println(Arrays.toString(ret));
     }


    public static void main2(String[] args) {

//        PetDog dog=new PetDog("hill","blue");
        PetDog dog=new PetDog();

        dog.barks();
//        dog.setDog("diss","black");
        dog.printDog();
        System.out.println("Integer: " + Integer.SIZE/8);
    }
    public static void fun1(int[][] arr){
        for (int[] x:arr
             ) {
            for (int y:x
                 ) {
                System.out.print(y+" ");
            }
        }
    }
    public static void main1(String[] args) {
        int[][] array={{1,1},{2,3,2,3}};
        fun1(array);
//        array={{1,2,3},{1,1,1},{2,2,2}};//error
    }
}
