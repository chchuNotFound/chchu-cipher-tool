package ECDSA;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        Point alpha = new Point(2, 6);
        int m = 54;
        int a = 1;
        int p = 127;
        int k = 75;
        int SHA1 = 10;
        // B = mA 或者 beta = m * alpha
        ECDSA(m, alpha, p, a, k, SHA1);

    }

    public static void ECDSA(long m, Point alpha, int p, int a, int k, int SHA1) {
        Point beta = doubleAdd(m, alpha, p, a);
        System.out.println("beta= (" + beta.x + "," + beta.y + ")");
        Point uv = doubleAdd(k, alpha, p, a);
        System.out.println("(u, v)= (" + uv.x + "," + uv.y + ")");
        // 需要先找素数q，q * alpha = O(无穷远点)
        int q = 131;
        int r = floorMod(uv.x, q);
        System.out.println("r = " + r);
        long s = floorMod((SHA1 + m * r) * findN(k, q), q);
        System.out.println("消息-签名对(x, (r, s)) : " + "(x, (" + r + ", " + s + "))");
        System.out.println("(" + r + ", " + s + ") 是对x的签名");

        long w = floorMod(findN(s, q), q);
        long i = floorMod(w * SHA1, q);
        long j = floorMod(w * r, q);
        Point verUV = new Point();
        verUV = pointAddition(doubleAdd(i, alpha, p, a).x, doubleAdd(i, alpha, p, a).y, doubleAdd(j, beta, p, a).x, doubleAdd(j, beta, p, a).y, p, a);
        System.out.println("用于验证的(u, v) = (" + verUV.x + "," + verUV.y + ")");
        if (floorMod(verUV.x, q) == r) {
            System.out.println(" u mod q = " + verUV.x + " mod " + q + " = " + floorMod(verUV.x, q));
            System.out.println("Ver = true");
        } else {
            System.out.println(" u mod q = " + verUV.x + " mod " + q + " = " + floorMod(verUV.x, q));
            System.out.println("Ver = false");
        }
    }

    /**
     * 点的累加
     *
     * @param m
     * @param alpha
     * @param p
     * @param a
     * @return
     */
    public static Point doubleAdd(long m, Point alpha, int p, int a) {
        Point beta = new Point(alpha.x, alpha.y);
        for (int i = 0; i < m - 1; i++) {
            beta = pointAddition(beta.x, beta.y, alpha.x, alpha.y, p, 1);
        }
        return beta;
    }

    /**
     * 点的相加
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param Z
     * @param a
     * @return
     */
    public static Point pointAddition(int x1, int y1, int x2, int y2, int Z, int a) {
        long lambda = 0;
        if (x1 == x2 && y1 == y2) {
            lambda = floorMod((3 * x1 * x1 + a) * findN(2 * y1, Z), Z);
        } else {
            lambda = floorMod((y2 - y1) * findN((x2 - x1), Z), Z);
        }
        // λ = (y2 − y1)(x2 − x1)^-1 mod p 或者 (3x1^2 + a)(2y1)^-1
//        System.out.println("lambda = " + lambda);
        // x3 = λ^2 − x1 − x2;
        long x3 = floorMod(lambda * lambda - x1 - x2, Z);
        // y3 = λ(x1 - x3) - y1;
        long y3 = floorMod(lambda * (x1 - x3) - y1, Z);
//        System.out.println("(" + x1 + "," + y1 + ") + " + "(" + x2 + "," + y2 + ") = " +  "(" + x3 + "," + y3 + ")");
        return new Point((int) x3, (int) y3);
    }

    /**
     * 求逆
     *
     * @param val
     * @param modNum
     * @return
     */
    public static long findN(long val, long modNum) {
        long n = 0;
        for (long i = 0; i < modNum; i++) {
            if (floorMod((i * val), modNum) == 1) {
                n = i;
            }
        }
        return n;
    }

    static class Point {
        private int x;
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    /**
     * 判断是否为素数
     *
     * @param num
     */
    public static boolean isPrime(int num) {
        for (int i = 1; i < num / 2 + 2; i++) {
            if (EuclideanAlgo(i, num) != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 辗转相除法
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
}
