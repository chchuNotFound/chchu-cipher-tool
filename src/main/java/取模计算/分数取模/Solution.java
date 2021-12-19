package 取模计算.分数取模;

public class Solution {

    public static void main(String[] args) {
//        findN(3817);
        findN(650, 27);
    }

    public static void findN(int val, int modNum) {
        for (int i = 0; i < modNum; i++) {
            if ((i * val) % modNum == 1) {
                System.out.println("n = " + i);
                break;
            }
        }
        return;
    }

}