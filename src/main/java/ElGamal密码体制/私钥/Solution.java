package ElGamal密码体制.私钥;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        // 输入alpha
        int α = 5;
        int a = 0;
        // 输入p
        int modNum = 31847;
        long β;
        while(true) {
            // 暴力试出私钥a
            β = squareMultiply(α, a, modNum);
            // 输入beta
            if( β == 25703) {
                break;
            }
            a++;
        }
        System.out.println("p = " + modNum);
        System.out.println("alpha = " + α);
        System.out.println("beta = " + β);
        System.out.println("私钥：a = " + a);
    }

    /**
     * 平方-乘算法
     * @param x 底数
     * @param c 指数
     * @param n 模数
     */
    public static long squareMultiply(long x, int c, long n) {
        String ci = Integer.toBinaryString(c);
        int count = ci.length();
//        System.out.println("指数c 的 二进制表示 ： " + ci);
        long z = 1;
        // i从字符串的低位（从二进制码的高位开始）
        for(int i = 0; i < count; i++) {
            z = floorMod(z * z, n);
            if(ci.charAt(i) == '1') {
                z = floorMod(z * x, n);
            }
//            System.out.println("第" + (count - i - 1) + "个比特为"+ ci.charAt(i) + "，得: z = " + z);
        }
        return z;
    }

}
