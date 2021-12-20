package RSA算法.分解n;

public class Solution {

    public static void main(String[] args) {
        decomposition(31313);
    }
    public static void decomposition(long n) {
        for(long i = 2; i < n / 2; i++) {
            long anotherNum = 0;
            if(n % i == 0) {
                anotherNum = n / i;
            } else {
                continue;
            }
            if (isPrime(i) && isPrime(anotherNum)) {
                System.out.println("第一个素数为" + anotherNum + "，第二个素数为" + i);
                break;
            }
        }
        return;
    }

    /**
     * 判断是否为素数
     * @param num
     */
    public static Boolean isPrime(long num) {
        for(int i = 1; i < num / 2 + 2; i++) {
            if(EuclideanAlgo(i, num) != 1) {
                return false;
            }
        }
        return true;
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
