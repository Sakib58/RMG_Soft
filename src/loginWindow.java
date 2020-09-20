import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;

public class loginWindow {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private Button btnCancel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private Button btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginWindow window = new loginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("RMG Management Software");
		JLabel lblAdminLogin = new JLabel("<html><span style='font-size:20px'>"+"Admin Login"+"</span></html>");
		lblAdminLogin.setBounds(321, 23, 179, 44);
		frame.getContentPane().add(lblAdminLogin);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(156, 108, 201, 32);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(156, 178, 201, 32);
		frame.getContentPane().add(pwdPassword);
		
		btnCancel = new Button("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}
		});
		btnCancel.setBounds(156, 263, 79, 24);
		frame.getContentPane().add(btnCancel);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(76, 108, 68, 32);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(76, 178, 68, 32);
		frame.getContentPane().add(lblPassword);
		
		btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=txtUsername.getText();
				String pass=pwdPassword.getText();
				if (username.equals("admin") && pass.equals("2058")) {
					//SqlOperations so=new SqlOperations();
					//so.createAllTable();
					frame.dispose();
					AllActivities ac=new AllActivities();
					ac.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Login credentials");
					txtUsername.setText(null);
					pwdPassword.setText(null);
				}
			}
		});
		btnLogin.setBounds(280, 263, 79, 24);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblWelcomeBack = new JLabel("<html><span style='font-size:30px'>"+"Welcome Back"+"</span></html>");
		lblWelcomeBack.setBounds(567, 58, 201, 190);
		frame.getContentPane().add(lblWelcomeBack);
	}
}
