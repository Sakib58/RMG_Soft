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

public class SetSalary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetSalary frame = new SetSalary();
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
	public SetSalary() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetSalary = new JLabel("Set Salary");
		lblSetSalary.setBounds(153, 13, 144, 32);
		contentPane.add(lblSetSalary);
		
		textField = new JTextField("");
		textField.setBounds(246, 58, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("");
		textField_1.setBounds(246, 105, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("");
		textField_2.setBounds(246, 150, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("");
		textField_3.setBounds(246, 201, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField("");
		textField_4.setBounds(246, 247, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField("");
		textField_5.setBounds(246, 296, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(246, 341, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(163, 61, 71, 19);
		contentPane.add(lblGrade);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setBounds(153, 108, 81, 22);
		contentPane.add(lblBasicSalary);
		
		JLabel lblMedicalAllowance = new JLabel("Medical Allowance");
		lblMedicalAllowance.setBounds(118, 153, 116, 16);
		contentPane.add(lblMedicalAllowance);
		
		JLabel lblConveyanceAllowance = new JLabel("Conveyance Allowance");
		lblConveyanceAllowance.setBounds(103, 204, 131, 16);
		contentPane.add(lblConveyanceAllowance);
		
		JLabel lblFoodAllowance = new JLabel("Food Allowance");
		lblFoodAllowance.setBounds(118, 250, 116, 16);
		contentPane.add(lblFoodAllowance);
		
		JLabel lblMoneyPerOvertime = new JLabel("Money Per Overtime hour");
		lblMoneyPerOvertime.setBounds(71, 299, 163, 16);
		contentPane.add(lblMoneyPerOvertime);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int grade,bs,ma,ca,fa,moh,mlpy;
				grade=Integer.valueOf(textField.getText());
				bs=Integer.valueOf(textField_1.getText());
				ma=Integer.valueOf(textField_2.getText());
				ca=Integer.valueOf(textField_3.getText());
				fa=Integer.valueOf(textField_4.getText());
				moh=Integer.valueOf(textField_5.getText());
				mlpy=Integer.valueOf(textField_6.getText());
				SqlOperations so=new SqlOperations();
				so.setSalaryInfo(grade,bs,ma,ca,fa,moh,mlpy);
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
			}
		});
		btnSave.setBounds(289, 381, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(155, 381, 97, 25);
		contentPane.add(btnCancel);
		

		
		JLabel lblMaxLeavePer = new JLabel("Max Leave per year");
		lblMaxLeavePer.setBounds(96, 341, 138, 22);
		contentPane.add(lblMaxLeavePer);
	}

}
