package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.example.Methods.PerfumeMethods;
import com.example.controllers.JPAMainController;
import com.example.models.Perfume;

public class CreatePerfume extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField gendertext;
	private JTextField brandtext;
	private JTextField sizetext;
	private JTextField senstext;
	private JTextField dectext;
	private JTextField pricetext;
	private JTextField quantext;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private static CreatePerfume frame = new CreatePerfume();
	private JPAMainController mainController;
	private PerfumeMethods methods;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePerfume frame = new CreatePerfume();
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
	public CreatePerfume() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Add perfume");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 174, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 88, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -204, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_1);
		
		nametext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nametext, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, nametext, -62, SpringLayout.EAST, contentPane);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		gendertext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, gendertext);
		sl_contentPane.putConstraint(SpringLayout.NORTH, gendertext, 6, SpringLayout.SOUTH, nametext);
		sl_contentPane.putConstraint(SpringLayout.WEST, gendertext, 0, SpringLayout.WEST, nametext);
		contentPane.add(gendertext);
		gendertext.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Brand");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
		brandtext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, brandtext);
		sl_contentPane.putConstraint(SpringLayout.NORTH, brandtext, 6, SpringLayout.SOUTH, gendertext);
		sl_contentPane.putConstraint(SpringLayout.EAST, brandtext, 0, SpringLayout.EAST, nametext);
		contentPane.add(brandtext);
		brandtext.setColumns(10);
		
		sizetext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sizetext, 6, SpringLayout.SOUTH, brandtext);
		sl_contentPane.putConstraint(SpringLayout.WEST, sizetext, 0, SpringLayout.WEST, nametext);
		contentPane.add(sizetext);
		sizetext.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Size");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, sizetext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_4);
		
		senstext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, senstext, 6, SpringLayout.SOUTH, sizetext);
		sl_contentPane.putConstraint(SpringLayout.EAST, senstext, 0, SpringLayout.EAST, nametext);
		contentPane.add(senstext);
		senstext.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Type sense ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, senstext);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_5);
		
		dectext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dectext, 6, SpringLayout.SOUTH, senstext);
		sl_contentPane.putConstraint(SpringLayout.EAST, dectext, 0, SpringLayout.EAST, nametext);
		contentPane.add(dectext);
		dectext.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Description");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 3, SpringLayout.NORTH, dectext);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_6);
		
		pricetext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, pricetext, 6, SpringLayout.SOUTH, dectext);
		sl_contentPane.putConstraint(SpringLayout.WEST, pricetext, 0, SpringLayout.WEST, nametext);
		contentPane.add(pricetext);
		pricetext.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 3, SpringLayout.NORTH, pricetext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_7, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_7);
		
		quantext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, quantext, 6, SpringLayout.SOUTH, pricetext);
		sl_contentPane.putConstraint(SpringLayout.EAST, quantext, 0, SpringLayout.EAST, nametext);
		contentPane.add(quantext);
		quantext.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Quantity");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 3, SpringLayout.NORTH, quantext);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_8);
		
		btnNewButton = new JButton("Add");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, nametext);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Perfume a = methods.createPerfume( nametext.getText(),gendertext.getText(),brandtext.getText(), sizetext.getText(), senstext.getText() ,dectext.getText() , Integer.parseInt(pricetext.getText()), Integer.parseInt(quantext.getText()));
					methods.insertPerfume(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
//		btnNewButton_1 = new JButton("Back ");
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
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
