package io.transform;
import java.io.*;

/*
 功能：得到从键盘输入的字符，并打印到控制台。
 说明：BufferedReader的一种构造器的使用方法。
 */
public class TestTransForm2 {
	public static void main(String args[]) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
		    System.out.print("Input：");
			s = br.readLine();// 阻塞式方法（同步方法）
			while (s != null) {
				if (s.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println("Output："+s);
				System.out.print("Input：");
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