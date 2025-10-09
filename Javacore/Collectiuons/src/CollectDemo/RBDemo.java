package CollectDemo;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class RBDemo {
	public static void main(String[] args)throws Exception {
		Properties prop=new Properties();
		//prop.put(new Employees("ramu",20), "ramu");
		
		//prop.load(new FileInputStream("dictionary.properties"));
//		Locale locale=new Locale("ta");
//		Locale.setDefault(locale);
		ResourceBundle rb=ResourceBundle.getBundle("mydictionary");
		
		System.out.println(rb.getString("hello"));
		
		
		
		//System.out.println(prop.get("hello"));
		
		
	}
}
