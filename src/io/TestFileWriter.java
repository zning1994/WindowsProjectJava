package io;

import java.io.*;
/*
���ܣ����ļ�unicode.dat�����Unicode����Ϊ0-50000���ַ���
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
      System.out.println("�ļ�д�����");
      System.exit(-1);
    }
  }
}
