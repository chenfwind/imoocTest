package mufeng.io;

import java.io.UnsupportedEncodingException;

public class EncodeDomo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = "���ABC";
		/*
		 * ϵͳĬ�ϱ��뷽ʽΪGBK,�����������ֽڣ�Ӣ����һ���ֽ�
		 * */
		byte[] bytes1 = s.getBytes();
		for(byte b : bytes1){
			//���ֽ�ת����int����16������ʽ���
			System.out.print(Integer.toHexString(b & 0xff) +" ");
		}
		
		System.out.println();
		/*
		 * �ѱ��뷽ʽŪ��utf-8�������������ֽڣ���Ϊ��һ���ֽ�
		 * */
		byte[] bytes2 = s.getBytes("utf-8");
		for(byte b : bytes2){
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		// java��˫�ֽڱ��뷽ʽ�����뷽ʽΪutf-16be,����ռ�����ֽڣ�Ӣ��ռ�����ֽ�	
		byte[] bytes3 = s.getBytes("utf-16be");
		for(byte b : bytes3){
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		/*
		 * ������ֽ�����ʽĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ�����Ҳ��Ҫ�����ֱ��뷽ʽ�����������
		 * */
		String str1 = new String(bytes2);
		System.out.println(str1);
		String str2 = new String(bytes2,"utf-8");
		System.out.println(str2);
	
	}

}
