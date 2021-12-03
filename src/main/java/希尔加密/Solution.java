package 希尔加密;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix =
        {
                {1, 11, 12},
                {4, 23,  2},
                {17,15,  9}
        };
        hillEncoder(
                "LOOKING" +
                "FORWARD" +
                "TO" +
                "OUR" +
                "NATIONAL" +
                "DAY"
                , matrix);
    }

    public static void hillEncoder(String plaintext, int[][] matrix) {
        List<Integer> plaintextIndex = new ArrayList<>();

        for(int i = 0; i < plaintext.length(); i++) {
            plaintextIndex.add(plaintext.charAt(i) - 'A');
        }

        for(int i = 0; i < plaintext.length() / matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = 0;
                for(int k = 0; k < matrix.length; k++) {
                    int num = i * matrix.length + k;
                    int plaintextNum = plaintextIndex.get(num);
                    sum = sum + plaintextNum * matrix[num % matrix.length][j];
//                    System.out.print(plaintextNum + ", ");
                }
                sum = floorMod(sum, 26);
                char newChar = (char) (sum + 'A');
                System.out.print( newChar + ", ");
            }
        }

    }


}
