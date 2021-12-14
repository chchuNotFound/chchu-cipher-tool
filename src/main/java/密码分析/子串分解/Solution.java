package 密码分析.子串分解;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static HashMap<Character, Double> alpha = new HashMap<>();

    public static void main(String[] args) {
        alpha.put('A', 0.082);alpha.put('B', 0.015);
        alpha.put('C', 0.028);alpha.put('D', 0.043);
        alpha.put('E', 0.127);alpha.put('F', 0.022);
        alpha.put('G', 0.020);alpha.put('H', 0.061);
        alpha.put('I', 0.070);alpha.put('J', 0.002);
        alpha.put('K', 0.008);alpha.put('L', 0.040);
        alpha.put('M', 0.024);alpha.put('N', 0.067);
        alpha.put('O', 0.075);alpha.put('P', 0.019);
        alpha.put('Q', 0.001);alpha.put('R', 0.060);
        alpha.put('S', 0.063);alpha.put('T', 0.091);
        alpha.put('U', 0.028);alpha.put('V', 0.010);
        alpha.put('W', 0.023);alpha.put('X', 0.001);
        alpha.put('Y', 0.020);alpha.put('Z', 0.001);
        System.out.println("请输入m: ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        String rawString =
                "CHRE EVOA HMAE RATB IAXX WTNX BEEO PHBS BQMQ EQER BWRV " +
                "XUOA KXAO SXXW EAHB WGJM MQMN KGRF VGXW TRZX WIAK LXFP " +
                "SKAU TEMN DCMG TSXM XBTU IADN GMGP SREL XNJE LXVR VPRT " +
                "ULHD NQWT WDTY GBPH XTFA LJHA SVBF XNGL LCHR ZBWE LEKM " +
                "SJIK NBHW RJGN MGJS GLXF EYPH AGNR BIEQ JTAM RVLC RREM " +
                "NDGL XRRI MGNS NRWC HRQH AEYE VTAQ EBBI PEEW EVKA KOEW " +
                "ADRE MXMT BHHC HRTK DNVR ZCHR CLQO HPWQ AIIW XNRM GWOI " +
                "IFKE E";
        String treatedString = pretreatment(rawString);
//        System.out.println(treatedString);
        splitTOSubstring(treatedString, m);

    }

    /**
     * 去除字符串的空格
     * @param rawtext
     * @return
     */
    public static String pretreatment(String rawtext) {
        String ciphertext = "";
        for (int i = 0; i < rawtext.length(); i++) {
            if (rawtext.charAt(i) == ' ') {
                continue;
            }
            ciphertext = ciphertext + rawtext.charAt(i);
        }
        return ciphertext;
    }

    /**
     * 将字符串划分为子字符串
     * @param rawString
     * @param m
     */
    public static void splitTOSubstring(String rawString, int m) {
        String[] str = new String[m];

        for(int i = 0; i < m; i++) {
            str[i] = "";
            for(int j = 0; j < rawString.length() / m; j++) {
                str[i] = str[i] + rawString.charAt(j * m + i);
            }
        }

        // 若还有字符没有拼接到子字符串上（判断方式：取余）
        for(int i = 0; i < rawString.length() % m; i++) {
            str[i] = str[i] + rawString.charAt((rawString.length() / m) * m + i);
        }
        for (int i = 0; i < m; i++) {
            System.out.println("字符串" + i + "：" + str[i]);
        }
        System.out.println("=======================================");
        System.out.println("value of Mg(yi)");
        for(int i = 0; i < m; i++) {
            System.out.println("---------------------");
            System.out.println("i = " + i);
            statAlphaProbDistr(str[i]);
        }
    }

    public static void statAlphaProbDistr(String str) {
        Map<Character, Double> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put((char) (i + 'A'), 0.0);
        }
        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        double length = str.length();
        double max = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            double sum = 0.0;
            for(int j = 0; j < 26; j++) {
                char changedCh = (char) ((i + j) % 26 + 'A');
                char alphaCh = (char) (j + 'A');
                Double mapValue = map.get(changedCh);
                double p = alpha.get(alphaCh);
                double cal = (mapValue/length) * p;
                sum = sum + cal;
            }
            BigDecimal bd = new BigDecimal(sum).setScale(3, RoundingMode.HALF_UP);
            sum = bd.doubleValue();
            System.out.print("Mg("+ i + ")= " + sum + " ; ");
            if((i % 6 == 0 || i == 25 )&& i != 0) {
                System.out.println("");
            }
            if( sum > max ) {
                max = sum;
                index = i;
            }
        }
        System.out.println("max of Mg("+ index + ") = " + max);
        System.out.println("code = " + (char)(index + 'A'));
    }

}
