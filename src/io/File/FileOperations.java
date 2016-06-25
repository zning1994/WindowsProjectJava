package io.File;

import java.io.*;
import java.util.Date;
class FileOperations {
    public static void main(String[] args) throws IOException {
    	String fileName = "testfile.txt";
//    	String fileName = "D:\\workspace\\eclipse1\\java_advanced\\testfile.txt";
    	String dirName = "C:/temps/myfolder";

        File file = new File(fileName);
        File dir = new File(dirName);

        System.out.println("file exist = " + file.exists());
        if (!file.exists())
        	System.out.println("create file succeed = " + file.createNewFile());
        if(!dir.exists())
        	System.out.println("make dir succeed = " + dir.mkdir());
        
        System.out.println("file exist = " + file.exists());
        System.out.println("file is directory = " + file.isDirectory());
        System.out.println("dir is directory = " + dir.isDirectory());
        System.out.println("file is file = " + file.isFile());
        System.out.println("dir is file = " + dir.isFile());

        
        System.out.println("name = " + file.getName());
        System.out.println("path = " + file.getPath());
        System.out.println("absolute path = " +  file.getAbsolutePath());
        
       
        System.out.println("lastModified = " + new Date(file.lastModified()));
        System.out.println("length = " + file.length());
        
        System.out.println("canRead = " + file.canRead());
        System.out.println("canWrite = " + file.canWrite());
        file.setReadOnly();
        System.out.println("canRead = " + file.canRead());
        System.out.println("canWrite = " + file.canWrite());
        file.delete();
        System.out.println("file exist = " + file.exists());


   }
}
