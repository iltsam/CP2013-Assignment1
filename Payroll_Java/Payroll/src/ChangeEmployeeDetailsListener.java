import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ChangeEmployeeDetailsListener implements ActionListener{
	private final PayrollGUI mView;
	private final DatabaseController db = new DatabaseController();
	public ChangeEmployeeDetailsListener(PayrollGUI pView) {
		mView = pView;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (mView.getSelectedListItem().equals(mView.getFirstName())) {
			System.out.println("Not changing details because they are the same.");
		} else {
			try {
				String firstName = mView.getSelectedListItem();
				ResultSet rs = db.dbQuery("SELECT * FROM `Employee Details` WHERE FirstName = '" + firstName + "'");
				while(rs.next()) {
					mView.setID(rs.getString("ID"));
					mView.setFirstName(rs.getString("FirstName"));
					mView.setLastName(rs.getString("LastName"));
					mView.setAge(rs.getInt("Age"));
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
