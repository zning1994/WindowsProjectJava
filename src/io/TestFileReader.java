package io;

import java.io.*;
/**
功能：从TestFileReader.java中读取字符，然后打印到控制台。
说明：中文可以正常显示，因为采用的是FileReader读取字符。
*/
public class TestFileReader {
  public static void main(String[] args) {
    FileReader fr = null; 
    int c = 0;
    try {
      fr = new FileReader("src/io/TestFileReader.java");
      int ln = 0;
      while ((c = fr.read()) != -1) {
        System.out.print((char)c);
      }
      fr.close();
    } catch (FileNotFoundException e) {
      System.out.println("找不到指定文件");
    } catch (IOException e) {
      System.out.println("文件读取错误");
    }
  }
}