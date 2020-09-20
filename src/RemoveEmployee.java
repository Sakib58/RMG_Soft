import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployee frame = new RemoveEmployee();
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
	public RemoveEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(232, 101, 136, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eid=textField.getText();
				SqlOperations so=new SqlOperations();
				so.removeEmployee(eid);
				textField.setText(null);
			}
		});
		btnRemove.setBounds(286, 180, 97, 25);
		contentPane.add(btnRemove);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(120, 180, 97, 25);
		contentPane.add(btnCancel);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter employee ID");
		lblEnterEmployeeId.setBounds(85, 107, 116, 19);
		contentPane.add(lblEnterEmployeeId);
	}

}
