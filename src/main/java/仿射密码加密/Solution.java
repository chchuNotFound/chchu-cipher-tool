package 仿射密码加密;

public class Solution {

    public static void main(String[] args) {
        // a和b的求法，详情见笔记
        affineCipherEncoder(
                "AOPC GUDE YKRO IFKG BEFM CPIY CRAR DEPB " +
                        "AQUF EPGH KJPK DDCJ GKPJ IEVC GEBE BAYC " +
                        "FAMC XCER IARE HAFF ERJG HCRA OKBB KYAR " +
                        "RCED KFAI GHCP CDCK DFCB KKME FEMC GKXC " +
                        "OKRQ KYYE BKYC ERBH CCRJ KVEI BKPS AQKU " +
                        "FJRK BIDC EMEG HKFC ICRB CRQC ARQK YDER " +
                        "SERJ GEIQ KRIA JCPC JRKB BKKX PAOH B"
                , 11, 8
        );
    }

    public static void affineCipherEncoder(String plainText, int a, int b) {
        System.out.print("解 : ");
        for(int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if(ch == ' ') {
                continue;
            }
            int index = ch - 'A';
            int newInd = (index * a + b) % 26;
            char newChar = (char) (newInd + 'A');
            System.out.print(newChar);
        }

    }

}
