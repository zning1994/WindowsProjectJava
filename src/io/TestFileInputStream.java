package io;

import java.io.*;
/**
（1）每次读一个byte可以么？
（2）为何中文的都是“？”？
*/
public class TestFileInputStream {
  public static void main(String[] args) {
    int b = 0;
    FileInputStream in = null;
    System.out.println(new File("a").getAbsolutePath());
    try {
      in = new FileInputStream("src/io/TestFileInputStream.java");
    } catch (FileNotFoundException e) {
      System.out.println("找不到指定文件"); 
      System.exit(-1);
    }
    
    try {
      long num = 0;
      while((b=in.read())!=-1){  //读取一个byte
        System.out.print((char)b); 
        num++;
      }
      in.close();  
      System.out.println();
      System.out.println("共读取了 "+num+" 个字节");
    } catch (IOException e1) {
      System.out.println("文件读取错误"); 
    }
  }
}