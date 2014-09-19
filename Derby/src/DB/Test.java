package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	
	 public static void main(String[] args)  {
		 
	String driver ="org.apache.derby.jdbc.EmbeddedDriver";
	String url = "jdbc:derby:C:\\Users\\ZYP\\firstdb;create=true";
	Connection conn;
	Statement sta = null;
	ResultSet rs=null;
	System.out.println("1");
	try {
	 Class.forName(driver);
	 conn = DriverManager.getConnection(url);
			 sta = conn.createStatement();
			 System.out.println("2");
//			 sta.execute("insert into zyp values(aa, 88)");
		     rs = sta.executeQuery("select  *  from zyp"); // 查询表中的记录
		     System.out.println("3");
		     while(rs.next()) {
		        String name=rs.getString(1);
		        System.out.print(name+"\t");
//		        float score=rs.getFloat(2);
//		        System.out.println(score);
		     }
		     conn.close();
	}catch(Exception e) {
		 System.out.println("该表已经存在"); 
	}/*finally {
	 try {
		DriverManager.getConnection("jdbc:derby:;shutdown=true");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}*/
	 }
}
