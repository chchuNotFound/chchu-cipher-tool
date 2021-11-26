package 移位密码解密;

public class Solution {

    public static void main(String[] args) {
        shiftCipherCracker("ESPESTCOPIPCNTDPYPPODACZRCLXXTYR");
    }

    public static void shiftCipherCracker(String cipherText) {
        for(int i = 0; i < 26; i++) {
            System.out.print("K = " + i + ": " + "plainText = ");
            for(int j = 0; j < cipherText.length(); j++) {
                char ch = cipherText.charAt(j);
                int index = ch - 'A';
                int newIndex = (index + i) % 26;
                char newChar = (char) (newIndex + 'A');
                System.out.print(newChar);
            }
            System.out.println("");
        }

    }

}
