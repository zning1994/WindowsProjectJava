package io.transform;
/*
功能：分别以中文WINDOWS默认的GBK和ISO8859_1编码形式往文件中写入字符串。
 */
import java.io.*;

public class TestTransForm1 {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/io/transform/transform1.txt"));
			osw.write("信息学院");
			osw.write("SUN Java");
			System.out.println(osw.getEncoding());// 中文xp默认编码为GBK
			osw.close();

			//FileOutputStream构造方法第二个参数的含义：是否追加
			osw = new OutputStreamWriter(new FileOutputStream("src/io/transform/transform2.txt"), "utf-8"); // latin-1
			osw.write("山东科技大学");
			osw.write("C#");
			System.out.println(osw.getEncoding());
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}