package io.transform;
/**
功能：接收键盘输入，然后输入。
*/

import java.io.*;

public class KeyboardInput {
	public static void main(String args[]) {
		String s;
		//Create a buffered reader to read each line from the keyboard.
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);

		System.out.println("Unix: Type ctrl-d or ctrl-c to exit."
				+ "\nWindows: Type ctrl-z to exit.");
		try {
			// 用ctrl+z来结束
			while ((s = in.readLine()) != null) {
				System.out.println("Read: " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
