package mufeng.io;

import java.io.File;
import java.io.IOException;

/*
 * �г�File��һЩ���ò���������ˣ������Ȳ���
 * */

public class FileUtils {

	/**
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir)throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Ŀ¼"+dir+"������");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"����Ŀ¼");
		}
		
//		String[] filename = dir.list();//�����ַ������飬ֱ���ӵ����ƣ���������Ŀ¼�µ�����
//		for (String string : filename) {
//			System.out.println(string);
//		}
		//���Ҫ����Ŀ¼�µ����ݾ���Ҫ�����file�������ݹ������file�ṩ��ֱ�ӷ���file����Ŀ¼
		File[] files = dir.listFiles();//���ص���ֱ�ӵ���Ŀ¼���ļ����ĳ���
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
