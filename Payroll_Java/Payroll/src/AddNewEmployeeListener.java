import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddNewEmployeeListener implements ActionListener {
	private final PayrollGUI mView;
	private final DatabaseController db = new DatabaseController();
	private final Payroll payroll = new Payroll();
	
	public AddNewEmployeeListener(PayrollGUI pView) {
		mView = pView;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Create listener working");
		String[] newEmployee = mView.getNewEmployee();
		int age = Integer.parseInt(newEmployee[3]);
		int hr = Integer.parseInt(newEmployee[5]);
		int salary;
		if(newEmployee[4].equals("Yes")){
			salary = 1;
		} else {
			salary = 0;
		}
		// Need to add the last few values to the gui..
		String query = "INSERT INTO `Employee Details` (FirstName, LastName, Gender, Age, Salary, HourlyRate, MiddleNames, Affiliation, Classification,Address1) "
					+ "VALUES ('" + newEmployee[0] + "', '" + newEmployee[1] + "', '" + newEmployee[2] + "', '" + age + "', '" + salary + "', '" + hr + "','','','','')";
		try {
			db.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		payroll.populateList();
		
	}

}
