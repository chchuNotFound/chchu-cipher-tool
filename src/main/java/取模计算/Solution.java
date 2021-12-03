package 取模计算;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        mod();
    }
    public static void mod() {
        Scanner sn = new Scanner(System.in);
        int count = 0;
        while(true) {
            System.out.println("编号：" + count);
            System.out.println("请输入a: ");
            int a = sn.nextInt();
            System.out.println("请输入b: ");
            int b = sn.nextInt();
            System.out.println("a mod b = " + floorMod(a, b));
            count++;
            System.out.println("---------------------");
        }
    }
}
