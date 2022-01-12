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

import utils.exceptions.EntityDoesNotExistException;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteSale extends JFrame {

	private JPanel contentPane;
	private JTextField dateText;
	private JTextField salesmanText;
	private JTextField perfNameText;
	private JTextField perfSizeText;
	private JButton btnNewButton;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField clientText_1;
	private JTextField perfGenText;
	private static DeleteSale frame = new DeleteSale();

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
	public DeleteSale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Date");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 56, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 50, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		dateText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dateText, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, dateText, 91, SpringLayout.EAST, lblNewLabel);
		contentPane.add(dateText);
		dateText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 16, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Client");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Perfume name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 45, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -6, SpringLayout.NORTH, lblNewLabel_3);
		contentPane.add(lblNewLabel_3);
		
		salesmanText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, salesmanText, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, salesmanText, 0, SpringLayout.WEST, dateText);
		contentPane.add(salesmanText);
		salesmanText.setColumns(10);
		
		perfNameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, perfNameText);
		sl_contentPane.putConstraint(SpringLayout.EAST, perfNameText, 0, SpringLayout.EAST, dateText);
		contentPane.add(perfNameText);
		perfNameText.setColumns(10);
		
		perfSizeText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfSizeText, 4, SpringLayout.SOUTH, perfNameText);
		sl_contentPane.putConstraint(SpringLayout.WEST, perfSizeText, 0, SpringLayout.WEST, dateText);
		contentPane.add(perfSizeText);
		perfSizeText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Delete Sale");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 136, SpringLayout.WEST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
				 SaleMethods.deleteSale( dateText.getText(), salesmanText.getText(), clientText_1.getText(), perfNameText.getText(),   perfGenText.getText(), perfSizeText.getText());
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Delete");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 110, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Perfume gender");
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Perfume Size");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 17, SpringLayout.SOUTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 3, SpringLayout.NORTH, perfSizeText);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_6);
		
		clientText_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfNameText, 5, SpringLayout.SOUTH, clientText_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, clientText_1, 6, SpringLayout.SOUTH, salesmanText);
		sl_contentPane.putConstraint(SpringLayout.EAST, clientText_1, 0, SpringLayout.EAST, dateText);
		contentPane.add(clientText_1);
		clientText_1.setColumns(10);
		
		perfGenText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfGenText, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, perfGenText, 0, SpringLayout.EAST, dateText);
		contentPane.add(perfGenText);
		perfGenText.setColumns(10);
	}

}
