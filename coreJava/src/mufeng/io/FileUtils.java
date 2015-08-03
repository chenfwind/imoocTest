package mufeng.io;

import java.io.File;
import java.io.IOException;

/*
 * 列出File的一些常用操作比如过滤，遍历等操作
 * */

public class FileUtils {

	/**
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir)throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录");
		}
		
//		String[] filename = dir.list();//返回字符串数组，直接子的名称，不包括子目录下的内容
//		for (String string : filename) {
//			System.out.println(string);
//		}
		//如果要遍历目录下的内容就需要构造成file对象做递归操作，file提供了直接返回file对象目录
		File[] files = dir.listFiles();//返回的是直接的子目录（文件）的抽象
		if(files != null && files.length >0){
			for (File file : files) {
				if(file.isDirectory()){
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}
	}

}
