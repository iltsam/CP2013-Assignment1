import java.sql.*;

// Public ip 123.211.106.137
public class Payroll {
	
	private static PayrollGUI gui = new PayrollGUI();
	private static DatabaseController db = new DatabaseController();
	
	public static void main(String[] args) throws Exception{
		gui.main();
		test();
		db.dbTest();
		

	}

	private static void test() {
		gui.setGender("Female");
	}
	
	

}
