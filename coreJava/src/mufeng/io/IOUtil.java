package mufeng.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class IOUtil {
	
	/**
	 * @param filename
	 * ��ȡ�ƶ��ļ����ݣ�����16�������������̨
	 * ����ÿ���10��byte����
	 * ���ֽڶ�ȡ���ʺϴ��ļ���Ч�ʱȽϵ�
	 */
	public static void printHex(String fileName)throws IOException{
		//���ļ���Ϊ�ֽ������в���
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = in.read())!=-1){
			//������bת��Ϊ16���Ʊ�ʾ���ַ���
			if(b <= 0xf){
				//��λ��ǰ�油��
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
			if(i++%10==0){
				System.out.println();
			}
		}
		in.close();
	}
	/*������ȡ���Դ��ļ�����Ч�ʸߣ�Ҳ����������Ķ�ȡ�ļ��ķ���
	 * 
	 * */
	public static void printHexByByteArray(String fileName)throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[8 * 1024];
		/*��in��������ȡ�ֽڣ����뵽buf����ֽ�������
		 * �ӵ�0��λ�ÿ�ʼ�ţ�����buf.length��
		 * ���ص��Ƕ������ֽڵĸ���
		 * */
//		int bytes = in.read(buf,0,buf.length);//һ���Զ��꣬˵���ֽ������㹻��
//		int j=1;
//		for(int i = 0; i < bytes ; i ++){
//			if(buf[i] <= 0xf ){
//				System.out.print(0);
//			}
//			System.out.print(Integer.toHexString(buf[i])+" ");
//			if(j++%10==0){
//				System.out.println();
//			}
//		}
		
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf,0,buf.length)) != -1){
			for(int i = 0 ; i < bytes ; i++ ){
				if(buf[i] <= 0xf ){
					System.out.print(0);
				}
				/*
				 * & 0xff
				 * byte����8λ��int����32λ
				 * Ϊ�˱�������ת������ͨ��& 0xff����24λ����
				 * */
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if(j++%10 == 0){
					System.out.println();
				}
			}
		}
		in.close();
	}
	
	public static void copyFile(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException(destFile+"�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8 * 1024];
		int bytes = 0;
		while((bytes = in.read(buf , 0 , buf.length))!= -1){
				out.write(buf,0,bytes);
				out.flush();
		}
		out.close();
		in.close();
	}

	/*
	 * �ļ�
	 */
	public static void copyFileByBuffer(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException(destFile+"�����ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int b;
		while((b = bis.read())!=-1){
			bos.write(b);
			bos.flush();
		}
		bis.close();
		bos.close();
	}
	/*
	 * ���ֽڣ�������������ļ�����
	 */
	public static void copyFileByByte(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException(destFile+"�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int b;
		while((b = in.read()) != -1){
			out.write(b);
			out.flush();
		}
		in.close();
		out.close();
	}
	
	
	
	
	
	
	
	
	
}
