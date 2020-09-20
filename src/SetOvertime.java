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

public class SetOvertime extends JFrame {

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
					SetOvertime frame = new SetOvertime();
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
	public SetOvertime() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetOnesOvertime = new JLabel("Set one's Overtime period");
		lblSetOnesOvertime.setBounds(120, 13, 191, 21);
		contentPane.add(lblSetOnesOvertime);
		
		textField = new JTextField();
		textField.setBounds(198, 75, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 138, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(100, 78, 86, 16);
		contentPane.add(lblEmployeeId);
		
		JLabel lblOvertimeHour = new JLabel("Overtime Hour");
		lblOvertimeHour.setBounds(97, 141, 86, 16);
		contentPane.add(lblOvertimeHour);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlOperations so=new SqlOperations();
				so.setOvertimeHour(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnSave.setBounds(270, 196, 97, 25);
		contentPane.add(btnSave);
	}

}
