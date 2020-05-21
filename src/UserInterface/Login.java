package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOs.ExecutiveDAO;
import DAOs.MemberDAO;
import Executive.Executive;
import Club.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private ExecutiveDAO executiveDAO;
	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Login frame = new Login();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Login(ExecutiveDAO executiveDAO) {
		this.executiveDAO = executiveDAO;
				
		setTitle("UWI ASMS Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UWI ASMS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(120, 35, 190, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(101, 111, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(203, 108, 126, 20);
		contentPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get last name from lastNameTextField
				// Get password from passwordTextField
				
				// Call ExecutiveDAO and get executive with matching credentials
								
				try {
					
					String lastName = lastNameTextField.getText();
					char[] passwordData = passwordTextField.getPassword();
					String password = new String(passwordData);
					
					if (lastName != null && lastName.trim().length() > 0 && password != null && password.trim().length() > 0) {
						Executive e = executiveDAO.login(lastName, password);
						
						if (e != null) {
							Login.this.setVisible(false);
							
							// Should open the home page
							SearchMember sm = new SearchMember(); 
							sm.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(Login.this, "Error: Could not sign in with those credentials", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(Login.this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		login.setBounds(163, 193, 89, 23);
		contentPane.add(login);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(101, 147, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(203, 139, 126, 20);
		contentPane.add(passwordTextField);
	}
}
