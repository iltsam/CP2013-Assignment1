import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	};

	public static void populateList() {
		gui.dropList();
		try {
			resultSet = db.dbQuery("SELECT * FROM `Employee Details`");
			while(resultSet.next()){
				System.out.println("ID: " + resultSet.getString("id") + "\nName: " + resultSet.getString("FirstName"));
				gui.addEmployeeToList(resultSet.getString("ID") + "|" + resultSet.getString("FirstName"));
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
	
	public static void setupEmployeeDetails(){
		try {
			String idString = "";
			int splitIndex = gui.getSelectedListItem().indexOf("|");
			if (splitIndex != -1) {
				idString = gui.getSelectedListItem().substring(0, splitIndex);
			}
			int id = Integer.parseInt(idString);
			resultSet = db.dbQuery("SELECT * FROM `Employee Details` WHERE ID = '" + id + "'");
			while(resultSet.next()) {
				gui.setID(resultSet.getString("ID"));
				gui.setFirstName(resultSet.getString("FirstName"));
				gui.setLastName(resultSet.getString("LastName"));
				gui.setAge(resultSet.getInt("Age"));
				gui.setAddress(resultSet.getString("Address1"));
				gui.setHourlyRate(resultSet.getInt("HourlyRate"));
				gui.setAffiliation(resultSet.getString("Affiliation"));
				int salary = resultSet.getInt("Salary");
				if (salary == 1) {
					gui.setSalary(true);
				} else if (salary == 0) {
					gui.setSalary(false);
				}
				gui.setGender(resultSet.getString("Gender"));
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
