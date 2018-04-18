package com.IOSplit;

import java.io.UnsupportedEncodingException;

/**
 * @author ssh
 * Email: shenshanghua@wanhuchina.com
 * Date:  2018/4/18
 * Time:  10:57
 */
public class EncoderUtils {

    //0x00-0xFF（2号至18号相加）高8位。
    public static byte[] getCheckSum(byte[] data) {
        byte[] checkSum = new byte[]{0x00, 0x00, 0x00};
        int sum = 0;
        for (byte aData : data) {
            if (aData >= 0) {
                sum += aData;
            } else {
                sum += 256 + aData;
            }
        }
        String sumHex = Integer.toHexString(sum);
        if (sumHex.length() <= 2) {
            checkSum[0] = 0x00;
            checkSum[1] = 0x00;
            checkSum[2] = StringUtils.StringHaxtoByte(sumHex);

        } else if (sumHex.length() <= 4) {
            checkSum[0] = 0x00;
            String mid = sumHex.length() == 3 ? sumHex.substring(0, 1) : sumHex.substring(0, 2);
            checkSum[1] = StringUtils.StringHaxtoByte(mid);
            String low = sumHex.substring(sumHex.length() - 2, sumHex.length());
            checkSum[2] = StringUtils.StringHaxtoByte(low);
        } else {

            String high = sumHex.length() == 5 ? sumHex.substring(0, 1) : sumHex.substring(sumHex.length() - 6, 4);
            checkSum[0] = StringUtils.StringHaxtoByte(high);
            String mid = sumHex.substring(sumHex.length() - 4, sumHex.length() - 2);
            checkSum[1] = StringUtils.StringHaxtoByte(mid);
            String low = sumHex.substring(sumHex.length() - 2, sumHex.length());
            checkSum[2] = StringUtils.StringHaxtoByte(low);
        }
        return checkSum;

    }


    //以下都是工具类####################################################################################/**

    /**
     * String 转  encod ,encod 不是定  （GBK,UTF-8,ASCII,等）
     *
     * @param s
     * @param encod
     * @return String
     */
    public static String StringToHexString(String s, String encod) {
        String result = "";
        try {
            byte[] b = s.getBytes(encod);
            result = StringToASCII.bytes2HexString(b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param hz
     * @param encod
     * @return
     */
    public static byte[] HanZiToHexBytes(String hz, String encod) {

        byte[] bytes = null;
        try {
            bytes = hz.getBytes(encod);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }


    }

    /**
     * @param s
     * @return
     */
    public static byte StringHaxtoByte(String s) {
        int valueOf = Integer.parseInt(s, 16);
        return (byte) valueOf;
    }

    /**
     * @param b
     * @return
     */
    public static String ByteToTwo(byte b) {
        String binary = Integer.toBinaryString(b);
        int i = Integer.parseInt(binary, 2);
        return String.valueOf(i);
    }

    /**
     * @param str
     * @return
     */
    public static String PadLeftRight(String str) {
        if (str.length() <= 8) {
            if (str.length() == 8) {
                return str;
            } else {
                int i = str.length();
                StringBuilder strBuilder = new StringBuilder(str);
                while (i < 8) {
                    strBuilder.append("0");
                    i++;
                }
                str = strBuilder.toString();
                return str;
            }

        } else {
            return str;
        }

    }

    //String hax to int
    public static byte[] HaxSreingToint(String str) {
        String[] split = str.split(" ");
        byte[] d = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            String string = split[i];
            int parseInt = Integer.parseInt(string, 16);
            d[i] = (byte) parseInt;
        }
        return d;

    }

    //字符串转换为ASCII码
    public static byte[] string2ASCII(String s) {// 字符串转换为ASCII码
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


    //####################################################################################


    /**
     * wsz
     * <p>
     * 供外部调用的主方  showIntArray
     *
     * @return int[]
     */

    public static byte[] showIntArray(String str) {
        return string2ASCII(str);
    }


    /**
     * wsz
     * char   byte
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
//	public static void showIntArray(byte[] intArray) {
//		showIntArray(intArray, ",");
//	}

    /**
     * ASCIIs  String
     *
     * @param ASCIIs
     * @return
     */
    public static String ascii2String(byte[] ASCIIs) {
        StringBuilder sb = new StringBuilder();
        for (byte ASCII : ASCIIs) {
            sb.append(ascii2Char(ASCII));
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
     * 字节数组转化为16进制字符穿
     */
    public static String bytes2HexString(byte[] b) {
        StringBuilder r = new StringBuilder();
        for (byte aB : b) {
            String hex = Integer.toHexString(aB & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r.append(hex.toUpperCase()).append(" ");
        }
        return r.toString();
    }
}
