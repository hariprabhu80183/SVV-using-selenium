package org.example;
import java.util.*;



public class add {
    static int add1(int a ,int b)
    {
        int c=a+b;
        return c;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(add1(a,b));

    }
}