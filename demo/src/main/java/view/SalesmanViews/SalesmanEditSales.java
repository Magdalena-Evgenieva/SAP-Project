package view.SalesmanViews;

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

public class SalesmanEditSales extends JFrame {

	private JPanel contentPane;
	private static SalesmanEditSales frame = new SalesmanEditSales();

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
	public SalesmanEditSales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton createSaleButton = new JButton("Create Sale");
		sl_contentPane.putConstraint(SpringLayout.NORTH, createSaleButton, 75, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, createSaleButton, -170, SpringLayout.EAST, contentPane);
		createSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateSale saleframe = new CreateSale();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(createSaleButton);
		
		JButton deleteSaleButton = new JButton("Delete Sale");
		sl_contentPane.putConstraint(SpringLayout.NORTH, deleteSaleButton, 44, SpringLayout.SOUTH, createSaleButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, deleteSaleButton, 0, SpringLayout.EAST, createSaleButton);
		deleteSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DeleteSale saleframe = new DeleteSale();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(deleteSaleButton);
		
		JButton updateSaleButton = new JButton("Update Sale");
		sl_contentPane.putConstraint(SpringLayout.NORTH, updateSaleButton, 33, SpringLayout.SOUTH, deleteSaleButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, updateSaleButton, 0, SpringLayout.EAST, createSaleButton);
		updateSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UpdateSale saleframe = new UpdateSale();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(updateSaleButton);
	}
}
