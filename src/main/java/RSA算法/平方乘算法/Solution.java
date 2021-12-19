package RSA算法.平方乘算法;

import static java.lang.StrictMath.floorMod;

public class Solution {
    public static void main(String[] args) {
        int x = 3;
        int c = 9;
        int n = 19684;
        squareMultiply(x, c, n);
    }

    /**
     * 平方-乘算法
     * @param x 底数
     * @param c 指数
     * @param n 模数
     */
    public static void squareMultiply(int x, int c, int n) {
        String ci = Integer.toBinaryString(c);
        int count = ci.length();
        System.out.println("指数c 的 二进制表示 ： " + ci);
        int z = 1;
        for(int i = count - 1; i >= 0; i--) {
            z = floorMod(z * z, n);
            if(ci.charAt(i) == '1') {
                z = floorMod( z * x, n);
            }
        }
        System.out.println("余数z:" + z);
    }
}
