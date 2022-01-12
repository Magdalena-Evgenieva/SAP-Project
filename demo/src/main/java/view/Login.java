package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import utils.exceptions.UnsuccessfulLoginException;
import com.example.controllers.*;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passField;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPAMainController mainController;
	static  Login frame = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, layeredPane, -21, SpringLayout.SOUTH, contentPane);
		contentPane.setLayout(sl_contentPane);
		
	
		
		JLabel lblNewLabel = new JLabel("Username");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 34, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 54, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		userField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, userField, 48, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, userField, 0, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 31, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		passField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passField, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, passField, 0, SpringLayout.WEST, userField);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Select type user ");
		sl_contentPane.putConstraint(SpringLayout.EAST, layeredPane, 0, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 32, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Administator");
		comboBox.addItem("Salesman");
		comboBox.setSelectedItem(null);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, userField);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 96, SpringLayout.WEST, userField);
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		contentPane.add(layeredPane);
		
		mainController = new JPAMainController();
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().toString().equals("Administator")){
					try {
						if (mainController.getCompanyControllers().logIn(userField.getText(), passField.getText()) == true) {
	
							try {
								AdminView adminframe = new AdminView();
								adminframe.setVisible(true);
								frame.setVisible(false);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
				 } catch (UnsuccessfulLoginException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (comboBox.getSelectedItem().toString().equals("Salesman")) {
				try {
					if (mainController.getSalesmanController().logIn(userField.getText(),
							passField.getText()) == true) {

						try {
							SalesmanView saleframe = new SalesmanView();
							saleframe.logged = mainController.getSalesmanController().findSalesman(userField.getText());
							frame.setVisible(false);
							saleframe.setVisible(true);
							

						} catch (Exception e) {
							e.printStackTrace();
						}
//					

					} else {
						JOptionPane.showMessageDialog(null, "Wrong user input", "Input Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (UnsuccessfulLoginException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -35, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, userField);
		contentPane.add(button);
	}
}
