package RSA算法.RSA加密和解密;

import java.util.Scanner;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        RSAEncryAndDecry(101, 113);
    }

    /**
     * RSA加密和解密
     * Ek(x) = x^b mod n
     * Dk(y) = y^a mod n
     * @param p 大素数
     * @param q 大素数
     */
    public static void RSAEncryAndDecry(long p, long q) {
        long n = p * q;
        long fi_n = (p - 1) * (q - 1);
        long b = 0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入b: ");
            b = sc.nextInt();
            if(EuclideanAlgo(b, fi_n) == 1) {
                System.out.println("b = " + b + "与 fi(n) = " + fi_n + "互素");
                break;
            }
            System.out.println("选的数不与fi(n) = " + fi_n + "互素");
        }
        long a = floorMod(findN(b, fi_n), fi_n);
        System.out.println("公钥：n = " + n + ", b = " + b);
        System.out.println("私钥：p = " + p + ", q = " + q + ", a = " + a);
        System.out.println("请输入明文：");
        long plaintext = sc.nextLong();
        System.out.println("------------------------------------------");
        System.out.println("加密需要知道明文, 随机选择数b, 大素数乘积模数n");
        System.out.println("明文:"+ plaintext + ", 随机选择数b:" + b + ", 大素数乘积模数n:" + n);
        long Ek = squareMultiply(plaintext, (int) b, n);
        System.out.println("密文为：" + Ek);
        System.out.println("------------------------------------------");
        System.out.println("解密需要知道密文Ek, 秘密解密指数a, 大素数乘积模数n");
        System.out.println("密文Ek:" + Ek + ", 秘密解密指数a:" + a + ", 大素数乘积模数n:" + n);
        long Dk = squareMultiply(Ek, (int) a, n);
        System.out.println("明文为：" + Dk);

    }

    /**
     * 求逆
     * @param val
     * @param modNum
     * @return
     */
    public static long findN(long val, long modNum) {
        long ans = 0;
        for (int i = 0; i < modNum; i++) {
            if ((i * val) % modNum == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 欧式算法/辗转相除法
     * @param a
     * @param b
     * @return
     */
    public static long EuclideanAlgo(long a, long b) {
        double a0 = a;
        double b0 = b;
        long t0 = 0;
        long t = 1;
        long s0 = 1;
        long s = 0;
        long q = (long) Math.floor(a0 / b0);
        long r = (long) (a0 - q * b0);
        long temp;
        while(r > 0) {
            temp = t0 - q * t;
            t0 = t;
            t = temp;
            temp = s0 - q * s;
            s0 = s;
            s = temp;
            a0 = b0;
            b0 = r;
            q = (long) Math.floor(a0 / b0);
            r = (long) (a0 - q * b0);
        }
        r = (long) b0;
        return r;
    }

    /**
     * 平方-乘算法
     * @param x
     * @param c
     * @param n
     * @return
     */
    public static long squareMultiply(long x, int c, long n) {
        System.out.println("----------平方乘算法----------");
        String ci = Integer.toBinaryString(c);
        int count = ci.length();
//        System.out.println("指数c 的 二进制表示 ： " + ci);
        long z = 1;
        // i从字符串的低位（从二进制码的高位开始）
        for(int i = 0; i < count; i++) {
            z = Math.floorMod(z * z, n);
            if(ci.charAt(i) == '1') {
                z = Math.floorMod(z * x, n);
            }
//            System.out.println("第" + (count - i - 1) + "个比特为"+ ci.charAt(i) + "，得: z = " + z);
        }
        return z;
    }

}
