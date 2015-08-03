package mufeng.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		/*
		 * 如果文件不存在，则直接创建，如果存在，则删除后创建
		 * */
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		out.write('A');//写出了A的低八位
		out.write('B');//写出B了的低八位
		int a = 10;//write只能写出8位，那么写入一个int需要写入四次
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		
		IOUtil.printHex("demo/out.dat");
	}

}
