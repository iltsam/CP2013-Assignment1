import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.sun.prism.paint.Color;

import javax.swing.JTextPane;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;

public class PayrollGUI {

	private JFrame frmPayroll;
	private JTextField txtNewsTextField;
	private DefaultListModel listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollGUI window = new PayrollGUI();
					window.frmPayroll.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PayrollGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPayroll = new JFrame();
		frmPayroll.setTitle("Payroll");
		frmPayroll.setBounds(100, 100, 800, 600);
		frmPayroll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listModel = new DefaultListModel();
		listModel.addElement("First Employee");
		listModel.addElement("Second Employee");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPayroll.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel overview = new JPanel();
		tabbedPane.addTab("Overview", null, overview, null);
		overview.setLayout(new GridLayout(1, 0, 0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		overview.add(verticalBox);
		
		JPanel payrollLastRanPanel = new JPanel();
		verticalBox.add(payrollLastRanPanel);
		payrollLastRanPanel.setLayout(new GridLayout(1, 0, 0, 0));
		Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
		payrollLastRanPanel.setBorder(border);
		
		JLabel payrollLabel = new JLabel("Payroll Last Ran: Never");
		payrollLastRanPanel.add(payrollLabel);
		
		JPanel newsPanel = new JPanel();
		verticalBox.add(newsPanel);
		newsPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNews = new JLabel("News");
		lblNews.setHorizontalAlignment(SwingConstants.CENTER);
		newsPanel.add(lblNews, BorderLayout.NORTH);
		
		txtNewsTextField = new JTextField();
		lblNews.setLabelFor(txtNewsTextField);
		txtNewsTextField.setText("29/10/2015 - New Payroll system implemented");
		txtNewsTextField.setEditable(false);
		txtNewsTextField.setHorizontalAlignment(SwingConstants.CENTER);
		newsPanel.add(txtNewsTextField, BorderLayout.CENTER);
		txtNewsTextField.setColumns(10);
		
		List list = new List();
		overview.add(list);
		
		JPanel employeeDetails = new JPanel();
		tabbedPane.addTab("Employee Details", null, employeeDetails, null);
		employeeDetails.setLayout(new BorderLayout(0, 0));
		
		JPanel employeeListPanel = new JPanel();
		employeeDetails.add(employeeListPanel, BorderLayout.WEST);
		employeeListPanel.setLayout(new BorderLayout(0, 0));
		
		JList employeeList = new JList();
		employeeListPanel.add(employeeList);
		
		
		employeeList.setModel(listModel);
		
		JPanel panel_1 = new JPanel();
		employeeDetails.add(panel_1, BorderLayout.CENTER);
		
		JPanel runPayroll = new JPanel();
		tabbedPane.addTab("Run Payroll", null, runPayroll, null);
		runPayroll.setLayout(new BorderLayout(0, 0));
		
		Button runPayrollButton = new Button("Run Payroll");
		runPayroll.add(runPayrollButton, BorderLayout.SOUTH);
		
		JTextArea runPayrollTextArea = new JTextArea();
		runPayroll.add(runPayrollTextArea, BorderLayout.CENTER);
	}

}
