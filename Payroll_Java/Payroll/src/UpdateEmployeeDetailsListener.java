import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployeeDetailsListener implements ActionListener {
	private final PayrollGUI mView;
	private final DatabaseController db = new DatabaseController();
	
	public UpdateEmployeeDetailsListener(PayrollGUI pView) {
		mView = pView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Update Details button working.");
		
	}
}
