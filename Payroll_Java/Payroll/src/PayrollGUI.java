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
	private JTextField employeeFirstNameTextBox;
	private JTextField employeeLastNameTextBox;
	private JTextField dobTextBox;
	private JTextField hoursWorkedTextBox;
	private JTextField hourlyRateTextBox;
	private JTextField idTextBox;
	public JComboBox salaryComboBox;
	private JComboBox genderComboBox;

	/**
	 * Launch the application.
	 */
	public static void main() {
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
		gbl_employeeDetailPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_employeeDetailPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		employeeDetailPanel.setLayout(gbl_employeeDetailPanel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.weightx = 2.0;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		employeeDetailPanel.add(lblId, gbc_lblId);
		
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
		
		idTextBox = new JTextField();
		idTextBox.setText("ID");
		idTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_idTextBox = new GridBagConstraints();
		gbc_idTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_idTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_idTextBox.gridx = 0;
		gbc_idTextBox.gridy = 2;
		employeeDetailPanel.add(idTextBox, gbc_idTextBox);
		idTextBox.setColumns(10);
		
		employeeFirstNameTextBox = new JTextField();
		employeeFirstNameTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		employeeFirstNameTextBox.setText("Employee Name");
		GridBagConstraints gbc_employeeFirstNameTextBox = new GridBagConstraints();
		gbc_employeeFirstNameTextBox.weightx = 10.0;
		gbc_employeeFirstNameTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_employeeFirstNameTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeeFirstNameTextBox.gridx = 1;
		gbc_employeeFirstNameTextBox.gridy = 2;
		employeeDetailPanel.add(employeeFirstNameTextBox, gbc_employeeFirstNameTextBox);
		employeeFirstNameTextBox.setColumns(10);
		
		employeeLastNameTextBox = new JTextField();
		employeeLastNameTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		employeeLastNameTextBox.setText("Employee Last Name");
		GridBagConstraints gbc_employeeLastNameTextBox = new GridBagConstraints();
		gbc_employeeLastNameTextBox.weightx = 10.0;
		gbc_employeeLastNameTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_employeeLastNameTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeeLastNameTextBox.gridx = 2;
		gbc_employeeLastNameTextBox.gridy = 2;
		employeeDetailPanel.add(employeeLastNameTextBox, gbc_employeeLastNameTextBox);
		employeeLastNameTextBox.setColumns(10);
		
		JComboBox genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		GridBagConstraints gbc_genderComboBox = new GridBagConstraints();
		gbc_genderComboBox.weightx = 0.1;
		gbc_genderComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_genderComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderComboBox.gridx = 3;
		gbc_genderComboBox.gridy = 2;
		employeeDetailPanel.add(genderComboBox, gbc_genderComboBox);
		
		dobTextBox = new JTextField();
		GridBagConstraints gbc_dobTextBox = new GridBagConstraints();
		gbc_dobTextBox.weightx = 5.0;
		gbc_dobTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_dobTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dobTextBox.gridx = 4;
		gbc_dobTextBox.gridy = 2;
		employeeDetailPanel.add(dobTextBox, gbc_dobTextBox);
		dobTextBox.setColumns(10);
		
		hoursWorkedTextBox = new JTextField();
		GridBagConstraints gbc_hoursWorkedTextBox = new GridBagConstraints();
		gbc_hoursWorkedTextBox.weightx = 0.5;
		gbc_hoursWorkedTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_hoursWorkedTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_hoursWorkedTextBox.gridx = 5;
		gbc_hoursWorkedTextBox.gridy = 2;
		employeeDetailPanel.add(hoursWorkedTextBox, gbc_hoursWorkedTextBox);
		hoursWorkedTextBox.setColumns(10);
		
		hourlyRateTextBox = new JTextField();
		GridBagConstraints gbc_hourlyRateTextBox = new GridBagConstraints();
		gbc_hourlyRateTextBox.weightx = 0.1;
		gbc_hourlyRateTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_hourlyRateTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_hourlyRateTextBox.gridx = 6;
		gbc_hourlyRateTextBox.gridy = 2;
		employeeDetailPanel.add(hourlyRateTextBox, gbc_hourlyRateTextBox);
		hourlyRateTextBox.setColumns(10);
		
		JComboBox salaryComboBox = new JComboBox();
		salaryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		GridBagConstraints gbc_salaryComboBox = new GridBagConstraints();
		gbc_salaryComboBox.weightx = 0.1;
		gbc_salaryComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_salaryComboBox.gridx = 7;
		gbc_salaryComboBox.gridy = 2;
		employeeDetailPanel.add(salaryComboBox, gbc_salaryComboBox);
		
		if(salaryComboBox.getModel().getSelectedItem() == "Yes") {
			hoursWorkedTextBox.setEditable(false);
			hourlyRateTextBox.setEditable(false);
			
		}
		
		JPanel runPayroll = new JPanel();
		tabbedPane.addTab("Run Payroll", null, runPayroll, null);
		runPayroll.setLayout(new BorderLayout(0, 0));
		
		Button runPayrollButton = new Button("Run Payroll");
		runPayroll.add(runPayrollButton, BorderLayout.SOUTH);
		
		JTextArea runPayrollTextArea = new JTextArea();
		runPayroll.add(runPayrollTextArea, BorderLayout.CENTER);
	}
	
	public String getID(){
		String id;
		id = idTextBox.getText();
		return id;
	}
	
	public String getFirstName(){
		String firstName;
		firstName = employeeFirstNameTextBox.getText();
		return firstName;
	}
	
	public String getLastName() {
		String lastName;
		lastName = employeeLastNameTextBox.getText();
		return lastName;
	}
	
	public String getGender() {
		String gender;
		gender = genderComboBox.getModel().getSelectedItem().toString();
		return gender;
	}
	
	public String getDOB(){
		String dob;
		dob = dobTextBox.getText();
		return dob;
	}
	
	public String getHoursWorked(){
		String hoursWorked;
		hoursWorked = hoursWorkedTextBox.getText();
		return hoursWorked;
	}
	
	public String getHourlyRate() {
		String hourlyRate;
		hourlyRate = hourlyRateTextBox.getText();
		return hourlyRate;
	}
	
	public String getSalary() {
		String salary;
		salary = salaryComboBox.getModel().getSelectedItem().toString();
		System.out.println(salaryComboBox.getModel().getSelectedItem().toString());
		return salary;
	}
	

}
