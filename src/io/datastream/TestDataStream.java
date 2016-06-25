package io.datastream;

/*
���ܣ��������������ʵ����
	  ���ļ�TestDataSteam.dat��ֱ��д�����ݣ�Ȼ��������ݣ�����ӡ������̨��
*/
import java.io.*;

public class TestDataStream {
  public static void main(String[] args) {
    try {
      DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/io/datastream/TestDataStream.dat"));
      dos.writeDouble(3.1415926);
      dos.writeBoolean(true);
      System.out.println(new File("src/io/datastream/TestDataStream.dat").length());
      
      DataInputStream dis = new DataInputStream(new FileInputStream("src/io/datastream/TestDataStream.dat"));
      System.out.println(dis.readDouble());
      System.out.println(dis.readBoolean());
      System.out.println();
      
	  FileOutputStream fos = new FileOutputStream("src/io/datastream/TestDataStream.txt");
      fos.write(String.valueOf(Math.PI).getBytes());
      fos.write(String.valueOf(true).getBytes());
      System.out.println(new File("src/io/datastream/TestDataStream.txt").length());

      FileInputStream fis = new FileInputStream("src/io/datastream/TestDataStream.txt");
      //how to read??

      dos.close();
      dis.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}