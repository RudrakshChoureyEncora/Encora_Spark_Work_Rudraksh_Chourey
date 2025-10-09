package CollectDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FisFosDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=
				new FileInputStream("mydictionary.properties");
		FileOutputStream fos=new FileOutputStream("copy.properties");
		int i=0;
//		byte b[]=new byte[fis.available()];
//		while((i=fis.read())!=-1) {
//			System.out.print((char)i);
//		}
//		while(fis.read(b)!=-1) {
//			String s=new String(b);
//			System.out.println(s);
//		}
		System.out.println("Hello");
		byte b[]=new byte[4];
		while((i=fis.read(b))!=-1) {
			String s=new String(b,0,i);
			System.out.print(s);
			fos.write(b,0,i);
		}
	}
}








