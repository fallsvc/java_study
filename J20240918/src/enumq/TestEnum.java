package enumq;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/19  15:09
 */

public enum TestEnum {
    RED(0,"RED"),WHITH(1,"WHIHT"),GREEN(2,"GREEN"),BLACK(3,"BLACK");

    private int ordinal;
    private String name;
    private TestEnum(int ordinal,String name ){
        this.ordinal=ordinal;
        this.name=name;
    }

    public static void main(String[] args) {
        TestEnum[] testEnums=TestEnum.values();//返回枚举数组
        for (int i = 0; i < testEnums.length; i++) {
            System.out.println(testEnums[i].ordinal());//值
        }
        TestEnum t=TestEnum.valueOf("RED");
        System.out.println(t);
    }
}
