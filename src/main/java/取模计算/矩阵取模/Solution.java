package 取模计算.矩阵取模;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {
                {1409 * 11, 73, 2772 * 11},
                {1246 * 11, 67, 1633 * 11},
                {      -72,-38,      -203}
        };

        matrixMod(matrix);
    }

    public static void matrixMod(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = floorMod(matrix[i][j], 26);
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if(j != matrix[0].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("");
        }
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
