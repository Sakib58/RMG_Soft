import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EmployeeActivity extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeActivity frame = new EmployeeActivity();
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
	public EmployeeActivity() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(161, 61, 154, 36);
		contentPane.add(btnAddEmployee);
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNewEmployee anp=new AddNewEmployee();
				anp.setVisible(true);
			}
		});
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.setBounds(161, 128, 154, 36);
		contentPane.add(btnRemoveEmployee);
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveEmployee re=new RemoveEmployee();
				re.setVisible(true);
			}
		});
		
		JLabel lblEmployeeActivity = new JLabel("Employee Activity");
		lblEmployeeActivity.setBounds(178, 13, 138, 23);
		contentPane.add(lblEmployeeActivity);
		
		JButton btnAllEmployeeInfo = new JButton("All Employee Info");
		btnAllEmployeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SqlOperations so=new SqlOperations();
				so.getAllEmployeeInfo();
			}
		});
		btnAllEmployeeInfo.setBounds(161, 187, 154, 36);
		contentPane.add(btnAllEmployeeInfo);
	}
}
