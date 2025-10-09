package JdbcDemoPack2;



import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.Properties;

public class ConnectionPool {
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	private static Connection con;
	private static Properties prop;
	static {
		prop=new Properties();
		try {
		prop.load(new FileInputStream("dbconfig.properties"));
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	synchronized public static Connection getConnection()throws Exception {
			con=tlocal.get();
			//Optional.ofNullable(con)
			System.out.println("Establishing for "+Thread.currentThread().getName() +"   "+ con);
			if(con==null) {
				String url=prop.getProperty("url");
				String username=prop.getProperty("username");
				String password=prop.getProperty("password");
				try {
				con=DriverManager.getConnection(url,username,password);
				con.setAutoCommit(false);
				tlocal.set(con);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			

			System.out.println("Established for "+Thread.currentThread().getName() +"   "+ con);
			return con;
	}
	
	
	synchronized public static void closeConnection()throws Exception {
		con=tlocal.get();
		System.out.println("Closing for "+Thread.currentThread().getName() +"  "+ con);
		if(con!=null) {
			con.close();
			tlocal.remove();
			System.out.println("Closed for "+Thread.currentThread().getName() +"  "+ con);
		}
	}
}
