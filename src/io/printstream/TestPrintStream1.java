package io.printstream;

import java.io.*;
/*
�ض����ʹ��
���ܣ�������С��60000��Unicode�ַ�д���ļ�TestPrintStream1.txt
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
      System.setOut(ps);//�ض���
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
