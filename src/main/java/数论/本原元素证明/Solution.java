package 数论.本原元素证明;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        // 模数若是素数p，阶的计算Ord(a) = p - 1
        // 如底数为7，指数为n（从1开始计数）,模数为7919 ，阶值为7918
        proofPriElement(7, 7919);
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
}
