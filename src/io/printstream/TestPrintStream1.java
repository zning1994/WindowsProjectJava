package io.printstream;

import java.io.*;
/*
重定向的使用
功能：将编码小于60000的Unicode字符写入文件TestPrintStream1.txt
*/
public class TestPrintStream1 { 
  public static void main(String[] args) {
    PrintStream ps = null;
    try {
      FileOutputStream fos = new FileOutputStream("src/io/printstream/TestPrintStream1.txt");
      ps = new PrintStream(fos);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if(ps != null){
      System.setOut(ps);//重定向
    }
    
    int ln = 0;
    for(char c = 0; c <= 60000; c++){
      System.out.print(c+ " ");
      if(ln++ >=100){ 
      	System.out.println(); 
      	ln = 0;
      }
    }
  }
}
