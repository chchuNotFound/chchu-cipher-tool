package ElGamal签名方案.求k;

import static java.lang.Math.floorMod;

public class Solution {
    public static void main(String[] args) {
        findK(23972, 5, 31847);
    }
    public static void findK(long gamma, long alpha, long p) {
        for(int i = 0; i < p; i++) {
            if(gamma == squareMultiply(alpha, i, p)) {
                System.out.println("k = " + i);
            }
        }
    }
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
