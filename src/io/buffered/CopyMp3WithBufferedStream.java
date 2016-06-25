package io.buffered;

import java.io.*;

/**
 ���ܣ���һ��mp3�ļ���������һ��mp3�ļ���
 */
public class CopyMp3WithBufferedStream {
	public static void main(String[] args) {
		int b = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("src/io/processingStream/���޵��ǿ�����.mp3"),
					1024 * 512);
			bos = new BufferedOutputStream(new FileOutputStream("src/io/processingStream/mysong.mp3"),
					1024 * 512);

			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			System.out.println("mp3�ļ��Ѹ���");

		} catch (FileNotFoundException e2) {
			System.out.println("�Ҳ���ָ���ļ�");
		} catch (IOException e1) {
			System.out.println("�ļ����ƴ���");
		} finally {
			try {
				bis.close();
				bos.close();
				System.exit(-1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
