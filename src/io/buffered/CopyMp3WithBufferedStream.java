package io.buffered;

import java.io.*;

/**
 功能：将一个mp3文件拷贝成另一个mp3文件。
 */
public class CopyMp3WithBufferedStream {
	public static void main(String[] args) {
		int b = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("src/io/processingStream/克罗地亚狂想曲.mp3"),
					1024 * 512);
			bos = new BufferedOutputStream(new FileOutputStream("src/io/processingStream/mysong.mp3"),
					1024 * 512);

			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			System.out.println("mp3文件已复制");

		} catch (FileNotFoundException e2) {
			System.out.println("找不到指定文件");
		} catch (IOException e1) {
			System.out.println("文件复制错误");
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
