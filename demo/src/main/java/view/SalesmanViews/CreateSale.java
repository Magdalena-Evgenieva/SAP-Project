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
import com.example.models.Client;
import com.example.models.Sale;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateSale extends JFrame {

	private JPanel contentPane;
	private JTextField salesmanText;
	private JTextField clientText;
	private JTextField perfNameText;
	private JTextField quanText;
	private JTextField perfGenText;
	private JTextField dateText;
	private JButton btnNewButton;
	private JTextField perfSizeText;
	private JLabel lblNewLabel_7;
	private static CreateSale frame = new CreateSale();
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
	public CreateSale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Salesman");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 53, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 60, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		salesmanText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, salesmanText, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, salesmanText, 87, SpringLayout.EAST, lblNewLabel);
		contentPane.add(salesmanText);
		salesmanText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Client addres");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		clientText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, clientText, 20, SpringLayout.SOUTH, salesmanText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, clientText);
		sl_contentPane.putConstraint(SpringLayout.EAST, clientText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(clientText);
		clientText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Perfume name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 38, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		perfNameText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfNameText, 6, SpringLayout.SOUTH, clientText);
		sl_contentPane.putConstraint(SpringLayout.EAST, perfNameText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(perfNameText);
		perfNameText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 54, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		quanText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, quanText);
		sl_contentPane.putConstraint(SpringLayout.WEST, quanText, 0, SpringLayout.WEST, salesmanText);
		contentPane.add(quanText);
		quanText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Perfume gender");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_2);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date(\"yyyy-MM-dd\")");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 19, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 121, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_5);
		
		perfGenText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfGenText, 9, SpringLayout.SOUTH, perfNameText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, perfGenText);
		sl_contentPane.putConstraint(SpringLayout.WEST, perfGenText, 0, SpringLayout.WEST, salesmanText);
		contentPane.add(perfGenText);
		perfGenText.setColumns(10);
		
		dateText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dateText, 230, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, quanText, -3, SpringLayout.NORTH, dateText);
		sl_contentPane.putConstraint(SpringLayout.EAST, dateText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(dateText);
		dateText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Create Sale");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 137, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton = new JButton("Add");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 19, SpringLayout.EAST, dateText);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -2, SpringLayout.SOUTH, contentPane);
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
		
		perfSizeText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfSizeText, 6, SpringLayout.SOUTH, perfGenText);
		sl_contentPane.putConstraint(SpringLayout.EAST, perfSizeText, 0, SpringLayout.EAST, salesmanText);
		contentPane.add(perfSizeText);
		perfSizeText.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Perfume size");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 3, SpringLayout.NORTH, perfSizeText);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_7);
	}

}
