package 数论.素数证明;

public class Solution {

    public static void main(String[] args) {
        isPrime(7919);
    }

    /**
     * 判断是否为素数
     * @param num
     */
    public static void isPrime(long num) {
        for(int i = 1; i < num / 2 + 2; i++) {
            if(EuclideanAlgo(i, num) != 1) {
                System.out.println("不是素数");
                break;
            }
        }
        System.out.println("是素数");
        return;
    }

    /**
     * 辗转相除法
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

}
