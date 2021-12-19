package 数论.本原元素证明;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        proofPriElement(2, 11);
    }
    public static void proofPriElement(int element, int modNum) {
        int ans = 0;
        int count = 1;
        while( ans != 1) {
            int pow = (int) Math.pow(element, count);
            ans = floorMod(pow, modNum);
            System.out.println("第" + count + "次：" + ans);
            count++;
        }
        return;
    }
}
