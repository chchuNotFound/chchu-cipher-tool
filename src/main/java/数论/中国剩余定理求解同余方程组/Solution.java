package 数论.中国剩余定理求解同余方程组;

import java.util.Scanner;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        equation();
    }

    public static void equation() {
        Scanner sin = new Scanner(System.in);
        System.out.println("输入a1:");
        int a1 = sin.nextInt();
        System.out.println("输入a2:");
        int a2 = sin.nextInt();
        System.out.println("输入a3:");
        int a3 = sin.nextInt();
        System.out.println("输入m1:");
        int m1 = sin.nextInt();
        System.out.println("输入m2:");
        int m2 = sin.nextInt();
        System.out.println("输入m3:");
        int m3 = sin.nextInt();
        int M = m1 * m2 * m3;
        int M1 = m2 * m3;
        int M2 = m1 * m3;
        int M3 = m1 * m2;
        System.out.println("M = " + M);
        System.out.println("M1 = " + M1);
        System.out.println("M2 = " + M2);
        System.out.println("M3 = " + M3);
        int y1 = findN(M1, m1);
        int y2 = findN(M2, m2);
        int y3 = findN(M3, m3);
        System.out.println("y1 = " + y1);
        System.out.println("y2 = " + y2);
        System.out.println("y3 = " + y3);
        int sum = a1*M1*y1 + a2*M2*y2 + a3*M3*y3;
        int x = floorMod(sum, M);
        System.out.println("x = " + x);
    }

    public static int findN(int val, int modNum) {
        int ans = 0;
        for (int i = 0; i < modNum; i++) {
            if (floorMod((i * val), modNum) == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
