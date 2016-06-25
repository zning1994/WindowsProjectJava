package io.buffered;

import java.io.*;
/*
功能：往test.txt中写入100行字符，然后从test.txt读出写入的数据，并打印到控制台。
*/
public class TestBufferReaderWriter {
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("./src/io/buffered/test.txt"));
			String s = null;
			for (int i = 1; i <= 100; i++) {
				s = String.valueOf(i);
				bw.write(s);
				bw.newLine();
			}
			bw.flush();// 写入到文件

			BufferedReader br = new BufferedReader(new FileReader("./src/io/buffered/test.txt"));
			while ((s = br.readLine()) != null) {// readLIine()：常用方法
				System.out.println(s);
			}
			
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}