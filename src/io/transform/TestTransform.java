package io.transform;
import java.io.*;

/**
 * 对8.4.1中TestFileInputStream的修改，可以读取中文字符。
 */
public class TestTransform {
	public static void main(String[] args) {
		int b = 0;
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(
					"src/io/transform/TestTransform.java"));
			long num = 0;
			while ((b = isr.read()) != -1) {
				System.out.print((char) b);
				num++;
			}
			System.out.println("共读取了 " + num + "个字符"); 
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e1) {
			System.out.println("文件读取错误");
		} finally{
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(-1);
		}
	}

}
