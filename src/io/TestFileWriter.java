package io;

import java.io.*;
/*
功能：向文件unicode.dat中输出Unicode编码为0-50000的字符。
*/
public class TestFileWriter {
  public static void main(String[] args) {
    FileWriter fw = null;
    try {
      fw = new FileWriter("src/io/unicode.txt");
      for(int c=0;c<=65535;c++){
        fw.write(c);
      }
      fw.close();
    } catch (IOException e1) {
    	e1.printStackTrace();
      System.out.println("文件写入错误");
      System.exit(-1);
    }
  }
}
