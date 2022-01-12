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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteSalesman extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private static DeleteSalesman frame = new DeleteSalesman();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSalesman frame = new DeleteSalesman();
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
	public DeleteSalesman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Delete Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 160, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 67, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 60, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		usernametext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, usernametext, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, usernametext, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(usernametext);
		usernametext.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 63, SpringLayout.SOUTH, usernametext);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -143, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					SalesmanMethods.deleteSalesman(usernametext.getText());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 36, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -38, SpringLayout.SOUTH, contentPane);
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
