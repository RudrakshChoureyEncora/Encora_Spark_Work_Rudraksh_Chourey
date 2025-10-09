package JdbcDemoPack;

import java.io.FileReader;
import java.io.FileWriter;

public class TryWithResourcesDEmo {
	public static void main(String[] args) {
		
		try(
				FileWriter	out=new FileWriter("copy.txt");
				FileReader	in=new FileReader("abc.txt");
				) {
			int i=0;
			char c[]=new char[4];
			
			while((i=in.read(c))!=-1) {
				out.write(c,0,i);
				System.out.print(c);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
//		finally {
//			try{out.close();}catch(Exception ee) {}
//		}
		 
	}
}


