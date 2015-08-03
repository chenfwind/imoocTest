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
		System.out.println(file1.exists());      //�ж����·���Ƿ����
		System.out.println(file1.isDirectory()); //�ж��Ƿ���Ŀ¼
		System.out.println(file1.isFile());      //�ж��Ƿ����ļ�
		System.out.println(file1.isAbsolute());
		if(!file1.exists()){
			file1.mkdir();//�������Ŀ¼
		}else{
			file1.delete();//ɾ�����Ŀ¼
		}
//		File file2 = new File("F:\\Desktop data\\myeclipse\\coreJava\\src\\Domo.txt"); 
		File file2 = new File("F:\\Desktop data\\myeclipse\\coreJava\\src","Domo.txt"); 
		if(!file2.exists()){
			file2.createNewFile();
		}else{
			file2.delete();
		}
		
		/*
		 * ���õ�file api
		 * 
		 * */
		System.out.println(file1);
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getParent());
		System.out.println(file1.getParentFile().getAbsolutePath());
	}

}
