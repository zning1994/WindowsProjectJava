package io;

import java.io.*;
/**
��1��ÿ�ζ�һ��byte����ô��
��2��Ϊ�����ĵĶ��ǡ�������
*/
public class TestFileInputStream {
  public static void main(String[] args) {
    int b = 0;
    FileInputStream in = null;
    System.out.println(new File("a").getAbsolutePath());
    try {
      in = new FileInputStream("src/io/TestFileInputStream.java");
    } catch (FileNotFoundException e) {
      System.out.println("�Ҳ���ָ���ļ�"); 
      System.exit(-1);
    }
    
    try {
      long num = 0;
      while((b=in.read())!=-1){  //��ȡһ��byte
        System.out.print((char)b); 
        num++;
      }
      in.close();  
      System.out.println();
      System.out.println("����ȡ�� "+num+" ���ֽ�");
    } catch (IOException e1) {
      System.out.println("�ļ���ȡ����"); 
    }
  }
}