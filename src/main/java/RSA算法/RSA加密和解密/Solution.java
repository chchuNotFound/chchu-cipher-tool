package RSA算法.RSA加密和解密;

import java.util.*;

import static java.lang.Math.floorMod;

public class Solution {
    static List<Integer> ZnList = new ArrayList<>();
    static Map<Integer, Character> chMap = new HashMap<>();

    public static void main(String[] args) {
        for(int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            chMap.put(i, ch);
        }
        String text =
                "6340 8309 14010 8936 27358 25023 16481 25809 23614 7135 24996 30590 27570 26486 30388 9395 27584 14999 " +
                        "4517 12146 29421 26439 1606 17881 25774 7647 23901 7372 25774 18436 12056 13547 7908 8635 2149 1908 22076 " +
                        "7372 8686 1304 4082 11803 5314 107 7359 22470 7372 22827 15698 30317 4685 14696 30388 8671 29956 15705 " +
                        "1417 26905 25809 28347 26277 7897 20240 21519 12437 1108 27106 18743 24144 10685 25234 30155 23005 8267 " +
                        "9917 7994 9694 2149 10042 27705 15930 29748 8635 23645 11738 24591 20240 27212 27486 9741 2149 29329 2149 " +
                        "5501 14015 30155 18154 22319 27705 20321 23254 13624 3249 5443 2149 16975 16087 14600 27705 19386 7325 " +
                        "26277 19554 23614 7553 4734 8091 23973 14015 107 3183 17347 25234 4595 21498 6360 19837 8463 6000 31280 " +
                        "29413 2066 369 23204 8425 7792 25973 4477 30989";
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sum = sum * 10 + (ch - '0');
            }
            if (ch == ' ' || i == text.length() - 1) {
                ZnList.add(sum);
                sum = 0;
            }
        }
//        for (int i = 0; i < ZnList.size(); i++) {
//            System.out.println(ZnList.get(i));
//        }

        RSAEncryAndDecry(181, 173);
    }

    /**
     * RSA加密和解密
     * Ek(x) = x^b mod n
     * Dk(y) = y^a mod n
     *
     * @param p 大素数
     * @param q 大素数
     */
    public static void RSAEncryAndDecry(long p, long q) {
        long n = p * q;
        long fi_n = (p - 1) * (q - 1);
        long b = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入b: ");
            b = sc.nextInt();
            if (EuclideanAlgo(b, fi_n) == 1) {
                System.out.println("b = " + b + "与 fi(n) = " + fi_n + "互素");
                break;
            }
            System.out.println("选的数不与fi(n) = " + fi_n + "互素");
        }
        long a = floorMod(findN(b, fi_n), fi_n);
        System.out.println("公钥：n = " + n + ", b = " + b);
        System.out.println("私钥：p = " + p + ", q = " + q + ", a = " + a);
        System.out.println("加密or解密（输入：1 or 2）：");
        int flag = sc.nextInt();
        if (flag == 1) {
            List<Long> EkList = new ArrayList<>();
            for (int i = 0; i < ZnList.size(); i++) {
                System.out.println("------------------------------------------");
//                System.out.println("请输入明文：");
//                long plaintext = sc.nextLong();
                long plaintext = ZnList.get(i);
//                System.out.println("加密需要知道明文, 随机选择数b, 大素数乘积模数n");
                System.out.println("明文:" + plaintext + ", 随机选择数b:" + b + ", 大素数乘积模数n:" + n);
                long Ek = squareMultiply(plaintext, (int) b, n);
                EkList.add(Ek);
                System.out.println("密文为：" + Ek);
            }
            for (int i = 0; i < EkList.size(); i++) {
                changeToCharSet(EkList.get(i));
            }
        } else if (flag == 2) {
            List<Long> DkList = new ArrayList<>();
            for (int i = 0; i < ZnList.size(); i++) {
                System.out.println("------------------------------------------");
//                System.out.println("请输入密文：");
//                long ciphertext = sc.nextLong();
                long ciphertext = ZnList.get(i);
//                System.out.println("解密需要知道密文Ek, 秘密解密指数a, 大素数乘积模数n");
                System.out.println("密文ciphertext:" + ciphertext + ", 秘密解密指数a:" + a + ", 大素数乘积模数n:" + n);
                long Dk = squareMultiply(ciphertext, (int) a, n);
                DkList.add(Dk);
                System.out.println("明文为：" + Dk);
            }
            for (int i = 0; i < DkList.size(); i++) {
                changeToCharSet(DkList.get(i));
            }
        }
    }

    /**
     * 求逆
     *
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
     *
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
        while (r > 0) {
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
     *
     * @param x
     * @param c
     * @param n
     * @return
     */
    public static long squareMultiply(long x, int c, long n) {
//        System.out.println("----------平方乘算法----------");
        String ci = Integer.toBinaryString(c);
        int count = ci.length();
//        System.out.println("指数c 的 二进制表示 ： " + ci);
        long z = 1;
        // i从字符串的低位（从二进制码的高位开始）
        for (int i = 0; i < count; i++) {
            z = Math.floorMod(z * z, n);
            if (ci.charAt(i) == '1') {
                z = Math.floorMod(z * x, n);
            }
//            System.out.println("第" + (count - i - 1) + "个比特为"+ ci.charAt(i) + "，得: z = " + z);
        }
        return z;
    }

    /**
     * 数字转词组（Zn解码规则）
     * DOG => 3 X 26^2 + 14 X 26 + 6 = 2398
     *
     * @param text
     */
    public static void changeToCharSet(long text) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int z = 0; z < 26; z++) {
                    int sum = i * 26 * 26 + j * 26 + z;
                    if (sum == text) {
                        char ch1 = chMap.get(i);
                        char ch2 = chMap.get(j);
                        char ch3 = chMap.get(z);
                        System.out.print(ch1 +""+ ch2 + "" + ch3);
                    }
                }
            }
        }

    }

}
