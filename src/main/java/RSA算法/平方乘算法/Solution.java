package RSA算法.平方乘算法;

public class Solution {
    public static void main(String[] args) {
        int x = 32767;
        int c = (2);
        int n = 199*211;
        System.out.println(squareMultiply(x, c, n));
    }


    /**
     * 平方-乘算法
     * @param x
     * @param c
     * @param n
     * @return
     */
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
