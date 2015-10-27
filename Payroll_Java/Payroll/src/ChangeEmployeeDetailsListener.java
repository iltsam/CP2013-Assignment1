import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ChangeEmployeeDetailsListener implements ActionListener{
	private final PayrollGUI mView;
	private final DatabaseController db = new DatabaseController();
	private final Payroll payroll = new Payroll();
	public ChangeEmployeeDetailsListener(PayrollGUI pView) {
		mView = pView;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (mView.getSelectedListItem().equals(mView.getFirstName())) {
			System.out.println("Not changing details because they are the same.");
		} else {
			try {
				payroll.setupEmployeeDetails();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
