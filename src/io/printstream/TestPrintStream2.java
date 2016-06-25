package io.printstream;

import java.io.*;
/*
功能：将文件TestPrintStream2.txt中的内容读出来，并打印到控制台。
说明：本质上在练习使用System.out
*/
public class TestPrintStream2 {
	public static void main(String[] args) {
		PrintStream ps = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/io/printstream/TestPrintStream2.txt"));
			ps = System.out;
			String s = null;
			while ((s = br.readLine()) != null) {
				ps.println(s);
			}
		} catch (IOException e) {
			ps.println("无法读取文件");
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}