package mufeng.io;

import java.io.UnsupportedEncodingException;

public class EncodeDomo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = "沐风ABC";
		/*
		 * 系统默认编码方式为GBK,中文是两个字节，英文是一个字节
		 * */
		byte[] bytes1 = s.getBytes();
		for(byte b : bytes1){
			//把字节转换成int，以16进制形式输出
			System.out.print(Integer.toHexString(b & 0xff) +" ");
		}
		
		System.out.println();
		/*
		 * 把编码方式弄成utf-8，中文是三个字节，因为是一个字节
		 * */
		byte[] bytes2 = s.getBytes("utf-8");
		for(byte b : bytes2){
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		// java是双字节编码方式，编码方式为utf-16be,中文占两个字节，英文占两个字节	
		byte[] bytes3 = s.getBytes("utf-16be");
		for(byte b : bytes3){
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		/*
		 * 当你的字节序列式某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会乱码
		 * */
		String str1 = new String(bytes2);
		System.out.println(str1);
		String str2 = new String(bytes2,"utf-8");
		System.out.println(str2);
	
	}

}
