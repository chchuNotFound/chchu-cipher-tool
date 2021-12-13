package 维吉尼亚密码加密;

public class Solution {

    public static void main(String[] args) {

        vigenereCipherEncoder("WEAREDISCOVEREDSAVEYOURSELF", "FRIDAY");

    }

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

}
