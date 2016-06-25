package io.File;

import java.io.*;

/**
 * @version 1.00 05 Sep 1997
 * @author Gary Cornell
 */
public class FindDirectories
{
   public static void main(String[] args) {
     if (args.length == 0) args = new String[] { ".." };
	 File pathName = new File(args[0]);
	 String[] fileNames = pathName.list();
	
	 for (int i = 0; i < fileNames.length; i++) {
	    File f = new File(pathName.getPath(), fileNames[i]);
	    if (f.isDirectory()) {
	       System.out.println(f.getAbsolutePath());
	       main(new String[] { f.getPath() });
	    }
	 }
   }
}
