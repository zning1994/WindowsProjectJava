package io.transform;
/*
���ܣ��ֱ�������WINDOWSĬ�ϵ�GBK��ISO8859_1������ʽ���ļ���д���ַ�����
 */
import java.io.*;

public class TestTransForm1 {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/io/transform/transform1.txt"));
			osw.write("��ϢѧԺ");
			osw.write("SUN Java");
			System.out.println(osw.getEncoding());// ����xpĬ�ϱ���ΪGBK
			osw.close();

			//FileOutputStream���췽���ڶ��������ĺ��壺�Ƿ�׷��
			osw = new OutputStreamWriter(new FileOutputStream("src/io/transform/transform2.txt"), "utf-8"); // latin-1
			osw.write("ɽ���Ƽ���ѧ");
			osw.write("C#");
			System.out.println(osw.getEncoding());
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}