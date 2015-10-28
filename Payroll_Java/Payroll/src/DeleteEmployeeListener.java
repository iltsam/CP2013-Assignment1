import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteEmployeeListener implements ActionListener{
	private final PayrollGUI mView;
	private final DatabaseController db = new DatabaseController();
	private final Payroll payroll = new Payroll();
	
	public DeleteEmployeeListener(PayrollGUI pView) {
		mView = pView;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Delete button working..");
		String query = "DELETE FROM `Employee Details` WHERE ID = '"  + mView.getID() + "'";
		try {
			db.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		payroll.populateList();
		mView.setSelectedListItem(0);
		payroll.setupEmployeeDetails();
	}

}
