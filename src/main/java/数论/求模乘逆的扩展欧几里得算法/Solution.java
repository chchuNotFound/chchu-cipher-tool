package 数论.求模乘逆的扩展欧几里得算法;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Arithmetic arithmetic = new Arithmetic();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入欧几里得扩展算法求逆元的两个数（中间用空格隔开）：");
        int a = in.nextInt();
        int b = in.nextInt();
        int result = arithmetic.euclid_2(a, b);
        if (result < 0) {
            result = result + b;
        }
        System.out.println(a + "(mod" + b + ")=" + result);
    }

   static class Arithmetic {
        int x = 0;
        int y = 0;

        public int euclid_2(int a, int b) {
            int first = a;
            int second = b;
            if (second == 0) {
                x = 1;
                y = 0;
                return first;
            }
            int r = euclid_2(second, first % second);
            int t = y;
            y = x - (first / second) * y;
            x = t;
            return x;   //结束循环
        }
    }

}
