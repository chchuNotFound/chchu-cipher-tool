package DES算法;

import java.util.HashMap;

public class Solution {

    static HashMap<Integer, Integer> ipTable = new HashMap<>();
    static HashMap<Integer, Integer> permuTable1 = new HashMap<>();
    static HashMap<Integer, Integer> permuTable2 = new HashMap<>();
    static HashMap<Integer, Integer> exPermutation = new HashMap<>();
    static HashMap<Integer, String> decToBinString = new HashMap<>();
    static HashMap<Integer, Integer> pBox = new HashMap<>();
    static int[] A1 = new int[8];
    static int[] A2 = new int[8];
    static int[] A3 = new int[8];
    static int[] A4 = new int[8];
    static int[] A5 = new int[8];
    static int[] A6 = new int[8];
    static int[] A7 = new int[8];
    static int[] A8 = new int[8];
    static int[][] S1 = new int[][]{
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
    };
    static int[][] S2 = new int[][]{
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
            {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
    };
    static int[][] S3 = new int[][]{
            {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
    };
    static int[][] S4 = new int[][]{
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 19},
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
    };
    static int[][] S5 = new int[][]{
            {2, 12, 4, 1, 7, 10, 11, 6, 5, 8, 3, 15, 13, 0, 14, 9},
            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 13, 3, 9, 8, 6},
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
    };
    static int[][] S6 = new int[][]{
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
    };
    static int[][] S7 = new int[][]{
            {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
    };
    static int[][] S8 = new int[][]{
            {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
    };


    public static void main(String[] args) {

        ipTable.put(1, 58);
        ipTable.put(2, 50);
        ipTable.put(3, 42);
        ipTable.put(4, 34);
        ipTable.put(5, 26);
        ipTable.put(6, 18);
        ipTable.put(7, 10);
        ipTable.put(8, 2);
        ipTable.put(9, 60);
        ipTable.put(10, 52);
        ipTable.put(11, 44);
        ipTable.put(12, 36);
        ipTable.put(13, 28);
        ipTable.put(14, 20);
        ipTable.put(15, 12);
        ipTable.put(16, 4);
        ipTable.put(17, 62);
        ipTable.put(18, 54);
        ipTable.put(19, 46);
        ipTable.put(20, 38);
        ipTable.put(21, 30);
        ipTable.put(22, 22);
        ipTable.put(23, 14);
        ipTable.put(24, 6);
        ipTable.put(25, 64);
        ipTable.put(26, 56);
        ipTable.put(27, 48);
        ipTable.put(28, 40);
        ipTable.put(29, 32);
        ipTable.put(30, 24);
        ipTable.put(31, 16);
        ipTable.put(32, 8);
        ipTable.put(33, 57);
        ipTable.put(34, 49);
        ipTable.put(35, 41);
        ipTable.put(36, 33);
        ipTable.put(37, 25);
        ipTable.put(38, 17);
        ipTable.put(39, 9);
        ipTable.put(40, 1);
        ipTable.put(41, 59);
        ipTable.put(42, 51);
        ipTable.put(43, 43);
        ipTable.put(44, 35);
        ipTable.put(45, 27);
        ipTable.put(46, 19);
        ipTable.put(47, 11);
        ipTable.put(48, 3);
        ipTable.put(49, 61);
        ipTable.put(50, 53);
        ipTable.put(51, 45);
        ipTable.put(52, 37);
        ipTable.put(53, 29);
        ipTable.put(54, 21);
        ipTable.put(55, 13);
        ipTable.put(56, 5);
        ipTable.put(57, 63);
        ipTable.put(58, 55);
        ipTable.put(59, 47);
        ipTable.put(60, 39);
        ipTable.put(61, 31);
        ipTable.put(62, 23);
        ipTable.put(63, 15);
        ipTable.put(64, 7);


        permuTable1.put(1, 57);
        permuTable1.put(2, 49);
        permuTable1.put(3, 41);
        permuTable1.put(4, 33);
        permuTable1.put(5, 25);
        permuTable1.put(6, 17);
        permuTable1.put(7, 9);
        permuTable1.put(9, 1);
        permuTable1.put(10, 58);
        permuTable1.put(11, 50);
        permuTable1.put(12, 42);
        permuTable1.put(13, 34);
        permuTable1.put(14, 26);
        permuTable1.put(15, 18);
        permuTable1.put(17, 10);
        permuTable1.put(18, 2);
        permuTable1.put(19, 59);
        permuTable1.put(20, 51);
        permuTable1.put(21, 43);
        permuTable1.put(22, 35);
        permuTable1.put(23, 27);
        permuTable1.put(25, 19);
        permuTable1.put(26, 11);
        permuTable1.put(27, 3);
        permuTable1.put(28, 60);
        permuTable1.put(29, 52);
        permuTable1.put(30, 44);
        permuTable1.put(31, 36);
        permuTable1.put(33, 63);
        permuTable1.put(34, 55);
        permuTable1.put(35, 47);
        permuTable1.put(36, 39);
        permuTable1.put(37, 31);
        permuTable1.put(38, 23);
        permuTable1.put(39, 15);
        permuTable1.put(41, 7);
        permuTable1.put(42, 62);
        permuTable1.put(43, 54);
        permuTable1.put(44, 46);
        permuTable1.put(45, 38);
        permuTable1.put(46, 30);
        permuTable1.put(47, 22);
        permuTable1.put(49, 14);
        permuTable1.put(50, 6);
        permuTable1.put(51, 61);
        permuTable1.put(52, 53);
        permuTable1.put(53, 45);
        permuTable1.put(54, 37);
        permuTable1.put(55, 29);
        permuTable1.put(57, 21);
        permuTable1.put(58, 13);
        permuTable1.put(59, 5);
        permuTable1.put(60, 28);
        permuTable1.put(61, 20);
        permuTable1.put(62, 12);
        permuTable1.put(63, 4);


        permuTable2.put(1, 14);
        permuTable2.put(2, 17);
        permuTable2.put(3, 11);
        permuTable2.put(4, 24);
        permuTable2.put(5, 1);
        permuTable2.put(6, 5);
        permuTable2.put(7, 3);
        permuTable2.put(8, 28);
        permuTable2.put(10, 15);
        permuTable2.put(11, 6);
        permuTable2.put(12, 21);
        permuTable2.put(13, 10);
        permuTable2.put(14, 23);
        permuTable2.put(15, 19);
        permuTable2.put(16, 12);
        permuTable2.put(17, 4);
        permuTable2.put(19, 26);
        permuTable2.put(20, 8);
        permuTable2.put(21, 16);
        permuTable2.put(23, 7);
        permuTable2.put(24, 27);
        permuTable2.put(26, 20);
        permuTable2.put(27, 13);
        permuTable2.put(28, 2);
        permuTable2.put(29, 41);
        permuTable2.put(30, 52);
        permuTable2.put(31, 31);
        permuTable2.put(32, 37);
        permuTable2.put(33, 47);
        permuTable2.put(34, 55);
        permuTable2.put(36, 30);
        permuTable2.put(37, 40);
        permuTable2.put(39, 51);
        permuTable2.put(40, 45);
        permuTable2.put(41, 33);
        permuTable2.put(42, 48);
        permuTable2.put(44, 44);
        permuTable2.put(45, 49);
        permuTable2.put(46, 39);
        permuTable2.put(47, 56);
        permuTable2.put(48, 34);
        permuTable2.put(49, 53);
        permuTable2.put(50, 46);
        permuTable2.put(51, 42);
        permuTable2.put(52, 50);
        permuTable2.put(53, 36);
        permuTable2.put(55, 29);
        permuTable2.put(56, 32);

        exPermutation.put(0, 32);
        exPermutation.put(5, 5);
        exPermutation.put(6, 4);
        exPermutation.put(11, 9);
        exPermutation.put(12, 8);
        exPermutation.put(17, 13);
        exPermutation.put(18, 12);
        exPermutation.put(23, 17);
        exPermutation.put(24, 16);
        exPermutation.put(29, 21);
        exPermutation.put(30, 20);
        exPermutation.put(35, 25);
        exPermutation.put(36, 24);
        exPermutation.put(41, 29);
        exPermutation.put(42, 28);
        exPermutation.put(47, 1);

        decToBinString.put(0, "0000");
        decToBinString.put(1, "0001");
        decToBinString.put(2, "0010");
        decToBinString.put(3, "0011");
        decToBinString.put(4, "0100");
        decToBinString.put(5, "0101");
        decToBinString.put(6, "0110");
        decToBinString.put(7, "0111");
        decToBinString.put(8, "1000");
        decToBinString.put(9, "1001");
        decToBinString.put(10, "1010");
        decToBinString.put(11, "1011");
        decToBinString.put(12, "1100");
        decToBinString.put(13, "1101");
        decToBinString.put(14, "1110");
        decToBinString.put(15, "1111");

        pBox.put(0, 16);pBox.put(1, 7);
        pBox.put(2, 20);pBox.put(3, 21);
        pBox.put(4, 29);pBox.put(5, 12);
        pBox.put(6, 28);pBox.put(7, 17);
        pBox.put(8, 1);pBox.put(9, 15);
        pBox.put(10, 23);pBox.put(11, 26);
        pBox.put(12, 5);pBox.put(13, 18);
        pBox.put(14, 31);pBox.put(15, 10);
        pBox.put(16, 2);pBox.put(17, 8);
        pBox.put(18, 24);pBox.put(19, 14);
        pBox.put(20, 32);pBox.put(21, 27);
        pBox.put(22, 3);pBox.put(23, 9);
        pBox.put(24, 19);pBox.put(25, 13);
        pBox.put(26, 30);pBox.put(27, 6);
        pBox.put(28, 22);pBox.put(29, 11);
        pBox.put(30, 4);pBox.put(31, 25);


        int[] plaintext = {
                0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1,
                1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1
        };
        int[] key = {
                0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1,
                1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1
        };
        int[] K1 = keyPermutation(key);
        int[] ER0 = ipPermutation(plaintext);
        // 需手动输入，从控制台获得
        int[] L0 = {
                1,1,0,0, 1,1,0,0,
                0,0,0,0, 0,0,0,0,
                1,1,0,0, 1,1,0,0,
                1,1,1,1, 1,1,1,1
        };
        int[] R0 = {
                1,1,1,1, 0,0,0,0,
                1,0,1,0, 1,0,1,0,
                1,1,1,1, 0,0,0,0,
                1,0,1,0, 1,0,1,0
        };
        int[] A = XOR(ER0, K1);
        splitA(A);
        // 需手动输入：
        // 例如，假设S盒8的输入为110011。
        // 第1位和第6位组合为11，对应于S盒8的第3行；
        // 第2位到第5位为1001，对应于S盒8的第9列。
        // S盒8的第3行第9列的数字为12，因此用1100来代替110011。
        // 注意，S盒的行列计数都是从0开始。
        querySbox(0, 14, 1, 8, 0, 14, 2, 9, 2, 12, 1, 10, 3, 9, 2, 8);
        // 根据querySbox查询结果，手动输入：如第二组查询结果为12，则第二组为1100
        int[] B = new int[]{
                0,0,0,0,
                1,1,0,0,
                0,0,1,0,
                0,0,0,1,
                0,1,1,0,
                1,1,0,1,
                0,1,0,1,
                0,0,0,0
        };
        int[] PB = pTrans(B);
        int[] R1 = pResultXorL0(PB, L0);
        int[] L1 = R0;
        L1CombineR1(L1, R1);

    }


    /**
     * 求K1
     *
     * @param key
     */
    public static int[] keyPermutation(int[] key) {
        // 初始化changedKey1
        int[] changedKey1 = new int[64];
        for (int i = 0; i < 64; i++) {
            changedKey1[i] = key[i];
        }
        // 查置换表1
        for (int i = 0; i < 64; i++) {
            if ((i + 1) % 8 == 0) {
                continue;
            }
            changedKey1[i] = key[permuTable1.get(i + 1) - 1];
        }
        // 将changedKey1清除冗余作为changedKey2，限制长度为56
        int[] changedKey2 = new int[56];
        int count1 = 0;
        int count2 = 0;
        while (count1 < 56) {
            if ((count2 + 1) % 8 == 0) {
                count2++;
                continue;
            }
            changedKey2[count1] = changedKey1[count2];
            count1++;
            count2++;
        }

        System.out.println("经一次置换表后：");
        for (int i = 0; i < 56; i++) {
            System.out.print(changedKey2[i]);
            if ((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if ((i + 1) % 28 == 0) {
                System.out.println("");
            }
        }

        // 上下两部分各循环左移1位
        int temp = changedKey2[0];
        for (int i = 0; i < 27; i++) {
            changedKey2[i] = changedKey2[i + 1];
        }
        changedKey2[27] = temp;
        temp = changedKey2[28];
        for (int i = 28; i < 55; i++) {
            changedKey2[i] = changedKey2[i + 1];
        }
        changedKey2[55] = temp;

        System.out.println("上下部分28位各循环左移1位后的状态：");
        for (int i = 0; i < 56; i++) {
            System.out.print(changedKey2[i]);
            if ((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if ((i + 1) % 28 == 0) {
                System.out.println("");
            }
        }

        // 新的一轮置换需要changedKey2的copy
        int[] changedKey2Copy = new int[56];
        for (int i = 0; i < 56; i++) {
            changedKey2Copy[i] = changedKey2[i];
        }

//        for (int i = 0; i < 56; i++) {
//            System.out.print(changedKey2Copy[i]);
//        }

        // 查置换表2
        for (int i = 0; i < 56; i++) {
            if ((i + 1) == 9 || (i + 1) == 18 || (i + 1) == 22
                    || (i + 1) == 25 || (i + 1) == 35 || (i + 1) == 38
                    || (i + 1) == 43 || (i + 1) == 54) {
                continue;
            }
            changedKey2[i] = changedKey2Copy[permuTable2.get(i + 1) - 1];
        }

        // 去除中changedKey2中的冗余信息，作为K1
        int[] k1 = new int[48];
        count1 = 0;
        count2 = 0;
        while (count1 < 48) {
            if ((count2 + 1) == 9 || (count2 + 1) == 18 || (count2 + 1) == 22
                    || (count2 + 1) == 25 || (count2 + 1) == 35 || (count2 + 1) == 38
                    || (count2 + 1) == 43 || (count2 + 1) == 54) {
                count2++;
                continue;
            }
            k1[count1] = changedKey2[count2];
            count1++;
            count2++;
        }
        System.out.println("K1: ");
        for (int i = 0; i < 48; i++) {
            System.out.print(k1[i]);
            if ((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if ((i + 1) % 24 == 0) {
                System.out.println("");
            }
        }
        return k1;
    }

    /**
     * 计算L0，R0和E(R0)
     * IP置换目的是将输入的64位数据块按位重新组合，并把输出分为L0、R0两部分，每部分各长32位。
     *
     * @param plaintext
     */
    public static int[] ipPermutation(int[] plaintext) {
        int[] changedPlaintext = new int[plaintext.length];

        for (int i = 0; i < plaintext.length; i++) {
            changedPlaintext[i] = plaintext[i];
        }

        for (int i = 0; i < changedPlaintext.length; i++) {
            changedPlaintext[i] = plaintext[ipTable.get(i + 1) - 1];
        }

        System.out.println("L0:");
        for (int i = 0; i < plaintext.length; i++) {
            System.out.print(changedPlaintext[i]);
            if ((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if ((i + 1) % 8 == 0) {
                System.out.println("");
            }
            if ((i + 1) % 32 == 0 && i != 63) {
                System.out.println("R0:");
            }

        }

        int[] ER0 = new int[48];
        int count = 32;
        for (int i = 0; i < 48; i++) {
            if (exPermutation.containsKey(i)) {
                ER0[i] = changedPlaintext[32 + exPermutation.get(i) - 1];
            } else {
                ER0[i] = changedPlaintext[count];
                count++;
            }
        }

        System.out.println("E(R0): ");
        for (int i = 0; i < 48; i++) {
            if (i != 0 && i % 6 == 0) {
                System.out.print(" ");
            }
            if (i != 0 && i % 24 == 0) {
                System.out.println("");
            }
            System.out.print(ER0[i]);
        }
        System.out.println("");
        return ER0;
    }

    /**
     * 计算E(R0)异或K1，得到结果A
     *
     * @param ER0
     * @param k1
     * @return
     */
    public static int[] XOR(int[] ER0, int[] k1) {
        int[] res = new int[48];
        for (int i = 0; i < 48; i++) {
            res[i] = 0;
        }
        for (int i = 0; i < 48; i++) {
            res[i] = ER0[i] ^ k1[i];
        }
        System.out.println("E(R0)每位与K1异或后的结果");
        System.out.println("A：");
        for (int i = 0; i < 48; i++) {
            if (i != 0 && i % 6 == 0) {
                System.out.print(" ");
            }
            if (i != 0 && i % 24 == 0) {
                System.out.println("");
            }
            System.out.print(res[i]);
        }
        return res;
    }

    /**
     * 将A划分为8个集合，得：A1,A2,A3,A4,A5,A6,A7,A8
     *
     * @param A
     */
    public static void splitA(int[] A) {
        for (int i = 0; i < 6; i++) {
            A1[i] = A[i];
        }
        for (int i = 0; i < 6; i++) {
            A2[i] = A[i + 6];
        }
        for (int i = 0; i < 6; i++) {
            A3[i] = A[i + 12];
        }
        for (int i = 0; i < 6; i++) {
            A4[i] = A[i + 18];
        }
        for (int i = 0; i < 6; i++) {
            A5[i] = A[i + 24];
        }
        for (int i = 0; i < 6; i++) {
            A6[i] = A[i + 30];
        }
        for (int i = 0; i < 6; i++) {
            A7[i] = A[i + 36];
        }
        for (int i = 0; i < 6; i++) {
            A8[i] = A[i + 42];
        }
        System.out.println("");
        System.out.print("A1 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A1[i]);
        }

        System.out.println("");
        System.out.print("A2 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A2[i]);
        }

        System.out.println("");
        System.out.print("A3 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A3[i]);
        }

        System.out.println("");
        System.out.print("A4 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A4[i]);
        }

        System.out.println("");
        System.out.print("A5 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A5[i]);
        }

        System.out.println("");
        System.out.print("A6 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A6[i]);
        }
        System.out.println("");
        System.out.print("A7 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A7[i]);
        }
        System.out.println("");
        System.out.print("A8 : ");
        for (int i = 0; i < 6; i++) {
            System.out.print(A8[i]);
        }


    }

    /**
     * 查询Sbox
     *
     * @param
     */
    public static void querySbox(int A1, int B1, int A2, int B2, int A3, int B3, int A4, int B4, int A5, int B5, int A6, int B6, int A7, int B7, int A8, int B8) {
        int s1 = S1[A1][B1];
        int s2 = S2[A2][B2];
        int s3 = S3[A3][B3];
        int s4 = S4[A4][B4];
        int s5 = S5[A5][B5];
        int s6 = S6[A6][B6];
        int s7 = S7[A7][B7];
        int s8 = S8[A8][B8];

        System.out.println("");
        System.out.println("S1的查询结果：" + s1);
        System.out.println("S2的查询结果：" + s2);
        System.out.println("S3的查询结果：" + s3);
        System.out.println("S4的查询结果：" + s4);
        System.out.println("S5的查询结果：" + s5);
        System.out.println("S6的查询结果：" + s6);
        System.out.println("S7的查询结果：" + s7);
        System.out.println("S8的查询结果：" + s8);

        String bin1 = decToBinString.get(s1);
        String bin2 = decToBinString.get(s2);
        String bin3 = decToBinString.get(s3);
        String bin4 = decToBinString.get(s4);
        String bin5 = decToBinString.get(s5);
        String bin6 = decToBinString.get(s6);
        String bin7 = decToBinString.get(s7);
        String bin8 = decToBinString.get(s8);
        System.out.println("B:" + bin1 +" "+ bin2 + " " + bin3 + " " + bin4 + " " + bin5 + " " + bin6 + " " + bin7 + " " + bin8);
    }

    /**
     * P盒置换
     * @param B
     * @return
     */
    public static int[] pTrans(int[] B) {
        int[] PB = new int[32];
        for (int i = 0; i < B.length; i++) {
            PB[i] = B[pBox.get(i) - 1];
        }
        System.out.print("P(B):");
        for(int i = 0; i < PB.length; i++) {
            if(i % 4 == 0 && i != 0) {
                System.out.print(" ");
            }
            System.out.print(PB[i]);
        }
        return PB;
    }

    /**
     * P(B)与L0进行异或
     * @param PB
     * @return
     */
    public static int[] pResultXorL0(int[] PB, int[] L0) {
        int[] R1 = new int[32];
        for(int i = 0; i < PB.length; i++) {
            if(L0[i] == PB[i]) {
                R1[i] = 0;
            } else {
                R1[i] = 1;
            }
        }
        System.out.println("");
        System.out.print("R1: ");
        for(int i = 0; i < R1.length; i++) {
            if(i % 4 == 0 && i != 0) {
                System.out.print(" ");
            }
            System.out.print(R1[i]);
        }
        return R1;
    }

    /**
     * 将L1和R1相拼接
     * @param L1
     * @param R1
     */
    public static void L1CombineR1(int[] L1, int[] R1) {
        System.out.println("");
        System.out.print("L1||R1: ");
        System.out.println("");
        for(int i = 0; i < L1.length; i++) {
            if(i % 4 == 0 && i != 0) {
                System.out.print(" ");
            }
            System.out.print(L1[i]);
        }
        System.out.println("");
        for(int i = 0; i < R1.length; i++) {
            if(i % 4 == 0 && i != 0) {
                System.out.print(" ");
            }
            System.out.print(R1[i]);
        }
        return;
    }
}
