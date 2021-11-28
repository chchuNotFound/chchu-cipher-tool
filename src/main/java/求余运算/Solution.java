package 求余运算;

public class Solution {

    public static void main(String[] args) {
        findN(53);
        System.out.println((-66 * 11) % 26);
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