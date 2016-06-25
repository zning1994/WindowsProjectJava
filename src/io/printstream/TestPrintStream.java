package io.printstream;

import java.io.*;
/**
���ܣ�����PrintStreamֱ�����ļ��д�ӡ���ݡ�
*/
public class TestPrintStream{
	public static void main(String[] args){
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("src/io/printstream/TestPrintStream.txt");
			ps = new PrintStream(fos);//Ĭ��autoFlush=false
			ps.println("�л����񹲺͹�");
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