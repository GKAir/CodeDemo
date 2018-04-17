package com.IOSplit;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            byte[] t = new byte[size];
            int index = length - (i + 1) * size > 0 ? size : length - i * size;
            System.arraycopy(data, size * i, t, 0, index);
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
        return out.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        InputStream2ByteArray("C:\\Users\\froid\\Desktop\\splitDemo\\WHC-BLUE-20171001001语音-远程升级.bin", 1024);
    }
}
