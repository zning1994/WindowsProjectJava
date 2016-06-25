package io.transform;
import java.io.*;

/*
 ���ܣ��õ��Ӽ���������ַ�������ӡ������̨��
 ˵����BufferedReader��һ�ֹ�������ʹ�÷�����
 */
public class TestTransForm2 {
	public static void main(String args[]) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
		    System.out.print("Input��");
			s = br.readLine();// ����ʽ������ͬ��������
			while (s != null) {
				if (s.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println("Output��"+s);
				System.out.print("Input��");
				s = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}