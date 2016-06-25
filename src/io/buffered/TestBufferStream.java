package io.buffered;

import java.io.*;
/**
功能：使用BufferedInputStream从文件HelloWorld.java中读取字节。
问题：仍然不能显示中文，因为是以字节流的形式读取数据。
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