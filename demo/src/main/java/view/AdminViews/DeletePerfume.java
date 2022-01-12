package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.models.Perfume;

import utils.exceptions.EntityDoesNotExistException;

import com.example.Methods.PerfumeMethods;
import com.example.controllers.PerfumeController;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeletePerfume extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField sizetext;
	private JTextField gendertext;
	private static DeletePerfume frame = new DeletePerfume();
	private PerfumeMethods methods;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePerfume frame = new DeletePerfume();
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
	public DeletePerfume() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Delete perfume");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 89, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 72, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 56, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 36, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 38, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
		nametext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, nametext, 57, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nametext, 0, SpringLayout.SOUTH, lblNewLabel_1);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		sizetext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sizetext, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, sizetext, 0, SpringLayout.WEST, nametext);
		contentPane.add(sizetext);
		sizetext.setColumns(10);
		
		gendertext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, gendertext, 0, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, gendertext, 0, SpringLayout.EAST, nametext);
		contentPane.add(gendertext);
		gendertext.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 166, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					methods.deletePerfume(nametext.getText(),gendertext.getText(),sizetext.getText() );

				} 
				catch (EntityDoesNotExistException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					AdminEditPerfume saleframe = new AdminEditPerfume();
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
