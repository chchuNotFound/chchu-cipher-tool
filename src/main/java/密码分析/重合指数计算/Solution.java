package 密码分析.重合指数计算;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String rawtext =
                        "CHRE EVOA HMAE RATB IAXX WTNX BEEO PHBS BQMQ EQER BWRV " +
                        "XUOA KXAO SXXW EAHB WGJM MQMN KGRF VGXW TRZX WIAK LXFP " +
                        "SKAU TEMN DCMG TSXM XBTU IADN GMGP SREL XNJE LXVR VPRT " +
                        "ULHD NQWT WDTY GBPH XTFA LJHA SVBF XNGL LCHR ZBWE LEKM " +
                        "SJIK NBHW RJGN MGJS GLXF EYPH AGNR BIEQ JTAM RVLC RREM " +
                        "NDGL XRRI MGNS NRWC HRQH AEYE VTAQ EBBI PEEW EVKA KOEW " +
                        "ADRE MXMT BHHC HRTK DNVR ZCHR CLQO HPWQ AIIW XNRM GWOI " +
                        "IFKE E";
        System.out.println("请输入m: ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println("---------------------------------------");
        String ciphertext = pretreatment(rawtext);
        System.out.println("ciphertext = " + ciphertext);
        System.out.println("ciphertext's length = " + ciphertext.length());
        System.out.println("---------------------------------------");
        mCals(m, ciphertext);
        System.out.println("---------------------------------------");
        System.out.println("重合指数应尽可能接近0.065");

    }

    /**
     * 预处理：去除字符串的空格
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
     * 对输入的m，分别做m次重合指数计算
     * @param ciphertext
     */
    public static void mCals(int m, String ciphertext) {
        for (int i = 0; i < m; i++) {
            String str = "";
            System.out.println("lc(y" + (i + 1) + ")");
            for (int j = 0; j < ciphertext.length() / m; j++) {
                str = str + ciphertext.charAt(m * j + i);
            }
            if (i < (ciphertext.length() % m)) {
                str = str + ciphertext.charAt(m * (ciphertext.length() / m) + i);
            }
            String ciphertextSegment = str;
            System.out.println("y" + (i + 1) + " : ciphertextSegment = " + str);
            calIndOfCoincidence(ciphertextSegment);
        }
    }

    /**
     * 计算重合指数
     *
     * @param ciphertext
     */
    public static void calIndOfCoincidence(String ciphertext) {
        Map<Character, Integer> map = statAlpha(ciphertext);
        double sum = 0;
        for (Character key : map.keySet()) {
            int f = map.get(key);
            sum = sum + map.get(key) * (map.get(key) - 1);
        }
        System.out.println("Σfi(fi - 1) = " + sum);
        int count = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            if (ciphertext.charAt(i) != ' ') {
                count++;
            }
        }
        double n = count * (count - 1);
        System.out.println("n(n - 1) = " + n);
        double lc = sum / n;
        System.out.println("重合指数 = " + lc);
        System.out.println("---------------------------------------");
    }

    /**
     * 统计字母频数
     *
     * @param cipherText
     * @return
     */
    public static Map<Character, Integer> statAlpha(String cipherText) {
        Map<Character, Integer> alphaStat = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            char alpha = (char) ('A' + i);
            alphaStat.put(alpha, 0);
        }
        System.out.println("初始状态：" + alphaStat);
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch != ' ') {
                alphaStat.put(ch, alphaStat.get(ch) + 1);
            }
        }
        System.out.println("统计后：" + alphaStat);
        return alphaStat;

    }
}
