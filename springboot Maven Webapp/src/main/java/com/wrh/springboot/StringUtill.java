package com.wrh.springboot;

public class StringUtill {
    public static String toStringHex(String s) {
        s = s.replace(" ","");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(toStringHex("00 1C 63 6F 6D 2F 77 72 68 2F 73 70 72 69 6E 67 62 6F 6F 74 2F 44 65 6D 6F 43 6C 61 73 73"));
    }
}
