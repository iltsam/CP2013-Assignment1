


public class Payroll {
	private static PayrollGUI gui = new PayrollGUI();
	public static void main(String[] args) {
		gui.main();
		
		test();
	}
	
	private static void test() {
		System.out.println(gui.getFirstName());
	}

}
