package view.SalesmanViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.SalesmanView;
import view.AdminViews.AdminEditSm;
import view.AdminViews.UpdatePerfume;

import javax.swing.SpringLayout;
import javax.swing.JButton;

public class SalesmanEditClients extends JFrame {

	private JPanel contentPane;
	private static  SalesmanEditClients frame = new SalesmanEditClients();

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
	public SalesmanEditClients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton createClientButton = new JButton("Create Client");
		sl_contentPane.putConstraint(SpringLayout.NORTH, createClientButton, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, createClientButton, 156, SpringLayout.WEST, contentPane);
		createClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateClient saleframe = new CreateClient();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(createClientButton);
		
		JButton deleteClientButton = new JButton("Delete Client");
		sl_contentPane.putConstraint(SpringLayout.NORTH, deleteClientButton, 40, SpringLayout.SOUTH, createClientButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, deleteClientButton, 0, SpringLayout.WEST, createClientButton);
		deleteClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DeleteClient saleframe = new DeleteClient();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(deleteClientButton);
		
		JButton updateClientButton = new JButton("Update Client");
		sl_contentPane.putConstraint(SpringLayout.WEST, updateClientButton, 0, SpringLayout.WEST, createClientButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, updateClientButton, -37, SpringLayout.SOUTH, contentPane);
		updateClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UpdateClient saleframe = new UpdateClient();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(updateClientButton);
		
//		JButton btnNewButton = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					SalesmanView saleframe = new SalesmanView();
//					frame.setVisible(false);
//					saleframe.setVisible(true);
//					
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		contentPane.add(btnNewButton);
}

}
