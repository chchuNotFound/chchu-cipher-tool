package DES算法;

import java.util.HashMap;

public class Solution {

    static HashMap<Integer, Integer> ipTable = new HashMap<>();
    static HashMap<Integer, Integer> permuTable1 = new HashMap<>();
    static HashMap<Integer, Integer> permuTable2 = new HashMap<>();

    public static void main(String[] args) {

        ipTable.put(1, 58); ipTable.put(2, 50);ipTable.put(3, 42); ipTable.put(4, 34);
        ipTable.put(5, 26); ipTable.put(6, 18);ipTable.put(7, 10); ipTable.put(8, 2);
        ipTable.put(9, 60); ipTable.put(10, 52);ipTable.put(11, 44); ipTable.put(12, 36);
        ipTable.put(13, 28); ipTable.put(14, 20);ipTable.put(15, 12); ipTable.put(16, 4);
        ipTable.put(17, 62); ipTable.put(18, 54);ipTable.put(19, 46); ipTable.put(20, 38);
        ipTable.put(21, 30); ipTable.put(22, 22);ipTable.put(23, 14); ipTable.put(24, 6);
        ipTable.put(25, 64); ipTable.put(26, 56);ipTable.put(27, 48); ipTable.put(28, 40);
        ipTable.put(29, 32); ipTable.put(30, 24);ipTable.put(31, 16); ipTable.put(32, 8);
        ipTable.put(33, 57); ipTable.put(34, 49);ipTable.put(35, 41); ipTable.put(36, 33);
        ipTable.put(37, 25); ipTable.put(38, 17);ipTable.put(39, 9); ipTable.put(40, 1);
        ipTable.put(41, 59); ipTable.put(42, 51);ipTable.put(43, 43); ipTable.put(44, 35);
        ipTable.put(45, 27); ipTable.put(46, 19);ipTable.put(47, 11); ipTable.put(48, 3);
        ipTable.put(49, 61); ipTable.put(50, 53);ipTable.put(51, 45); ipTable.put(52, 37);
        ipTable.put(53, 29); ipTable.put(54, 21);ipTable.put(55, 13); ipTable.put(56, 5);
        ipTable.put(57, 63); ipTable.put(58, 55);ipTable.put(59, 47); ipTable.put(60, 39);
        ipTable.put(61, 31); ipTable.put(62, 23);ipTable.put(63, 15); ipTable.put(64, 7);


        permuTable1.put(1, 57); permuTable1.put(2, 49); permuTable1.put(3, 41); permuTable1.put(4, 33);
        permuTable1.put(5, 25); permuTable1.put(6, 17); permuTable1.put(7, 9);
        permuTable1.put(9, 1); permuTable1.put(10, 58); permuTable1.put(11, 50); permuTable1.put(12, 42);
        permuTable1.put(13, 34); permuTable1.put(14, 26); permuTable1.put(15, 18);
        permuTable1.put(17, 10); permuTable1.put(18, 2); permuTable1.put(19, 59); permuTable1.put(20, 51);
        permuTable1.put(21, 43); permuTable1.put(22, 35); permuTable1.put(23, 27);
        permuTable1.put(25, 19); permuTable1.put(26, 11); permuTable1.put(27, 3); permuTable1.put(28, 60);
        permuTable1.put(29, 52); permuTable1.put(30, 44); permuTable1.put(31, 36);
        permuTable1.put(33, 63); permuTable1.put(34, 55); permuTable1.put(35, 47); permuTable1.put(36, 39);
        permuTable1.put(37, 31); permuTable1.put(38, 23); permuTable1.put(39, 15);
        permuTable1.put(41, 7); permuTable1.put(42, 62); permuTable1.put(43, 54); permuTable1.put(44, 46);
        permuTable1.put(45, 38); permuTable1.put(46, 30); permuTable1.put(47, 22);
        permuTable1.put(49, 14); permuTable1.put(50, 6); permuTable1.put(51, 61); permuTable1.put(52, 53);
        permuTable1.put(53, 45); permuTable1.put(54, 37); permuTable1.put(55, 29);
        permuTable1.put(57, 21); permuTable1.put(58, 13); permuTable1.put(59, 5); permuTable1.put(60, 28);
        permuTable1.put(61, 20); permuTable1.put(62, 12); permuTable1.put(63, 4);


        permuTable2.put(1, 14); permuTable2.put(2, 17); permuTable2.put(3, 11); permuTable2.put(4, 24);
        permuTable2.put(5, 1); permuTable2.put(6, 5); permuTable2.put(7, 3);permuTable2.put(8, 28);
        permuTable2.put(10, 15); permuTable2.put(11, 6); permuTable2.put(12, 21); permuTable2.put(13, 10);
        permuTable2.put(14, 23);permuTable2.put(15, 19); permuTable2.put(16, 12); permuTable2.put(17, 4);
        permuTable2.put(19, 26); permuTable2.put(20, 8);permuTable2.put(21, 16); permuTable2.put(23, 7);
        permuTable2.put(24, 27); permuTable2.put(26, 20); permuTable2.put(27, 13); permuTable2.put(28, 2);
        permuTable2.put(29, 41); permuTable2.put(30, 52); permuTable2.put(31, 31); permuTable2.put(32, 37);
        permuTable2.put(33, 47);permuTable2.put(34, 55); permuTable2.put(36, 30); permuTable2.put(37, 40);
        permuTable2.put(39, 51); permuTable2.put(40, 45); permuTable2.put(41, 33); permuTable2.put(42, 48);
        permuTable2.put(44, 44); permuTable2.put(45, 49); permuTable2.put(46, 39); permuTable2.put(47, 56);
        permuTable2.put(48, 34); permuTable2.put(49, 53); permuTable2.put(50, 46); permuTable2.put(51, 42);
        permuTable2.put(52, 50); permuTable2.put(53, 36); permuTable2.put(55, 29);permuTable2.put(56, 32);

        int[] plaintext = {
                0,0,0,0, 0,0,0,1, 0,0,1,0, 0,0,1,1, 0,1,0,0, 0,1,0,1, 0,1,1,0, 0,1,1,1,
                1,0,0,0, 1,0,0,1, 1,0,1,0, 1,0,1,1, 1,1,0,0, 1,1,0,1, 1,1,1,0, 1,1,1,1
        };
        int[] key = {
                0,0,0,0, 0,0,0,1, 0,0,1,0, 0,0,1,1, 0,1,0,0, 0,1,0,1, 0,1,1,0, 0,1,1,1,
                1,0,0,0, 1,0,0,1, 1,0,1,0, 1,0,1,1, 1,1,0,0, 1,1,0,1, 1,1,1,0, 1,1,1,1
        };
        keyPermutation(key);
//        ipPermutation(plaintext);



    }

    /**
     * IP置换目的是将输入的64位数据块按位重新组合，并把输出分为L0、R0两部分，每部分各长32位。
     * @param plaintext
     */
    public static void ipPermutation(int[] plaintext) {
        int[] changedPlaintext = new int[plaintext.length];

        for(int i = 0; i < plaintext.length; i++) {
            changedPlaintext[i] = plaintext[i];
        }

        for(int i = 0; i < changedPlaintext.length; i++) {
            changedPlaintext[i] = plaintext[ipTable.get(i + 1) - 1];
        }

        System.out.println("L0:");
        for (int i = 0; i < plaintext.length; i++) {
            System.out.print(changedPlaintext[i]);
            if((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if((i + 1) % 8 == 0) {
                System.out.println("");
            }
            if((i + 1) % 32 == 0 && i != 63) {
                System.out.println("R0:");
            }
        }

    }

    public static void keyPermutation(int[] key) {

        // 初始化changedKey1
        int[] changedKey1 = new int[64];
        for(int i = 0; i < 64; i++) {
            changedKey1[i] = key[i];
        }
        // 查置换表1
        for(int i = 0; i < 64; i++) {
            if((i + 1) % 8 == 0) {continue;}
            changedKey1[i] = key[permuTable1.get(i + 1) - 1];
        }
        // 将changedKey1清除冗余作为changedKey2，限制长度为56
        int[] changedKey2 = new int[56];
        int count1 = 0;
        int count2 = 0;
        while(count1 < 56) {
            if((count2 + 1) % 8 == 0) {
                count2 ++;
                continue;
            }
            changedKey2[count1] = changedKey1[count2];
            count1 ++;
            count2 ++;
        }

        System.out.println("经一次置换表后：");
        for (int i = 0; i < 56; i++) {
            System.out.print(changedKey2[i]);
            if((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if((i + 1) % 28 == 0) {
                System.out.println("");
            }
        }

        // 上下两部分各循环左移1位
        int temp = changedKey2[0];
        for(int i = 0; i < 27; i++) {
            changedKey2[i] = changedKey2[i + 1];
        }
        changedKey2[27] = temp;
        temp = changedKey2[28];
        for(int i = 28; i < 55; i++) {
            changedKey2[i] = changedKey2[i + 1];
        }
        changedKey2[55] = temp;

        System.out.println("上下部分28位各循环左移1位后的状态：");
        for (int i = 0; i < 56; i++) {
            System.out.print(changedKey2[i]);
            if((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if((i + 1) % 28 == 0) {
                System.out.println("");
            }
        }

        // 新的一轮置换需要changedKey2的copy
        int[] changedKey2Copy = new int[56];
        for(int i = 0; i < 56; i++) {
            changedKey2Copy[i] = changedKey2[i];
        }

//        for (int i = 0; i < 56; i++) {
//            System.out.print(changedKey2Copy[i]);
//        }

        // 查置换表2
        for(int i = 0; i < 56; i++) {
            if((i + 1) == 9 || (i + 1) == 18 || (i + 1) == 22
                    || (i + 1) == 25 || (i + 1) == 35 || (i + 1) == 38
                    || (i + 1) == 43 || (i + 1) == 54 ) {continue;}
            changedKey2[i] = changedKey2Copy[permuTable2.get(i + 1) - 1];
        }

        // 去除中changedKey2中的冗余信息，作为K1
        int[] k1 = new int[48];
        count1 = 0;
        count2 = 0;
        while(count1 < 48) {
            if((count2 + 1) == 9 || (count2 + 1) == 18 || (count2 + 1) == 22
                    || (count2 + 1) == 25 || (count2 + 1) == 35 || (count2 + 1) == 38
                    || (count2 + 1) == 43 || (count2 + 1) == 54 ) {
                count2++;
                continue;
            }
            k1[count1] = changedKey2[count2];
            count1 ++;
            count2 ++;
        }
        System.out.println("K1: ");
        for (int i = 0; i < 48; i++) {
            System.out.print(k1[i]);
            if((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
            if((i + 1) % 24 == 0) {
                System.out.println("");
            }
        }

    }


}
