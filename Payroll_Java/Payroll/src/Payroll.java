import java.sql.*;

import javax.swing.SwingUtilities;

// Public ip 123.211.106.137
public class Payroll {
	private static int hello;
	private static PayrollGUI gui;
	private static DatabaseController db = new DatabaseController();
	private static ResultSet resultSet;
	public static void main(String[] args) throws Exception{
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                gui = new PayrollGUI();
                gui.main();
            }
        });
		for (int i = 0; i < 100000; i++) {
			hello++;
		}
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                test();
            }
        });
	};

	private static void test() {
		try {
			resultSet = db.dbQuery("SELECT * FROM Employee");
			while(resultSet.next()){
				System.out.println("ID: " + resultSet.getString("id") + "\nName: " + resultSet.getString("first_name"));
				gui.addEmployeeToList(resultSet.getString("first_name"));
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
