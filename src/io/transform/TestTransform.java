package io.transform;
import java.io.*;

/**
 * ��8.4.1��TestFileInputStream���޸ģ����Զ�ȡ�����ַ���
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
			System.out.println("����ȡ�� " + num + "���ַ�"); 
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ�");
		} catch (IOException e1) {
			System.out.println("�ļ���ȡ����");
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
