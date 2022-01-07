package Rabin密码体制;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        fourDifferentSolutions(4013, 199, 211);
    }

    public static void fourDifferentSolutions(int cryptotext, int p, int q) {
        long u1 = squareMultiply(cryptotext, (p + 1) / 4, p);
        long u2 = p - u1;
        long v1 = squareMultiply(cryptotext, (q + 1) / 4, q);
        long v2 = q - v1;
        System.out.println("u1 = " + u1 + ", u2 = " + u2 + ", v1 = " + v1 + ", v2 = " + v2);
        long x11 = equation(u1, v1, p, q);
        long x12 = equation(u1, v2, p, q);
        long x21 = equation(u2, v1, p, q);
        long x22 = equation(u2, v2, p, q);
        System.out.println("x1,1 = " + x11 + ", x1,2 = " + x12 + ", x2,1 = " + x21 + ", x2,2 = " + x22);
        System.out.println("验证：");
        long mod1 = floorMod(x11 * x11, p * q);
        long mod2 = floorMod(x12 * x12, p * q);
        long mod3 = floorMod(x21 * x21, p * q);
        long mod4 = floorMod(x22 * x22, p * q);
        System.out.println("mod1 = " + mod1 + ", mod2 = " + mod2 + ", mod3 = " + mod3 + ", mod4 =" + mod4);
    }

    public static long equation(long a1, long a2, long m1, long m2) {
        System.out.println("-----------------------------");
        long M = m1 * m2 ;
        long M1 = m2 ;
        long M2 = m1 ;
        System.out.println("M = " + M);
        System.out.println("M1 = " + M1);
        System.out.println("M2 = " + M2);
        long y1 = findN(M1, m1);
        long y2 = findN(M2, m2);
        System.out.println("y1 = " + y1);
        System.out.println("y2 = " + y2);
        long sum = a1*M1*y1 + a2*M2*y2;
        long x = floorMod(sum, M);
        return x;
    }

    public static long findN(long val, long modNum) {
        long ans = 0;
        for (long i = 0; i < modNum; i++) {
            if (floorMod((i * val), modNum) == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static long squareMultiply(long x, int c, long n) {
        String ci = Integer.toBinaryString(c);
        int count = ci.length();
        System.out.println("指数c 的 二进制表示 ： " + ci);
        long z = 1;
        // i从字符串的低位（从二进制码的高位开始）
        for(int i = 0; i < count; i++) {
            z = Math.floorMod(z * z, n);
            if(ci.charAt(i) == '1') {
                z = Math.floorMod(z * x, n);
            }
            System.out.println("第" + (count - i - 1) + "个比特为"+ ci.charAt(i) + "，得: z = " + z);
        }
        return z;
    }
}

