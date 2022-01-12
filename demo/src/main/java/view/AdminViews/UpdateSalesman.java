package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.SalesmanMethods;
import com.example.models.Perfume;
import com.example.models.Salesman;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateSalesman extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField emailText;
	private static UpdateSalesman frame = new UpdateSalesman();
	private JTextField clientText;
	private JTextField nameText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSalesman frame = new UpdateSalesman();
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
	public UpdateSalesman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Update Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 163, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		usernameText = new JTextField();
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		emailText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, emailText, -106, SpringLayout.EAST, contentPane);
		contentPane.add(emailText);
		emailText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username(cant be changed, used for search)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 42, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, usernameText, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, usernameText, 10, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 70, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Update");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -36, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -105, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Salesman a = SalesmanMethods.createSalesman( nameText.getText(),emailText.getText(),passwordText.getText(), usernameText.getText(), clientText.getText() );
					SalesmanMethods.updateSalesman(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Client addres");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
		clientText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, clientText, -106, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 12, SpringLayout.SOUTH, clientText);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -39, SpringLayout.WEST, clientText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, clientText, 5, SpringLayout.SOUTH, usernameText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailText, 9, SpringLayout.SOUTH, clientText);
		contentPane.add(clientText);
		clientText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 68, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_4);
		
		nameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameText, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, nameText, 0, SpringLayout.WEST, emailText);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_5);
		
		passwordText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, passwordText, -6, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordText, -106, SpringLayout.EAST, contentPane);
		contentPane.add(passwordText);
		passwordText.setColumns(10);
//		
//		JButton btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 28, SpringLayout.WEST, contentPane);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					AdminEditSm saleframe = new AdminEditSm();
//					frame.setVisible(false);
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
