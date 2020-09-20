import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalaryActivity extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryActivity frame = new SalaryActivity();
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
	public SalaryActivity() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSetAllSalary = new JButton("Set All Salary");
		btnSetAllSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetSalary ss=new SetSalary();
				ss.setVisible(true);
			}
		});
		btnSetAllSalary.setBounds(55, 55, 277, 54);
		contentPane.add(btnSetAllSalary);
		
		JButton btnCalculateParticularEmployees = new JButton("Calculate Particular Employee's Salary");
		btnCalculateParticularEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSalary es=new EmployeeSalary();
				es.setVisible(true);
			}
		});
		btnCalculateParticularEmployees.setBounds(55, 122, 277, 54);
		contentPane.add(btnCalculateParticularEmployees);
		
		JButton btnCalculateAllEmployees = new JButton("Calculate All Employee's Salary");
		btnCalculateAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlOperations so=new SqlOperations();
				so.getAllSalary();
			}
		});
		btnCalculateAllEmployees.setBounds(55, 189, 277, 51);
		contentPane.add(btnCalculateAllEmployees);
		
		JLabel lblSalaryActivity = new JLabel("Salary Activity");
		lblSalaryActivity.setBounds(132, 13, 116, 29);
		contentPane.add(lblSalaryActivity);
	}

}
