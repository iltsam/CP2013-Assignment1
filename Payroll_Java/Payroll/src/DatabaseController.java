import java.sql.*;

public class DatabaseController {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void dbTest() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://123.211.106.137/Payroll?"
					+ "user=root&password=it@jcu");
			
			
			// Statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      // Result set get the result of the SQL query
		      resultSet = statement
		          .executeQuery("select * from Employee");
		      System.out.println(resultSet);
		      while (resultSet.next()) {
		    	  String firstName = resultSet.getString("first_name");
		    	  String id = resultSet.getString("id");
		    	  System.out.println("ID = " + id);
		    	  System.out.println("First Name = " + firstName);
		      }
		      
		      
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public ResultSet dbQuery(String query) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://123.211.106.137/Payroll?"
												+ "user=root&password=it@jcu");
			
			  statement = connect.createStatement();
			  // Result set get the result of the SQL query
			  resultSet = statement.executeQuery(query);
			  System.out.println(resultSet);
//			  while (resultSet.next()) {
//				  String firstName = resultSet.getString("first_name");
//				  String id = resultSet.getString("id");
//				  System.out.println("ID = " + id);
//				  System.out.println("First Name = " + firstName);
//			  }
		} catch (Exception e) {
			throw e;
		}
		return resultSet;
	}

	public void close() {
		// TODO Auto-generated method stub
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
