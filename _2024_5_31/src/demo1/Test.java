package demo1;

import java.io.IOException;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/31  12:22
 */
public class Test {


    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void getCustomerInfo() {


        try {

            throw new java.io.FileNotFoundException();
            // do something that may cause an Exception

        } catch (java.io.FileNotFoundException ex) {

            System.out.print("FileNotFoundException!");

        } catch (java.io.IOException ex) {

            System.out.print("IOException!");

        } catch (java.lang.Exception ex) {

            System.out.print("Exception!");

        }

    }
    public static void main1(String[] args) {

        getCustomerInfo();
        ((Test) null).testMethod();
    }
}
