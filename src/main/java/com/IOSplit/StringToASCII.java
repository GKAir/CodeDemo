package com.IOSplit;

import java.io.IOException;

public class StringToASCII {
    /**
     * wsz
     * <p>
     * 供外部调用的主方   showIntArray
     *
     * @return int[]
     */

    public static byte[] showIntArray(String str) {
        byte[] intArray = string2ASCII(str);
        return intArray;
    }

    /**
     * String    ASCII
     *
     * @param s
     * @return
     */
    public static byte[] string2ASCII(String s) {// 字符串转换为ASCII  
        if (s == null || "".equals(s)) {
            return null;
        }
        char[] chars = s.toCharArray();
        byte[] asciiArray = new byte[chars.length];

        for (int i = 0; i < chars.length; i++) {
            asciiArray[i] = char2ASCII(chars[i]);
        }
        return asciiArray;
    }

    /**
     * wsz
     * char    byte
     *
     * @param c
     * @return byte
     */
    public static byte char2ASCII(char c) {
        return (byte) c;
    }
    /**
     * wsz
     * @param intArray
     */

    /**
     * ASCIIs   String
     *
     * @param ASCIIs
     * @return
     */
    public static String ascii2String(byte[] ASCIIs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ASCIIs.length; i++) {
            sb.append((char) ascii2Char(ASCIIs[i]));
        }
        return sb.toString();
    }

    /**
     * @param ASCII
     * @return
     */
    public static char ascii2Char(int ASCII) {
        return (char) ASCII;
    }


    /**
     * 字节数组  6进制字符
     */
    public static String bytes2HexString(byte[] b) {
        String r = "";
        byte[] data = new byte[b.length];
        for (int i = 0; i < b.length; i++) {

            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase() + " ";
        }

        return r;
    }

    /**
     * 测试
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int a = 123;
        byte b = 0x00;
        b = (byte) a;
        System.out.println(b);
    }
}
