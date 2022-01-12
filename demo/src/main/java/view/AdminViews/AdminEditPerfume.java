package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.AdminView;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminEditPerfume extends JFrame {

	private JPanel contentPane;
	private static  AdminEditPerfume frame = new AdminEditPerfume();

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
	public  AdminEditPerfume() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton createPerfumeButton = new JButton("Create Perfume");
		sl_contentPane.putConstraint(SpringLayout.NORTH, createPerfumeButton, 65, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, createPerfumeButton, 149, SpringLayout.WEST, contentPane);
		createPerfumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreatePerfume saleframe = new CreatePerfume();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(createPerfumeButton);
		
		JButton deletePerfumeButton = new JButton("Delete Perfume ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, deletePerfumeButton, 29, SpringLayout.SOUTH, createPerfumeButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, deletePerfumeButton, 0, SpringLayout.EAST, createPerfumeButton);
		deletePerfumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DeletePerfume saleframe = new DeletePerfume();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(deletePerfumeButton);
		
		JButton updatePerfumeButton = new JButton("Update Perfume");
		updatePerfumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UpdatePerfume updateframe = new UpdatePerfume();
					frame.setVisible(false);
					updateframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, updatePerfumeButton, 23, SpringLayout.SOUTH, deletePerfumeButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, updatePerfumeButton, 0, SpringLayout.WEST, createPerfumeButton);
		contentPane.add(updatePerfumeButton);
		
//		JButton btnNewButton = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -88, SpringLayout.EAST, contentPane);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					
//					AdminView saleframe = new AdminView();
//					
//					saleframe.setVisible(true);
//					frame.dispose();
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
