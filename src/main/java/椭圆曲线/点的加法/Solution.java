package 椭圆曲线.点的加法;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        pointAddition(2, 7, 2, 7, 11, 1);
    }

    public static void pointAddition (int x1, int y1, int x2, int y2, int Z, int a) {
        long lambda = 0;
        if(x1 == x2 && y1 == y2) {
            lambda = floorMod((3 * x1 * x1 + a) * findN(2 * y1, Z), Z);
        } else {
            lambda = floorMod((y2 - y1) * findN((x2 - x1), Z), Z);
        }
        // λ = (y2 − y1)(x2 − x1)^-1 mod p 或者 (3x1^2 + a)(2y1)^-1
        System.out.println("lambda = " + lambda);
        // x3 = λ^2 − x1 − x2;
        long x3 = floorMod(lambda * lambda - x1 - x2, Z);
        // y3 = λ(x1 - x3) - y1;
        long y3 = floorMod(lambda * (x1 - x3) - y1, Z);
        System.out.println("(" + x1 + "," + y1 + ") + " + "(" + x2 + "," + y2 + ") = " +  "(" + x3 + "," + y3 + ")");
    }

    public static long findN(long val, long modNum) {
        long n = 0;
        for (long i = 0; i < modNum; i++) {
            if ((i * val) % modNum == 1) {
                n = i;
            }
        }
        return n;
    }
}
