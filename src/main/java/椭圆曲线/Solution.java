package 椭圆曲线;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        ellipticCurveOperation(1, 6, 11);
    }

    public static void ellipticCurveOperation(int a, int b, int Z) {
        List<Point> points = new ArrayList<>();
        for (int x = 0; x < Z; x++) {
            int z = x * x * x + x * a + b;
            // 欧拉准则：QR(Z)是判断z是否是一个模Z二次剩余
            // 如果是，就有两个解
            // 否则无解
            long numForQR = squareMultiply(z, (Z - 1) / 2, Z);
            System.out.println("x = " + x + ": ");
            System.out.print("z = " + z + " 是否属于QR(" + Z + ")：");
            if (numForQR == 1) {
                System.out.println("是");
            } else {
                System.out.println("否");
            }
            int modNum = floorMod(z, Z);
            System.out.println("(x^3 + " + a + "x + " + b + ") mod " + Z + " = " + modNum);
            if (numForQR == 1) {
                long squareRoots1 = squareMultiply(z, (Z + 1) / 4, Z);
                Point point1 = new Point(x, (int) squareRoots1);
                long squareRoots2 = Z - squareRoots1;
                Point point2 = new Point(x, (int) squareRoots2);
                points.add(point1);
                points.add(point2);
                System.out.println("y1 = " + squareRoots1 + ", y2 = " + squareRoots2);
            }
            System.out.println("-----------------");
        }
        System.out.print("E = { O（无穷远点）, ");
        for(int i = 0; i < points.size(); i++) {
            System.out.print("(" + points.get(i).x + "," + points.get(i).y + "),");
        }
        System.out.println("}");
        System.out.println("共有" + (points.size() + 1) + "个点");
    }

    /**
     * 平方乘算法
     *
     * @param x
     * @param c
     * @param n
     * @return
     */
    public static long squareMultiply(long x, int c, long n) {
        String ci = Integer.toBinaryString(c);
        int count = ci.length();
//        System.out.println("指数c 的 二进制表示 ： " + ci);
        long z = 1;
        // i从字符串的低位（从二进制码的高位开始）
        for (int i = 0; i < count; i++) {
            z = floorMod(z * z, n);
            if (ci.charAt(i) == '1') {
                z = floorMod(z * x, n);
            }
//            System.out.println("第" + (count - i - 1) + "个比特为"+ ci.charAt(i) + "，得: z = " + z);
        }
        return z;
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
