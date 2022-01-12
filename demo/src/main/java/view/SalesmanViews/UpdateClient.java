package view.SalesmanViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.ClientMethods;
import com.example.models.Client;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateClient extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField telephonetext;
	private JTextField addressText;
	private static UpdateClient frame = new UpdateClient();

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
	public UpdateClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Update Client");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 168, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_2);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telephone");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 107, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 64, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 21, SpringLayout.SOUTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -27, SpringLayout.NORTH, lblNewLabel_3);
		contentPane.add(lblNewLabel_3);
		
		nametext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nametext, -3, SpringLayout.NORTH, lblNewLabel_1);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		telephonetext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, telephonetext, 21, SpringLayout.SOUTH, nametext);
		sl_contentPane.putConstraint(SpringLayout.EAST, nametext, 0, SpringLayout.EAST, telephonetext);
		sl_contentPane.putConstraint(SpringLayout.WEST, telephonetext, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(telephonetext);
		telephonetext.setColumns(10);
		
		addressText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, addressText, 168, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -59, SpringLayout.WEST, addressText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, addressText, 0, SpringLayout.NORTH, lblNewLabel_2);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -35, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -122, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Client a = ClientMethods.createClient(nametext.getText(), addressText.getText(), telephonetext.getText());
					ClientMethods.updateClient(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -24, SpringLayout.SOUTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, lblNewLabel_1);
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
