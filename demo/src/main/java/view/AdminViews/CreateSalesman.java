package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.SalesmanMethods;
import com.example.models.Salesman;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CreateSalesman extends JFrame {

	private JPanel contentPane;
	private JTextField UsernameText;
	private JTextField emailText;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JTextField salesmanClientText;
	private JButton btnNewButton_1;
	private static CreateSalesman frame = new CreateSalesman();
	private JLabel lblNewLabel_4;
	private JTextField passwordText;
	private JLabel lblNewLabel_5;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSalesman frame = new CreateSalesman();
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
	public CreateSalesman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		UsernameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, UsernameText, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, UsernameText, -113, SpringLayout.EAST, contentPane);
		contentPane.add(UsernameText);
		UsernameText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 56, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, UsernameText);
		contentPane.add(lblNewLabel);
		
		emailText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailText, 29, SpringLayout.SOUTH, UsernameText);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailText, 0, SpringLayout.WEST, UsernameText);
		contentPane.add(emailText);
		emailText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, emailText);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 150, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("Add");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, UsernameText);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -28, SpringLayout.SOUTH, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Salesman a = SalesmanMethods.createSalesman( nameText.getText(),emailText.getText(),passwordText.getText(), UsernameText.getText(), salesmanClientText.getText() );
					SalesmanMethods.insertSalesman(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Salesman Client");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_3);
		
		salesmanClientText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, salesmanClientText, 0, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, salesmanClientText, 0, SpringLayout.WEST, UsernameText);
		contentPane.add(salesmanClientText);
		salesmanClientText.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -6, SpringLayout.NORTH, lblNewLabel_1);
		contentPane.add(lblNewLabel_4);
		
		passwordText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordText, 6, SpringLayout.SOUTH, UsernameText);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordText, 0, SpringLayout.WEST, UsernameText);
		contentPane.add(passwordText);
		passwordText.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 17, SpringLayout.SOUTH, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_5);
		
		nameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameText, 6, SpringLayout.SOUTH, emailText);
		sl_contentPane.putConstraint(SpringLayout.EAST, nameText, 0, SpringLayout.EAST, UsernameText);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
//		btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, contentPane);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					frame.setVisible(false);
//					AdminEditSm saleframe = new AdminEditSm();
//					saleframe.setVisible(true);
//					
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		contentPane.add(btnNewButton_1);
	}

}
