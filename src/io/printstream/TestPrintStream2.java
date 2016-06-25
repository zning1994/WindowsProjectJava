package io.printstream;

import java.io.*;
/*
���ܣ����ļ�TestPrintStream2.txt�е����ݶ�����������ӡ������̨��
˵��������������ϰʹ��System.out
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
			ps.println("�޷���ȡ�ļ�");
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}