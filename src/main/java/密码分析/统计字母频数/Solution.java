package 密码分析.统计字母频数;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
//        statAlpha(
//                "LWSZ GUPG IVOW EGKV QIKN KUSW UMOQ ZKMM FLVO RWUO QKOO QZKS YZGM" +
//                        "KGIQ KMKY KRTK NTZR UURO ZPWL VFOR UEGZ MWFG PZMK USKM MFLZ MRUM" +
//                        "OZKS OQKO OQZK SYZG MKGI MPWL VFOK ORWU RMGZ MWFG PZNW FUSZ SRUM" +
//                        "WLZG ZKMW UKNT ZAKI RUVK GORP FTKG RUOQ ZMZU WOZM AZAR TTKM MFLZ" +
//                        "OQKO OQZK SYZG MKGI RMKV GWNK NRTR MORP KTEW GROQ LAQW GFUM RUVW" +
//                        "TIUW LRKT ORLZ MRLR TKGT IOQZ ZUPG IVOR WUKU SSZP GIVO RWUK TEWG ROQL" +
//                        "MSZM REUZ SKGZ VGWN KNRT RMOR PKUS GFUR UVWT IUWL RKTO RLZO QZGF UURU" +
//                        "EORL ZWCO QZZU PGIV ORWU SZPG IVOR WUKU SOQZ KSYZ GMKG IKTE WGRO QLMK" +
//                        "GZKT TLZK MFGZ SKMK CFUP ORWUWCKM ZPFG ROIV KGKL ZOZG AQRP QRMK VKGK" +
//                        "LZOZ GAQR PQRM DZSK OOQZ ORLZ OQZP GIVO WMIM OZLR MMZO FVOQ FMAQ ZUAZ" +
//                        "MKIO QKOO QZKS YZGM KGIK TEWG ROQL GFUM RUVW TIUW LRKT ORLZ AZLZ KUOR" +
//                        "LZNW FUSZ SNIM WLZV WTIU WLRK TCFU PORW U"
//        );
        statAlpha("AOPC GUDE YKRO IFKG BEFM CPIY CRAR DEPB" +
                "AQUF EPGH KJPK DDCJ GKPJ IEVC GEBE BAYC" +
                "FAMC XCER IARE HAFF ERJG HCRA OKBB KYAR" +
                "RCED KFAI GHCP CDCK DFCB KKME FEMC GKXC" +
                "OKRQ KYYE BKYC ERBH CCRJ KVEI BKPS AQKU" +
                "FJRK BIDC EMEG HKFC ICRB CRQC ARQK YDER" +
                "SERJ GEIQ KRIA JCPC JRKB BKKX PAOH B");
    }

    public static void statAlpha(String cipherText) {
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

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(alphaStat.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.print("排序后：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getKey() + "=" + list.get(i).getValue());
            if (i != list.size() - 1) {
                System.out.print(", ");
            }

        }


    }

}
