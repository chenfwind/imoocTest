package mufeng.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String file = "demo/dos.dat";
		DataInputStream dis = new DataInputStream(new 
				FileInputStream(file));
		int i = dis.readInt();
		System.out.println(i);
		long L = dis.readLong();
		System.out.println(L);
		double D = dis.readDouble();
		System.out.println(D);
		String utf_8 = dis.readUTF();
		System.out.println(utf_8);
		char utf_16 = dis.readChar();
		System.out.println(utf_16);
		dis.close();
	}

}
