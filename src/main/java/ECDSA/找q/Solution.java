package ECDSA.找q;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        Point alpha = new Point(2, 6);
        int m = 54;
        int a = 1;
        int p = 127;
        findQ(m, alpha, p, a);
    }

    public static void findQ(long m, Point alpha, int p, int a) {
        int q = 0;
        for (int i = 1; i < 1000; i++) {
            Point point3 = doubleAdd(i, alpha, p, a);
//            if(point3.x == alpha.x && point3.y == p - alpha.y ) {
//                q = i;
//                System.out.println("q = " + q);
//                break;
//            }
            System.out.println("q = " + i + ", x = " + point3.x + ", y = " + point3.y);
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

}
