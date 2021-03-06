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
	 * 读取制定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 * 单字节读取不适合大文件，效率比较低
	 */
	public static void printHex(String fileName)throws IOException{
		//把文件作为字节流进行操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = in.read())!=-1){
			//将整型b转换为16进制表示的字符串
			if(b <= 0xf){
				//单位数前面补零
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
			if(i++%10==0){
				System.out.println();
			}
		}
		in.close();
	}
	/*批量读取，对大文件而言效率高，也是我们最常见的读取文件的方法
	 * 
	 * */
	public static void printHexByByteArray(String fileName)throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[8 * 1024];
		/*从in中批量读取字节，放入到buf这个字节数组中
		 * 从第0个位置开始放，最多放buf.length个
		 * 返回的是读到的字节的个数
		 * */
//		int bytes = in.read(buf,0,buf.length);//一次性读完，说明字节数组足够大
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
				 * byte类型8位，int类型32位
				 * 为了避免数据转换错误，通过& 0xff将高24位清零
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
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException(destFile+"不是文件");
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
	 * 文件
	 */
	public static void copyFileByBuffer(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException(destFile+"不是文件");
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
	 * 单字节，不带缓冲进行文件拷贝
	 */
	public static void copyFileByByte(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException(destFile+"不是文件");
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
