package mufeng.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String file = "Demo/dos.dat";
		DataOutputStream dos = new DataOutputStream(new 
				FileOutputStream(file));
		dos.writeInt(10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//����utf-8����д��
		dos.writeUTF("�й�");
		//����utf-16e��д����
		dos.writeChars("�й�");
		
		IOUtil.printHex(file);
	}

}
