package com.IOSplit;

import java.io.UnsupportedEncodingException;


public class StringUtils {
	/**
	 * String 转  encod ,encod 不是定�? （GBK,UTF-8,ASCII,等）
	 * @param s
	 * @param encod
	 * @return String
	 */
	 public static String StringToHexString(String s, String encod){
	    String result = "";
		try {
			byte[] b=s.getBytes(encod);
			
			result = StringToASCII.bytes2HexString(b);
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return result;
     }
	 /**
	  * 
	  * @param hz
	  * @param encod
	  * @return
	  */
	 public static byte[] HanZiToHexBytes(String hz, String encod){
         
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
     * 
     * @param s
     * @return
     */
	 public static byte StringHaxtoByte(String s){
		 
		 int valueOf = Integer.parseInt(s, 16);
		 
		 byte toHexbyte = (byte)valueOf;
		 return toHexbyte;
	 }
	 /**
	  * 
	  * @param b
	  * @return
	  */
	 public static String ByteToTwo(byte b){
		  String binary=Integer.toBinaryString(b);//ת��Ϊ2�����ַ�
		  int i=Integer.parseInt(binary, 2);//�������ƴ�תΪ����
		  return String.valueOf(i);
	 }
	 /**
	  * 
	  * @param str
	  * @return
	  */
	 public static String PadLeftRight(String str){
		 if(str.length() <= 8){
			 if(str.length()==8){
				 return str;
			 }else{
				 int i=str.length();
				 while (i<8) {
					str=str+"0";
					i++;
				}
				 return str; 
			 }
			 
		 }else{
			 return str;
		 }
		
	 }
	 //String hax to int
	    public static byte[] HaxSreingToint(String str){
	    	 String[] split = str.split(" ");
			 byte[] d = new byte[split.length];
			 for(int i=0;i<split.length;i++){
				 String string = split[i];
				 int parseInt = Integer.parseInt(string, 16);
				 d[i] = (byte)parseInt;
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
	    public static byte char2ASCII(char c) {
			return (byte) c;
		}
	    
	    /**
	     * 针对存入redis的门锁信息工具类
	     * auth:wsz
	     * */
	    public static String LockInfor(String OldLockInfor,String newLockInfor){
	    	//System.out.println("OldLockInfor:"+OldLockInfor);
	    	//System.out.println("newLockInfor:"+newLockInfor);
	    	String[] OldLockInfors = OldLockInfor.split("-");
	    	String[] newLockInfors = newLockInfor.split("-");
	    	String state = "";
	    	for(int i = 0;i<OldLockInfors.length;i++){
	    		String Oldstate = "";
		    	String Newstate = "";
	    		String OldLInfor = OldLockInfors[i];
	    		String NewLInfor = newLockInfors[i];
	    		//System.out.println("OldLInfor:"+OldLInfor+"    NewLInfor:"+NewLInfor);
	    		String[] OldLInfors = OldLInfor.split(" ");
	    		String[] NewLInfors = NewLInfor.split(" ");
	    		//System.out.println("OldLInfors[0]:"+OldLInfors[0]+"    NewLInfors[0]:"+NewLInfors[0]);
	    		if(OldLInfors[0].equals(NewLInfors[0])){
	    			Oldstate = Oldstate+OldLInfors[1].charAt(0);
	    			Newstate = Newstate+NewLInfors[1].charAt(0);
	    			//System.out.println("Oldstate:"+Oldstate+"    Newstate:"+Newstate);
	    			if(!Oldstate.equals(Newstate)){
	    				state = state+NewLInfor+"-";
	    			}else if(Oldstate.equals(Newstate)){
	    				state = state+OldLInfor+"-";
	    			}
	    		}
	    	}
	    	System.out.println("state:"+state);
	    	return state;
	    }
}
