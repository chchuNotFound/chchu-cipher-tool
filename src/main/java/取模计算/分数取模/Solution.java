package 取模计算.分数取模;

public class Solution {

    public static void main(String[] args) {
//        findN(3817);
        findN(15);
    }

    public static void findN(int val) {
        for (int i = 0; i < 26; i++) {
            if ((i * val) % 26 == 1) {
                System.out.println("n = " + i);
                break;
            }
        }
        return;
    }

}