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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PayrollGUI {

	private JFrame frmPayroll;
	private JTextField txtNewsTextField;
	private DefaultListModel employeeListModel;
	private JTextField employeeFirstName;
	private JTextField employeeLastName;
	private JTextField dob;
	private JTextField hoursWorked;
	private JTextField hourlyRate;

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
		
		employeeListModel = new DefaultListModel();
		
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
		
		
		employeeList.setModel(employeeListModel);
		
		JButton loadDetails = new JButton("Load Details");
		loadDetails.setVerticalAlignment(SwingConstants.BOTTOM);
		employeeListPanel.add(loadDetails, BorderLayout.SOUTH);
		
		JPanel employeeDetailPanel = new JPanel();
		employeeDetails.add(employeeDetailPanel, BorderLayout.CENTER);
		GridBagLayout gbl_employeeDetailPanel = new GridBagLayout();
		gbl_employeeDetailPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_employeeDetailPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_employeeDetailPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_employeeDetailPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		employeeDetailPanel.setLayout(gbl_employeeDetailPanel);
		
		JLabel employeeFirstNamelbl = new JLabel("First Name");
		GridBagConstraints gbc_employeeFirstNamelbl = new GridBagConstraints();
		gbc_employeeFirstNamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_employeeFirstNamelbl.gridx = 1;
		gbc_employeeFirstNamelbl.gridy = 1;
		employeeDetailPanel.add(employeeFirstNamelbl, gbc_employeeFirstNamelbl);
		
		JLabel employeeLastNamelbl = new JLabel("Last Name");
		GridBagConstraints gbc_employeeLastNamelbl = new GridBagConstraints();
		gbc_employeeLastNamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_employeeLastNamelbl.gridx = 2;
		gbc_employeeLastNamelbl.gridy = 1;
		employeeDetailPanel.add(employeeLastNamelbl, gbc_employeeLastNamelbl);
		
		JLabel genderLbl = new JLabel("Gender");
		GridBagConstraints gbc_genderLbl = new GridBagConstraints();
		gbc_genderLbl.insets = new Insets(0, 0, 5, 5);
		gbc_genderLbl.gridx = 3;
		gbc_genderLbl.gridy = 1;
		employeeDetailPanel.add(genderLbl, gbc_genderLbl);
		
		JLabel dobLbl = new JLabel("D.O.B");
		GridBagConstraints gbc_dobLbl = new GridBagConstraints();
		gbc_dobLbl.insets = new Insets(0, 0, 5, 5);
		gbc_dobLbl.gridx = 4;
		gbc_dobLbl.gridy = 1;
		employeeDetailPanel.add(dobLbl, gbc_dobLbl);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		GridBagConstraints gbc_lblHoursWorked = new GridBagConstraints();
		gbc_lblHoursWorked.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoursWorked.gridx = 5;
		gbc_lblHoursWorked.gridy = 1;
		employeeDetailPanel.add(lblHoursWorked, gbc_lblHoursWorked);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate");
		GridBagConstraints gbc_lblHourlyRate = new GridBagConstraints();
		gbc_lblHourlyRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblHourlyRate.gridx = 6;
		gbc_lblHourlyRate.gridy = 1;
		employeeDetailPanel.add(lblHourlyRate, gbc_lblHourlyRate);
		
		JLabel lblSalary = new JLabel("Salary");
		GridBagConstraints gbc_lblSalary = new GridBagConstraints();
		gbc_lblSalary.insets = new Insets(0, 0, 5, 0);
		gbc_lblSalary.gridx = 7;
		gbc_lblSalary.gridy = 1;
		employeeDetailPanel.add(lblSalary, gbc_lblSalary);
		
		employeeFirstName = new JTextField();
		employeeFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		employeeFirstName.setText("Employee Name");
		GridBagConstraints gbc_employeeFirstName = new GridBagConstraints();
		gbc_employeeFirstName.weightx = 10.0;
		gbc_employeeFirstName.insets = new Insets(0, 0, 0, 5);
		gbc_employeeFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeeFirstName.gridx = 1;
		gbc_employeeFirstName.gridy = 2;
		employeeDetailPanel.add(employeeFirstName, gbc_employeeFirstName);
		employeeFirstName.setColumns(10);
		
		employeeLastName = new JTextField();
		employeeLastName.setHorizontalAlignment(SwingConstants.CENTER);
		employeeLastName.setText("Employee Last Name");
		GridBagConstraints gbc_employeeLastName = new GridBagConstraints();
		gbc_employeeLastName.weightx = 10.0;
		gbc_employeeLastName.insets = new Insets(0, 0, 0, 5);
		gbc_employeeLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeeLastName.gridx = 2;
		gbc_employeeLastName.gridy = 2;
		employeeDetailPanel.add(employeeLastName, gbc_employeeLastName);
		employeeLastName.setColumns(10);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.weightx = 0.1;
		gbc_gender.insets = new Insets(0, 0, 0, 5);
		gbc_gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_gender.gridx = 3;
		gbc_gender.gridy = 2;
		employeeDetailPanel.add(gender, gbc_gender);
		
		dob = new JTextField();
		GridBagConstraints gbc_dob = new GridBagConstraints();
		gbc_dob.weightx = 5.0;
		gbc_dob.insets = new Insets(0, 0, 0, 5);
		gbc_dob.fill = GridBagConstraints.HORIZONTAL;
		gbc_dob.gridx = 4;
		gbc_dob.gridy = 2;
		employeeDetailPanel.add(dob, gbc_dob);
		dob.setColumns(10);
		
		hoursWorked = new JTextField();
		GridBagConstraints gbc_hoursWorked = new GridBagConstraints();
		gbc_hoursWorked.weightx = 0.5;
		gbc_hoursWorked.insets = new Insets(0, 0, 0, 5);
		gbc_hoursWorked.fill = GridBagConstraints.HORIZONTAL;
		gbc_hoursWorked.gridx = 5;
		gbc_hoursWorked.gridy = 2;
		employeeDetailPanel.add(hoursWorked, gbc_hoursWorked);
		hoursWorked.setColumns(10);
		
		hourlyRate = new JTextField();
		GridBagConstraints gbc_hourlyRate = new GridBagConstraints();
		gbc_hourlyRate.weightx = 0.1;
		gbc_hourlyRate.insets = new Insets(0, 0, 0, 5);
		gbc_hourlyRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_hourlyRate.gridx = 6;
		gbc_hourlyRate.gridy = 2;
		employeeDetailPanel.add(hourlyRate, gbc_hourlyRate);
		hourlyRate.setColumns(10);
		
		JComboBox salary = new JComboBox();
		salary.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		GridBagConstraints gbc_salary = new GridBagConstraints();
		gbc_salary.weightx = 0.1;
		gbc_salary.fill = GridBagConstraints.HORIZONTAL;
		gbc_salary.gridx = 7;
		gbc_salary.gridy = 2;
		employeeDetailPanel.add(salary, gbc_salary);
		
		if(salary.getModel().getSelectedItem() == "Yes") {
			hoursWorked.setEditable(false);
			hourlyRate.setEditable(false);
			
		}
		
		JPanel runPayroll = new JPanel();
		tabbedPane.addTab("Run Payroll", null, runPayroll, null);
		runPayroll.setLayout(new BorderLayout(0, 0));
		
		Button runPayrollButton = new Button("Run Payroll");
		runPayroll.add(runPayrollButton, BorderLayout.SOUTH);
		
		JTextArea runPayrollTextArea = new JTextArea();
		runPayroll.add(runPayrollTextArea, BorderLayout.CENTER);
	}

}
