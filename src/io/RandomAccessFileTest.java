package io;

import java.io.*;
public class RandomAccessFileTest {
     public static void main(String[] args) throws IOException {
          File testfile = new File("testfile3");
          testfile.delete();
          testfile.createNewFile();
          System.out.println("length #1 = " +testfile.length());
          RandomAccessFile raf = new RandomAccessFile("testfile3", "rw");
          raf.setLength(100);
          raf.close();
          System.out.println("length #2 = " + testfile.length());
    }
}
