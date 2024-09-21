package Demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  11:33
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException{
        Store store=new Store();

        Store store1=(Store)store.clone();
        store.food.money=100.0;
        System.out.println(store.food.money);
        System.out.println(store1.food.money);

    }
}
