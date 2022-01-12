package view.SalesmanViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Methods.SaleMethods;
import com.example.models.Sale;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateSale extends JFrame {

	private JPanel contentPane;
	private JTextField salesmanText;
	private JTextField clientText;
	private JTextField perfNameText;
	private JTextField quanText;
	private JTextField perfGenText;
	private JTextField dateText;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JLabel lblNewLabel_7;
	private JTextField perfSizeText;
	private static UpdateSale frame = new UpdateSale();


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
	public UpdateSale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 53, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 62, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Client");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Perfume name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 67, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Perfume gender");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_5);
		
		salesmanText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, salesmanText, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, salesmanText, 60, SpringLayout.EAST, lblNewLabel);
		contentPane.add(salesmanText);
		salesmanText.setColumns(10);
		
		clientText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, clientText, 16, SpringLayout.SOUTH, salesmanText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, clientText);
		sl_contentPane.putConstraint(SpringLayout.WEST, clientText, 0, SpringLayout.WEST, salesmanText);
		contentPane.add(clientText);
		clientText.setColumns(10);
		
		perfNameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfNameText, 14, SpringLayout.SOUTH, clientText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, perfNameText);
		sl_contentPane.putConstraint(SpringLayout.WEST, perfNameText, 0, SpringLayout.WEST, salesmanText);
		contentPane.add(perfNameText);
		perfNameText.setColumns(10);
		
		quanText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, quanText);
		sl_contentPane.putConstraint(SpringLayout.EAST, quanText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(quanText);
		quanText.setColumns(10);
		
		perfGenText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, perfGenText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfGenText, 10, SpringLayout.SOUTH, perfNameText);
		sl_contentPane.putConstraint(SpringLayout.EAST, perfGenText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(perfGenText);
		perfGenText.setColumns(10);
		
		dateText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, quanText, -6, SpringLayout.NORTH, dateText);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, dateText, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, dateText);
		sl_contentPane.putConstraint(SpringLayout.EAST, dateText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(dateText);
		dateText.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Update Sale");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 143, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton = new JButton("update");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -2, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -37, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Sale a = SaleMethods.createSale(salesmanText.getText(), clientText.getText(), perfNameText.getText(), perfGenText.getText(), perfSizeText.getText(), Integer.parseInt(quanText.getText()), dateText.getText());
					SaleMethods.insertSale(a);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		lblNewLabel_7 = new JLabel("Perfume size");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_7);
		
		perfSizeText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfSizeText, 6, SpringLayout.SOUTH, perfGenText);
		sl_contentPane.putConstraint(SpringLayout.WEST, perfSizeText, 0, SpringLayout.WEST, salesmanText);
		contentPane.add(perfSizeText);
		perfSizeText.setColumns(10);
	}

}
