package view.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.PerfumeMethods;
import com.example.models.Perfume;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdatePerfume extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField gendertext;
	private JTextField brandtext;
	private JTextField sizetext;
	private JTextField senstext;
	private JTextField desctext;
	private JTextField pricetext;
	private JTextField quantext;
	private static UpdatePerfume frame = new UpdatePerfume();
	private PerfumeMethods methods;

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
	public UpdatePerfume() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Update perfume");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 172, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name(for search don't changed)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 54, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		nametext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nametext, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, nametext, 108, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Gender(for search don't changed)");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		gendertext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, gendertext);
		sl_contentPane.putConstraint(SpringLayout.NORTH, gendertext, 6, SpringLayout.SOUTH, nametext);
		sl_contentPane.putConstraint(SpringLayout.WEST, gendertext, 0, SpringLayout.WEST, nametext);
		contentPane.add(gendertext);
		gendertext.setColumns(10);
		
		brandtext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, brandtext, 6, SpringLayout.SOUTH, gendertext);
		sl_contentPane.putConstraint(SpringLayout.EAST, brandtext, 0, SpringLayout.EAST, nametext);
		contentPane.add(brandtext);
		brandtext.setColumns(10);
		
		sizetext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sizetext, 6, SpringLayout.SOUTH, brandtext);
		sl_contentPane.putConstraint(SpringLayout.EAST, sizetext, 0, SpringLayout.EAST, nametext);
		contentPane.add(sizetext);
		sizetext.setColumns(10);
		
		senstext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, senstext, 6, SpringLayout.SOUTH, sizetext);
		sl_contentPane.putConstraint(SpringLayout.WEST, senstext, 0, SpringLayout.WEST, nametext);
		contentPane.add(senstext);
		senstext.setColumns(10);
		
		desctext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, desctext, 8, SpringLayout.SOUTH, senstext);
		sl_contentPane.putConstraint(SpringLayout.EAST, desctext, 0, SpringLayout.EAST, nametext);
		contentPane.add(desctext);
		desctext.setColumns(10);
		
		pricetext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, pricetext, 6, SpringLayout.SOUTH, desctext);
		sl_contentPane.putConstraint(SpringLayout.EAST, pricetext, 0, SpringLayout.EAST, nametext);
		contentPane.add(pricetext);
		pricetext.setColumns(10);
		
		quantext = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, quantext, 6, SpringLayout.SOUTH, pricetext);
		sl_contentPane.putConstraint(SpringLayout.WEST, quantext, 0, SpringLayout.WEST, nametext);
		contentPane.add(quantext);
		quantext.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Brand");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, brandtext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Size(for search don't changed)");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, sizetext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Type sense");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, senstext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Description");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 0, SpringLayout.SOUTH, desctext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 0, SpringLayout.SOUTH, pricetext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_7, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Quantity");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, 0, SpringLayout.SOUTH, quantext);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Update");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -127, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Perfume a = methods.createPerfume( nametext.getText(),gendertext.getText(),brandtext.getText(), sizetext.getText(), senstext.getText() ,desctext.getText() , Integer.parseInt(pricetext.getText()), Integer.parseInt(quantext.getText()));
					methods.updatePerfume(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("Back ");
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
