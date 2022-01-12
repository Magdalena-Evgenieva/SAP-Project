package view.SalesmanViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.ClientMethods;
import com.example.Methods.SaleMethods;
import com.example.models.Sale;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteClient extends JFrame {

	private JPanel contentPane;
	private JTextField addrText;
	private static DeleteClient frame = new DeleteClient();
	
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
	public DeleteClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Address");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 98, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 83, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		addrText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, addrText, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, addrText, 82, SpringLayout.EAST, lblNewLabel);
		contentPane.add(addrText);
		addrText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Client");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 39, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 156, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -51, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -123, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
				 ClientMethods.deleteClient(addrText.getText());
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 22, SpringLayout.WEST, contentPane);
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
