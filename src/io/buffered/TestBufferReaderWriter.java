package io.buffered;

import java.io.*;
/*
���ܣ���test.txt��д��100���ַ���Ȼ���test.txt����д������ݣ�����ӡ������̨��
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
			bw.flush();// д�뵽�ļ�

			BufferedReader br = new BufferedReader(new FileReader("./src/io/buffered/test.txt"));
			while ((s = br.readLine()) != null) {// readLIine()�����÷���
				System.out.println(s);
			}
			
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}