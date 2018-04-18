package com.IOSplit;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author zhangweizhou
 * Email: zhangweizhou@wanhuchina.com
 * Date:  2018/4/17
 * Time:  10:34
 */
public class IOSplit {
    private static List<byte[]> InputStream2ByteArray(String filePath, int size) throws IOException {
        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        int length = data.length;
        int number = length / size;
        //分割后文件的数目
        number = length % size == 0 ? number : number + 1;
        List<byte[]> byteList = new ArrayList<byte[]>();
        for (int i = 0; i < number; i++) {
            byte[] t = new byte[size + 3];
            int index = length - (i + 1) * size > 0 ? size : length - i * size;
            System.arraycopy(data, size * i, t, 0, index);
            byte[] sum = EncoderUtils.getCheckSum(t);
            System.arraycopy(sum, 0, t, size, 3);
            byteList.add(t);
        }
        in.close();
        return byteList;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];

        int n;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        int a = 0;
        for (byte b : out.toByteArray()
                ) {
            a += b;
        }
        return out.toByteArray();
    }

    private static String byte2HexStr(byte[] b) {
        String stmp;
        StringBuilder sb = new StringBuilder();
        for (byte aB : b) {
            stmp = Integer.toHexString(aB & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            sb.append(" ");
        }
        return sb.toString().toUpperCase(Locale.ENGLISH).trim();
    }

    public static void main(String[] args) throws IOException {
        List<byte[]> list = InputStream2ByteArray("C:\\Users\\froid\\Desktop\\splitDemo\\WHC-BLUE-20171001001语音-远程升级.bin", 61);
        for (byte[] b : list
                ) {
            String s = byte2HexStr(b);
            System.out.println(Arrays.toString(b));
            System.out.println(s);
            System.out.println(b.length);
        }
    }
}
