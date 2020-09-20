import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetLeave extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetLeave frame = new SetLeave();
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
	public SetLeave() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLeaveActivity = new JLabel("Leave Activity");
		lblLeaveActivity.setBounds(151, 13, 134, 30);
		contentPane.add(lblLeaveActivity);
		
		JButton btnSetLeave = new JButton("Set Leave");
		btnSetLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SqlOperations so=new SqlOperations();
				String res=so.setLeave(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
				JOptionPane.showMessageDialog(null, res);
			}
		});
		btnSetLeave.setBounds(251, 167, 118, 25);
		contentPane.add(btnSetLeave);
		
		
		textField = new JTextField();
		textField.setBounds(192, 75, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 122, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(83, 78, 82, 16);
		contentPane.add(lblEmployeeId);
		
		JLabel lblNumberOfDays = new JLabel("Number of days");
		lblNumberOfDays.setBounds(71, 125, 109, 16);
		contentPane.add(lblNumberOfDays);
	}

}
