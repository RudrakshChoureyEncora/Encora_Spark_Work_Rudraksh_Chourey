package CollectDemo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class SirializationDemo { 
	public static void main(String[] args) throws Exception{
		Laddu laddu=new Laddu();
		System.out.println("Original size..:"+laddu.size);
		
		ObjectOutputStream oos=
			new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		oos.writeObject(laddu);
		laddu.size=5;
		System.out.println("New size...:"+laddu);
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu l2=(Laddu)ois.readObject();
		System.out.println("New Laddu size..:"+l2.size);
		
				
	}
}

class Laddu implements Serializable{
	int size=10;
}





















