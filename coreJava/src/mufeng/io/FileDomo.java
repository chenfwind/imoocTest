package mufeng.io;

import java.io.File;
import java.io.IOException;

public class FileDomo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file1 = new File("F:\\Desktop data\\myeclipse\\coreJava\\src\\Domo");
		System.out.println(file1.exists());      //判断这个路径是否存在
		System.out.println(file1.isDirectory()); //判断是否是目录
		System.out.println(file1.isFile());      //判断是否是文件
		System.out.println(file1.isAbsolute());
		if(!file1.exists()){
			file1.mkdir();//创建这个目录
		}else{
			file1.delete();//删除这个目录
		}
//		File file2 = new File("F:\\Desktop data\\myeclipse\\coreJava\\src\\Domo.txt"); 
		File file2 = new File("F:\\Desktop data\\myeclipse\\coreJava\\src","Domo.txt"); 
		if(!file2.exists()){
			file2.createNewFile();
		}else{
			file2.delete();
		}
		
		/*
		 * 常用的file api
		 * 
		 * */
		System.out.println(file1);
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getParent());
		System.out.println(file1.getParentFile().getAbsolutePath());
	}

}
