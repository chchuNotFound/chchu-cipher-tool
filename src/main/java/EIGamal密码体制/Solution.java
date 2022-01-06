package EIGamal密码体制;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        // 输入alpha
        int α = 7;
        // a需要先算:代码在EIGamal密码体制-私钥
        int a = 21839;
        // 输入p
        int modNum = 31847;
        // β = α^a mod modNum = 7^21839 mod 31847   modNum 也是 p
        long β = squareMultiply(α, a, modNum);
        System.out.println("β = " + β);
        // 输入随机数k
        int k = 511;
        // y1 = α^k mod β = 7^511 mod 31847
        long y1 = squareMultiply(α, k, modNum);
        System.out.println("y1 = " + y1);
        // 输入加密明文
        int x = 389;
        // y2 = (x * β^k) mod β = (389 * 18074^511) mod 31847
        long y2 = floorMod(x * squareMultiply(β, k, modNum), modNum);
        System.out.println("y2 = " + y2);
        System.out.println("密文：y = " + "(" + y1 + "," + y2 + ")");
        System.out.println("解密得：x = " + floorMod(y2 * squareMultiply(findN(y1, modNum), a, modNum), modNum));
    }

    /**
     * 本原元素证明
     * @param element
     * @param modNum
     */
    public static void proofPriElement(int element, int modNum) {
        long ans = 0;
        int count = 1;
        while(ans != 1) {
            ans = squareMultiply(element, count, modNum);
            System.out.println("第" + count + "次：" + ans);
            count++;
            if(count == modNum) {
                break;
            }
        }
        if(count == modNum) {
            System.out.println( element + "是模"+ modNum + "的一个本原元素。");
        }
        return;
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

    /**
     * 求逆算法
     * @param val
     * @param modNum
     */
    public static int findN(long val, long modNum) {
        int ans = 0;
        for (int i = 0; i < modNum; i++) {
            if ((i * val) % modNum == 1) {
//                System.out.println("n = " + i);
                ans = i;
                break;
            }
        }
        return ans;
    }
}
