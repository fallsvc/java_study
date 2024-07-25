package enumDemo;

import demo1.Test;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/25  10:49
 */
public enum TestEnum {
    RED(0,"RED"),WHITE(1,"WHITE"),
    GREEN(2,"GREEN"),BLACK(3,"BLACK");


    public int ordinal;
    public String color;

    TestEnum(int ordinal,String color){
        this.ordinal=ordinal;
        this.color=color;
    }

    public static void main(String[] args) {
        TestEnum[] testEnums=TestEnum.values();
        for (int i = 0; i < testEnums.length; i++) {
            System.out.println(testEnums[i]+" "+testEnums[i].ordinal());
        }
        TestEnum testEnum=TestEnum.valueOf("WHITE");
        System.out.println(testEnum);

        System.out.println(WHITE.compareTo(BLACK));
    }
    public static void main1(String[] args) {
        TestEnum testEnum=RED;
        switch (testEnum){
            case RED -> System.out.println("RED");
            case BLACK -> System.out.println("BLACK");
            default -> System.out.println("无法匹配");

        }
    }
}
