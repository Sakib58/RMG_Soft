import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllActivities extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllActivities frame = new AllActivities();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllActivities() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeActivity ea=new EmployeeActivity();
				ea.setVisible(true);
			}
		});
		btnEmployees.setBounds(191, 53, 362, 41);
		contentPane.add(btnEmployees);
		
		JButton btnSalaryCalculation = new JButton("Salary Calculation");
		btnSalaryCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaryActivity sa=new SalaryActivity();
				sa.setVisible(true);
			}
		});
		btnSalaryCalculation.setBounds(191, 143, 362, 41);
		contentPane.add(btnSalaryCalculation);
		
		JButton btnLeaveCalculation = new JButton("Leave Calculation");
		btnLeaveCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetLeave sl=new SetLeave();
				sl.setVisible(true);
			}
		});
		btnLeaveCalculation.setBounds(191, 233, 362, 41);
		contentPane.add(btnLeaveCalculation);
		
		JButton btnOvertimeCalculation = new JButton("Overtime Calculation");
		btnOvertimeCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetOvertime so=new SetOvertime();
				so.setVisible(true);
			}
		});
		btnOvertimeCalculation.setBounds(191, 336, 362, 41);
		contentPane.add(btnOvertimeCalculation);
		
		JLabel lblAllActivities = new JLabel("All Activities");
		lblAllActivities.setBounds(326, 13, 131, 27);
		contentPane.add(lblAllActivities);
	}
}
