import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeSalary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSalary frame = new EmployeeSalary();
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
	public EmployeeSalary() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalculatingOnesSalary = new JLabel("Calculating One's Salary");
		lblCalculatingOnesSalary.setBounds(141, 13, 138, 31);
		contentPane.add(lblCalculatingOnesSalary);
		
		textField = new JTextField();
		textField.setBounds(239, 67, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(120, 70, 94, 19);
		contentPane.add(lblEmployeeId);
		
		JLabel label = new JLabel("Result");
		label.setBounds(120, 186, 253, 31);
		contentPane.add(label);
		
		JButton btnCalculateSalary = new JButton("Calculate Salary");
		btnCalculateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlOperations so=new SqlOperations();
				int res=so.getOnesSalary(Integer.parseInt(textField.getText()));
				label.setText("Total Salary: "+res);
			}
		});
		btnCalculateSalary.setBounds(265, 111, 125, 25);
		contentPane.add(btnCalculateSalary);
		
		
	}

}
