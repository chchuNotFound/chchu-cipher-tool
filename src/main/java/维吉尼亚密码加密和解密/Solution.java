package 维吉尼亚密码加密和解密;

import static java.lang.Math.floorMod;

public class Solution {

    public static void main(String[] args) {

//        vigenereCipherEncoder("WEAREDISCOVEREDSAVEYOURSELF", "FRIDAY");
        String cipherText =
                        "KCCPKBGUFDPHQTYAVINRRTMVGRKDNBVFDETDGILTXRGUD" +
                        "DKOTFMBPVGEGLTGCKQRACQCWDNAWCRXIZAKFTLEWRPTYC" +
                        "QKYVXCHKFTPONCQQRHJVAJUWETMCMSPKQDYHJVDAHCTRL" +
                        "SVSKCGCZQQDZXGSFRLSWCWSJTBHAFSIASPRJAHKJRJUMV" +
                        "GKMITZHFPDISPZLVLGWTFPLKKEBDPGCEBSHCTJRWXBAFS" +
                        "PEZQNRWXCVYCGAONWDDKACKAWBBIKFTIOVKCGGHJVLNHI" +
                        "FFSQESVYCLACNVRWBBIREPBBVFEXOSCDYGZWPFDTKFQIY" +
                        "CWHJVLNHIQIBTKHJVNPIST";
        vigenereCipherDecoder(pretreatment(cipherText), "CRYPTO");

    }
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
     * 维吉尼亚加密算法
     * @param plainText
     * @param key
     */
    public static void vigenereCipherEncoder(String plainText, String key) {
        int i = 0;
        int j = 0;
        System.out.print("cipherText : ");
        while (i < plainText.length()) {
            int chIndex = plainText.charAt(i) - 'A';
            int keyIndex = key.charAt(j) - 'A';
            int newIndex = (chIndex + keyIndex) % 26;
            char newChar = (char) ('A' + newIndex);
            System.out.print(newChar);
            i++;
            j = (j + 1) % key.length();
        }

    }

    /**
     * 维吉尼亚解密算法
     * @param cipherText
     * @param key
     */
    public static void vigenereCipherDecoder(String cipherText, String key) {
        int i = 0;
        int j = 0;
        System.out.print("plainText : ");
        while (i < cipherText.length()) {
            int chIndex = cipherText.charAt(i) - 'A';
            int keyIndex = key.charAt(j) - 'A';
            int newIndex = floorMod((chIndex - keyIndex) , 26);
            char newChar = (char) ('A' + newIndex);
            System.out.print(newChar);
            i++;
            j = (j + 1) % key.length();
        }
    }

}
