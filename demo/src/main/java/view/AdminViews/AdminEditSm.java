package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.AdminView;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AdminEditSm extends JFrame {

	private JPanel contentPane;
	private static AdminEditSm frame = new AdminEditSm();

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
	public AdminEditSm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton ceateSalesmanButton = new JButton("Create Salesman");
		sl_contentPane.putConstraint(SpringLayout.EAST, ceateSalesmanButton, -150, SpringLayout.EAST, contentPane);
		ceateSalesmanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateSalesman saleframe = new CreateSalesman();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(ceateSalesmanButton);
		
		JButton deleteSalesmanButton = new JButton("Delete Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, deleteSalesmanButton, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, deleteSalesmanButton, 111, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, deleteSalesmanButton, -150, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, ceateSalesmanButton, 0, SpringLayout.WEST, deleteSalesmanButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ceateSalesmanButton, -13, SpringLayout.NORTH, deleteSalesmanButton);
		deleteSalesmanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DeleteSalesman saleframe = new DeleteSalesman();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(deleteSalesmanButton);
		
		JButton updateSalesmanInfo = new JButton("Update Salesman information");
		sl_contentPane.putConstraint(SpringLayout.NORTH, updateSalesmanInfo, 10, SpringLayout.SOUTH, deleteSalesmanButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, updateSalesmanInfo, 0, SpringLayout.EAST, ceateSalesmanButton);
		updateSalesmanInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UpdateSalesman saleframe = new UpdateSalesman();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(updateSalesmanInfo);
		
//		JButton Back = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.WEST, Back, 26, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, Back, -10, SpringLayout.SOUTH, contentPane);
//		Back.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					AdminView saleframe = new AdminView();
//					frame.setVisible(false);
//					saleframe.setVisible(true);
//					
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		contentPane.add(Back);
	}

}
