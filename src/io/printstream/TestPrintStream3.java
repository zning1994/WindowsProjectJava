package io.printstream;

/*
功能：完成类似于日志的功能
说明：(1)使用PrintWriter往文件里面写字符；(2)键盘输入功能的实现
*/

import java.util.*; 
import java.io.*;

public class TestPrintStream3 {
  public static void main(String[] args) {
    String s = null;
	
    try {
//    	System.setIn(new FileInputStream("src/io/printstream/TestPrintStream3.java"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/printstream/TestPrintStream3.log", true));
    	PrintWriter log = new PrintWriter(bw);

      
      while ((s = br.readLine())!=null) {
        if(s.equalsIgnoreCase("exit")){
			break;
		}
        System.out.println(s.toUpperCase());
        log.println("-----");
        log.println(s.toUpperCase()); 
        log.flush();
      }

      log.println("==="+new Date()+"==="); 
      log.flush();
      log.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}