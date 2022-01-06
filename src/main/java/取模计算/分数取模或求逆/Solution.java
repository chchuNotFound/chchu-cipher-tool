package 取模计算.分数取模或求逆;

public class Solution {

    public static void main(String[] args) {
        findN(2, 211*199);
    }

    public static void findN(long val, long modNum) {
        for (int i = 0; i < modNum; i++) {
            if ((i * val) % modNum == 1) {
                System.out.println("n = " + i);
                break;
            }
        }
        return;
    }

}