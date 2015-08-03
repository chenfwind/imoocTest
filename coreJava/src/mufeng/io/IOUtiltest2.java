package mufeng.io;

import java.io.File;
import java.io.IOException;

public class IOUtiltest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IOUtil.copyFile(new File(
				"F:\\Desktop data\\myeclipse\\coreJava\\srcDemo.txt"),
				new File("F:\\Desktop data\\myeclipse\\coreJava\\copy.txt"));
	}

}
