package io;

import java.io.*;
/**
���ܣ���TestFileReader.java�ж�ȡ�ַ���Ȼ���ӡ������̨��
˵�������Ŀ���������ʾ����Ϊ���õ���FileReader��ȡ�ַ���
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
      System.out.println("�Ҳ���ָ���ļ�");
    } catch (IOException e) {
      System.out.println("�ļ���ȡ����");
    }
  }
}