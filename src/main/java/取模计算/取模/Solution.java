package 取模计算.取模;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        mod();
    }

    public static void mod() {
        long a = 32767 * (32767 + 1357);
        long b = 199 * 211;
        System.out.println("a mod b = " + floorMod(a, b));
        System.out.println("---------------------");

    }
}
