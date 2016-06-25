package io.printstream;

import java.io.*;
/**
功能：利用PrintStream直接往文件中打印数据。
*/
public class TestPrintStream{
	public static void main(String[] args){
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("src/io/printstream/TestPrintStream.txt");
			ps = new PrintStream(fos);//默认autoFlush=false
			ps.println("中华人民共和国");
			ps.println("Hello,China!");
			int a = 256;
			ps.printf("a=%d,%10d,%o,%x\n", a,a,a,a);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
}