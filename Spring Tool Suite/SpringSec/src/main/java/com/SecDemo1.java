package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

public class SecDemo1 {
	public static void main(String  args[])
	   {
		// Method 1: Using System property
		System.out.println(System.getProperty("user.dir"));

		   createDigest();
		   checkDigest();
	   }
	
	
	
	   public static void createDigest() {
	   try{ MessageDigest md  =  MessageDigest.getInstance("SHA");   	 
		   String   s1 = "Hang him not, leave him";
		   byte[]    array = s1.getBytes();
		   md.update(array);	 
		   FileOutputStream        fos = new FileOutputStream("demo1test");
		   ObjectOutputStream      oos = new ObjectOutputStream(fos);	 
		   oos.writeObject(s1);
		   oos.writeObject(md.digest ());
		   System.out.println(" digest ready!");
	   }catch(Exception e1)            { System.out.println(""+e1);}
	   }
	   
	   
	   
	   public static void checkDigest() {
		   try
		   {
			   FileInputStream        fis =     new FileInputStream("demo1test");
			   ObjectInputStream      ois =     new ObjectInputStream(fis);
			   Object   ob1 = ois.readObject();
			   String   s1 = (String) ob1;
			   System.out.println("The value..:"+s1);
			   //Now i need to check whether the data is not corrupted in transition
			   Object ob2 = ois.readObject();
			   byte[]    array1= (byte[])  ob2;
			   MessageDigest   md =     MessageDigest.getInstance("SHA");
			   md.update(s1.getBytes());
		   if(MessageDigest.isEqual(md.digest(), array1))
		   {   System.out.println("valid");   }
		   else   {   System.out.println("corrupted");}

		   }   catch(Exception e1)
		           { System.out.println(""+e1);}

		   }
	
}
