package ElGamal签名方案.VerK;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        // a要先求：通过ElGamal密码体制-私钥求得
        ElGamalSignature(31415, 23972, 20481, 25703, 5, 31847);
    }

    public static void ElGamalSignature(long x, long gamma, long delta, long beta, long alpha, long p)  {
            long mod1 = squareMultiply(beta, (int) gamma, p);
            long mod2 = squareMultiply(gamma, (int) delta, p);
            long modRes = floorMod(mod1 * mod2, p);
            long mod3 = squareMultiply(alpha, (int) x, p);
            if(modRes == mod3) {
                System.out.println("true");
            } else {
                System.out.println("false");
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
