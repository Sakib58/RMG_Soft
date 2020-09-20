import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewEmployee frame = new AddNewEmployee();
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
	public AddNewEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField(null);
		textField.setBounds(222, 62, 207, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(null);
		textField_1.setColumns(10);
		textField_1.setBounds(222, 128, 207, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(null);
		textField_2.setColumns(10);
		textField_2.setBounds(222, 204, 207, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(null);
		textField_3.setColumns(10);
		textField_3.setBounds(222, 289, 207, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField(null);
		textField_4.setColumns(10);
		textField_4.setBounds(222, 371, 207, 34);
		contentPane.add(textField_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				String mobile=textField_1.getText();
				String nid=textField_2.getText();
				String address=textField_3.getText();
				int grade=Integer.parseInt(textField_4.getText());
				if (name==null || mobile==null || nid==null || address==null || !(grade>0 && grade<8)) {
					JOptionPane.showMessageDialog(null, "Please fillup all requirements");
				}else {
					SqlOperations so=new SqlOperations();
					so.addNewEmployee(name, mobile, nid, address, grade);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
				
				}
				
				
			}
		});
		btnSave.setBounds(367, 462, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(234, 462, 97, 25);
		contentPane.add(btnCancel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(61, 62, 126, 25);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("Phone");
		label.setBounds(61, 128, 126, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("NID");
		label_1.setBounds(61, 204, 126, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(61, 289, 126, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Grade");
		label_3.setBounds(61, 371, 126, 25);
		contentPane.add(label_3);
	}
}
