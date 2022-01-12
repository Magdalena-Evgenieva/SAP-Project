package view.SalesmanViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.ClientMethods;

import com.example.Methods.SalesmanMethods;
import com.example.models.Client;
import com.example.models.Salesman;

import view.AdminViews.UpdateSalesman;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateClient extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField addressText;
	private JTextField telephoneText;
	private static CreateClient frame = new CreateClient();

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
	public CreateClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 52, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		nameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameText, 68, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, nameText, 74, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, nameText);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telephone");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 40, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		addressText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, addressText, 31, SpringLayout.SOUTH, nameText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, addressText);
		sl_contentPane.putConstraint(SpringLayout.WEST, addressText, 0, SpringLayout.WEST, nameText);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		telephoneText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, telephoneText, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, telephoneText, 0, SpringLayout.EAST, nameText);
		contentPane.add(telephoneText);
		telephoneText.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, nameText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Client a = ClientMethods.createClient(nameText.getText(), addressText.getText(), telephoneText.getText());
					ClientMethods.insertClient(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Create Client");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 118, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -27, SpringLayout.NORTH, nameText);
		contentPane.add(lblNewLabel_3);
		
//		JButton btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					SalesmanEditClients saleframe = new SalesmanEditClients();
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
