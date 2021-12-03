package 密码分析.重合指数计算;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String ciphertext = "FSHF PMGH TFVM AZPP ZYUB MMGZ SOVI NFUM" +
                "KCZM ZSOM GZVN FFWK IVAH YZAZ SOGF KTUY" +
                "GTIM GHTI MZYI BNIY WOCF USAM FZSY BUAH" +
                "YCDL MFOC ILGD ZVIN CFIA VUNQ HYMI SAZM" +
                "CHRU ZCHV WSFK BHAO HFPV HEHC IBIC HIVF" +
                "PTIM GHTI MZYV ZSYB UAZS OSUT NHCM GHFC" +
                "DOCF ULVC ZSOV ISAP ZHBA VBZS HICI BOHN" +
                "CILC FNIN ZBZM DISA ZSPF CTIM ZFSM GHFC";
        calIndOfCoincidence(ciphertext);
    }

    /**
     * 计算重合指数
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
        for(int i = 0; i < ciphertext.length(); i++) {
            if(ciphertext.charAt(i) != ' ') {
                count++;
            }
        }
        double n = count * (count - 1);
        System.out.println("n(n - 1) = " + n);
        double lc = sum / n;
        System.out.println("重合指数lc(X) = " + lc );
    }

    /**
     * 统计字母频数
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
