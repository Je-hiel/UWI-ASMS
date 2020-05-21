package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.*;
import DAOs.MemberDAO;
import Club.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class SearchMember extends JFrame {

	private JPanel contentPane;
	
	private MemberDAO memberDAO;
	private JTextField lastNameTextField;
	private JTextField idNumTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMember frame = new SearchMember();
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
	public SearchMember() {
		
		// Create the DAO
		try {
			memberDAO = new MemberDAO();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Search Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lastName = new JLabel("Enter last name");
		panel.add(lastName);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		panel.add(lastNameTextField);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JLabel id = new JLabel("Enter member ID #");
		panel.add(id);
		
		idNumTextField = new JTextField();
		idNumTextField.setColumns(10);
		panel.add(idNumTextField);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get last name from lastNameTextField
				
				// Call MemberDAO and get members for the last name
				
				// If last name is empty, then get member id from idNumTextField
				
				// Print out members
				
				try {
					String lastName = lastNameTextField.getText();
					String id = idNumTextField.getText();
					int memberID;
					
					List<Member> members = null;
					
					if (lastName != null && lastName.trim().length() > 0) {
						members = memberDAO.searchMembers(lastName);
					} else if (id.trim().length() > 0) {
						memberID = Integer.parseInt(id.trim());
						members = memberDAO.searchMembers(memberID);
					} else {
						members = memberDAO.getAllMembers();
					}
					
					
					// Create table model and update the table
					MemberTableModel model = new MemberTableModel(members);
					table.setModel(model);
					
					
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(SearchMember.this, "Error: Please enter a valid member ID", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(SearchMember.this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
