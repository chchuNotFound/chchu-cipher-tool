package 取模计算.分数取模或求逆;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        findN(104729, 15485863);
    }

    public static void findN(long val, long modNum) {
        for (int i = 0; i < modNum; i++) {
            if (floorMod((i * val), modNum) == 1) {
                System.out.println("n = " + i);
                break;
            }
        }
        return;
    }

}