package io.buffered;

import java.io.*;
/**
���ܣ�ʹ��BufferedInputStream���ļ�HelloWorld.java�ж�ȡ�ֽڡ�
���⣺��Ȼ������ʾ���ģ���Ϊ�����ֽ�������ʽ��ȡ���ݡ�
*/
public class TestBufferStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/io/buffered/TestBufferStream.java");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			for (int i = 0; (c = bis.read()) != -1; i++) {
				System.out.print((char) c);
			}
			bis.close();
//			fis.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}