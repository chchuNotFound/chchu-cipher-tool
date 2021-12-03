package 移位密码解密;

public class Solution {

    public static void main(String[] args) {
        shiftCipherDecoder(
                "AOPC GUDE YKRO IFKG BEFM CPIY CRAR DEPB " +
                "AQUF EPGH KJPK DDCJ GKPJ IEVC GEBE BAYC " +
                "FAMC XCER IARE HAFF ERJG HCRA OKBB KYAR " +
                "RCED KFAI GHCP CDCK DFCB KKME FEMC GKXC " +
                "OKRQ KYYE BKYC ERBH CCRJ KVEI BKPS AQKU " +
                "FJRK BIDC EMEG HKFC ICRB CRQC ARQK YDER " +
                "SERJ GEIQ KRIA JCPC JRKB BKKX PAOH B");
    }

    public static void shiftCipherDecoder(String cipherText) {
        for(int i = 0; i < 26; i++) {
            System.out.print("K = " + (26 - i) + ": " + "plainText = ");
            for(int j = 0; j < cipherText.length(); j++) {
                char ch = cipherText.charAt(j);
                if(ch == ' ') {
                    continue;
                }
                int index = ch - 'A';
                int newIndex = (index + i) % 26;
                char newChar = (char) (newIndex + 'A');
                System.out.print(newChar);
            }
            System.out.println("");
        }

    }

}
