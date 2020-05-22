package UserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.*;
import DAOs.MemberDAO;
import Club.Member;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ClubUI {
	
	private MemberDAO memberDAO;

	private JFrame frmUwiAsms;
	private JLayeredPane layeredPane;
	private JTextField lastNameTextField;
	private JPasswordField passwordField;
	private JPanel login;
	private JPanel home;
	private JPanel addMemberMenuItemPanel;
	private JPanel editMemberMenuItemPanel;
	private JPanel viewMemberMenuItemPanel;
	private JPanel removeMemberMenuItemPanel;
	private JPanel awardPointsMenuItemPanel;
	private JPanel addEventMenuItemPanel;
	private JPanel editEventMenuItemPanel;
	private JPanel viewEventMenuItemPanel;
	private JPanel removeEventMenuItemPanel;
	private JPanel addMemberPanel;
	private JPanel editMemberPanel;
	private JPanel viewMemberPanel;
	private JPanel removeMemberPanel;
	private JPanel awardPointsPanel;
	private JPanel addEventPanel;
	private JPanel editEventPanel;
	private JPanel viewEventPanel;
	private JPanel removeEventPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField textField;
	private JTextField memberIDTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubUI window = new ClubUI();
					window.frmUwiAsms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClubUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create the DAO
		try {
			memberDAO = new MemberDAO();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmUwiAsms, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
				
		frmUwiAsms = new JFrame();
		frmUwiAsms.setTitle("UWI ASMS");
		frmUwiAsms.setBounds(100, 100, 1280, 850);
		frmUwiAsms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUwiAsms.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1264, 811);
		frmUwiAsms.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		login = new JPanel();
		layeredPane.add(login, "name_113482037570700");
		login.setLayout(null);
		
		JLabel headLabel = new JLabel("UWI Actuarial Society Management System");
		headLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		headLabel.setBounds(246, 210, 812, 120);
		login.add(headLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lastNameLabel.setBounds(440, 511, 83, 14);
		login.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(551, 504, 205, 29);
		login.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(477, 562, 46, 14);
		login.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(551, 555, 205, 29);
		login.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
			}
		});
		loginButton.setBounds(596, 653, 89, 23);
		login.add(loginButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(596, 687, 89, 23);
		login.add(exitButton);
		
		home = new JPanel();
		home.setLayout(null);
		layeredPane.add(home, "name_116330402761400");
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBackground(new Color(0, 51, 153));
		menuPanel.setBounds(0, 0, 223, 811);
		home.add(menuPanel);
		
		addMemberMenuItemPanel = new JPanel();
		addMemberMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		addMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		addMemberMenuItemPanel.setBounds(0, 200, 223, 33);
		menuPanel.add(addMemberMenuItemPanel);
		
		JLabel addMemberLabel = new JLabel("Add Member");
		addMemberLabel.setForeground(new Color(255, 255, 255));
		addMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMemberMenuItemPanel.add(addMemberLabel);
		
		editMemberMenuItemPanel = new JPanel();
		editMemberMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		editMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		editMemberMenuItemPanel.setBounds(0, 233, 223, 33);
		menuPanel.add(editMemberMenuItemPanel);
		
		JLabel editMemberLabel = new JLabel("Edit Member");
		editMemberLabel.setForeground(new Color(255, 255, 255));
		editMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editMemberMenuItemPanel.add(editMemberLabel);
		
		viewMemberMenuItemPanel = new JPanel();
		viewMemberMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		viewMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		viewMemberMenuItemPanel.setBounds(0, 265, 223, 33);
		menuPanel.add(viewMemberMenuItemPanel);
		
		JLabel viewMemberLabel = new JLabel("View Member");
		viewMemberLabel.setForeground(new Color(255, 255, 255));
		viewMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		viewMemberMenuItemPanel.add(viewMemberLabel);
		
		removeMemberMenuItemPanel = new JPanel();
		removeMemberMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		removeMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		removeMemberMenuItemPanel.setBounds(0, 298, 223, 33);
		menuPanel.add(removeMemberMenuItemPanel);
		
		JLabel removeMemberLabel = new JLabel("Remove Member");
		removeMemberLabel.setForeground(new Color(255, 255, 255));
		removeMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		removeMemberMenuItemPanel.add(removeMemberLabel);
		
		JLabel executiveLabel = new JLabel("Welcome Executive");
		executiveLabel.setForeground(Color.WHITE);
		executiveLabel.setBounds(47, 82, 109, 14);
		menuPanel.add(executiveLabel);
		
		awardPointsMenuItemPanel = new JPanel();
		awardPointsMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		awardPointsMenuItemPanel.setBackground(new Color(0, 51, 153));
		awardPointsMenuItemPanel.setBounds(0, 363, 223, 33);
		menuPanel.add(awardPointsMenuItemPanel);
		
		JLabel awardPointsLabel = new JLabel("Award Points");
		awardPointsLabel.setForeground(new Color(255, 255, 255));
		awardPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		awardPointsMenuItemPanel.add(awardPointsLabel);
		
		addEventMenuItemPanel = new JPanel();
		addEventMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		addEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		addEventMenuItemPanel.setBounds(0, 431, 223, 33);
		menuPanel.add(addEventMenuItemPanel);
		
		JLabel addEventLabel = new JLabel("Add Event");
		addEventLabel.setForeground(new Color(255, 255, 255));
		addEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addEventMenuItemPanel.add(addEventLabel);
		
		editEventMenuItemPanel = new JPanel();
		editEventMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		editEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		editEventMenuItemPanel.setBounds(0, 464, 223, 33);
		menuPanel.add(editEventMenuItemPanel);
		
		JLabel editEventLabel = new JLabel("Edit Event");
		editEventLabel.setForeground(new Color(255, 255, 255));
		editEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editEventMenuItemPanel.add(editEventLabel);
		
		viewEventMenuItemPanel = new JPanel();
		viewEventMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		viewEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		viewEventMenuItemPanel.setBounds(0, 497, 223, 33);
		menuPanel.add(viewEventMenuItemPanel);
		
		JLabel viewEventLabel = new JLabel("View Event");
		viewEventLabel.setForeground(new Color(255, 255, 255));
		viewEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		viewEventMenuItemPanel.add(viewEventLabel);
		
		removeEventMenuItemPanel = new JPanel();
		removeEventMenuItemPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuItemMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuItemMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuItemMouseClicked(e);
			}
		});
		removeEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		removeEventMenuItemPanel.setBounds(0, 527, 223, 33);
		menuPanel.add(removeEventMenuItemPanel);
		
		JLabel removeEventLabel = new JLabel("Remove Event");
		removeEventLabel.setForeground(new Color(255, 255, 255));
		removeEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		removeEventMenuItemPanel.add(removeEventLabel);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(login);
			}
		});
		logoutButton.setBounds(67, 717, 89, 23);
		menuPanel.add(logoutButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.setBounds(67, 665, 89, 23);
		menuPanel.add(settingsButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(222, 0, 1042, 811);
		home.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		addMemberPanel = new JPanel();
		mainPanel.add(addMemberPanel, "name_2515850684900");
		
		lblNewLabel = new JLabel("addM");
		addMemberPanel.add(lblNewLabel);
		
		editMemberPanel = new JPanel();
		mainPanel.add(editMemberPanel, "name_2538146867000");
		
		lblNewLabel_1 = new JLabel("editM");
		editMemberPanel.add(lblNewLabel_1);
		
		viewMemberPanel = new JPanel();
		mainPanel.add(viewMemberPanel, "name_2576426576000");
		viewMemberPanel.setLayout(null);
		
		JLabel enterLastNameLabel = new JLabel("Enter member last name");
		enterLastNameLabel.setBounds(50, 47, 153, 14);
		viewMemberPanel.add(enterLastNameLabel);
		
		textField = new JTextField();
		textField.setBounds(214, 44, 145, 20);
		viewMemberPanel.add(textField);
		textField.setColumns(10);
		
		JLabel enterMemberIDLabel = new JLabel("Enter member ID #");
		enterMemberIDLabel.setBounds(483, 47, 117, 14);
		viewMemberPanel.add(enterMemberIDLabel);
		
		memberIDTextField = new JTextField();
		memberIDTextField.setBounds(613, 44, 140, 20);
		viewMemberPanel.add(memberIDTextField);
		memberIDTextField.setColumns(10);
		
		Button searchButton = new Button("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get last name from lastNameTextField
				
				// Call MemberDAO and get members for the last name
				
				// If last name is empty, then get member id from idNumTextField
				
				// Print out members
				
				try {
					String lastName = lastNameTextField.getText();
					String id = memberIDTextField.getText();
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
					JOptionPane.showMessageDialog(viewMemberPanel, "Error: Please enter a valid member ID", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(viewMemberPanel, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		searchButton.setBounds(919, 39, 70, 22);
		viewMemberPanel.add(searchButton);
		
		JScrollPane memberScrollPane = new JScrollPane();
		memberScrollPane.setBounds(50, 107, 939, 693);
		viewMemberPanel.add(memberScrollPane);
		
		table = new JTable();
		memberScrollPane.setViewportView(table);
		
		removeMemberPanel = new JPanel();
		mainPanel.add(removeMemberPanel, "name_2586071427900");
		
		lblNewLabel_3 = new JLabel("removeM");
		removeMemberPanel.add(lblNewLabel_3);
		
		awardPointsPanel = new JPanel();
		mainPanel.add(awardPointsPanel, "name_2596164039100");
		
		lblNewLabel_4 = new JLabel("awardP");
		awardPointsPanel.add(lblNewLabel_4);
		
		addEventPanel = new JPanel();
		mainPanel.add(addEventPanel, "name_2615670923000");
		
		lblNewLabel_5 = new JLabel("addE");
		addEventPanel.add(lblNewLabel_5);
		
		editEventPanel = new JPanel();
		mainPanel.add(editEventPanel, "name_5737269473600");
		
		lblNewLabel_6 = new JLabel("editE");
		editEventPanel.add(lblNewLabel_6);
		
		viewEventPanel = new JPanel();
		mainPanel.add(viewEventPanel, "name_5763784440500");
		
		lblNewLabel_7 = new JLabel("viewE");
		viewEventPanel.add(lblNewLabel_7);
		
		removeEventPanel = new JPanel();
		mainPanel.add(removeEventPanel, "name_5767557473100");
		
		lblNewLabel_8 = new JLabel("removeE");
		removeEventPanel.add(lblNewLabel_8);
	}
	
	
	private void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private void menuItemMouseClicked(java.awt.event.MouseEvent event) {
		
		if (event.getSource() == addMemberMenuItemPanel) {
			addMemberPanel.setVisible(true);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == editMemberMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(true);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == viewMemberMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(true);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == removeMemberMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(true);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == awardPointsMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(true);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == addEventMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(true);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == editEventMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(true);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == viewEventMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(true);
			removeEventPanel.setVisible(false);
			
		}
		
		if (event.getSource() == removeEventMenuItemPanel) {
			addMemberPanel.setVisible(false);
			editMemberPanel.setVisible(false);
			viewMemberPanel.setVisible(false);
			removeMemberPanel.setVisible(false);
			awardPointsPanel.setVisible(false);
			addEventPanel.setVisible(false);
			editEventPanel.setVisible(false);
			viewEventPanel.setVisible(false);
			removeEventPanel.setVisible(true);
			
		}
		
	}
	
	private void menuItemMouseEntered(java.awt.event.MouseEvent event) {
		
		if (event.getSource() == addMemberMenuItemPanel) {
			addMemberMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == editMemberMenuItemPanel) {
			editMemberMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == viewMemberMenuItemPanel) {
			viewMemberMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == removeMemberMenuItemPanel) {
			removeMemberMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == awardPointsMenuItemPanel) {
			awardPointsMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == addEventMenuItemPanel) {
			addEventMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == editEventMenuItemPanel) {
			editEventMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == viewEventMenuItemPanel) {
			viewEventMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
		
		if (event.getSource() == removeEventMenuItemPanel) {
			removeEventMenuItemPanel.setBackground(new Color(135, 135, 135));
		}
	}

	private void menuItemMouseExited(java.awt.event.MouseEvent event) {
		
		if (event.getSource() == addMemberMenuItemPanel) {
			addMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == editMemberMenuItemPanel) {
			editMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == viewMemberMenuItemPanel) {
			viewMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == removeMemberMenuItemPanel) {
			removeMemberMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == awardPointsMenuItemPanel) {
			awardPointsMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == addEventMenuItemPanel) {
			addEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == editEventMenuItemPanel) {
			editEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == viewEventMenuItemPanel) {
			viewEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
		
		if (event.getSource() == removeEventMenuItemPanel) {
			removeEventMenuItemPanel.setBackground(new Color(0, 51, 153));
		}
	}
}
