import java.awt.EventQueue;
import java.sql.*;

import javax.swing.SwingUtilities;

// Public ip 123.211.106.137
public class Payroll {
	private static PayrollGUI gui;
	private static DatabaseController db = new DatabaseController();
	private static ResultSet resultSet;
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
            public void run(){
                gui = new PayrollGUI();
                gui.main();
            }
        });
		
		EventQueue.invokeLater(new Runnable() {
            public void run(){
    			populateList();
    			setupEmployeeDetails();
            }
        });
		
		EventQueue.invokeLater(new Runnable() {
            public void run(){
            	
            }
        });
	};

	private static void populateList() {
		try {
			resultSet = db.dbQuery("SELECT * FROM `Employee Details`");
			while(resultSet.next()){
				System.out.println("ID: " + resultSet.getString("id") + "\nName: " + resultSet.getString("FirstName"));
				gui.addEmployeeToList(resultSet.getString("FirstName"));
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
	
	private static void setupEmployeeDetails(){
		try {
			String firstName = gui.getSelectedListItem();
			resultSet = db.dbQuery("SELECT * FROM `Employee Details` WHERE FirstName = '" + firstName + "'");
			while(resultSet.next()) {
				gui.setID(resultSet.getString("ID"));
				gui.setFirstName(resultSet.getString("FirstName"));
				gui.setLastName(resultSet.getString("LastName"));
				gui.setAge(resultSet.getInt("Age"));
				System.out.println(gui.getLastName());
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
