package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.models.Salesman;

import view.AdminViews.AdminEditPerfume;
import view.SalesmanViews.SalesmanEditClients;
import view.SalesmanViews.SalesmanEditSales;

import javax.swing.SpringLayout;
import javax.swing.JButton;

public class SalesmanView extends JFrame {

	private JPanel contentPane;
	private static SalesmanView frame = new SalesmanView();
	/**
	 * Launch the application.
	 */
	public Salesman logged;
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
	public SalesmanView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Clients");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 83, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 149, SpringLayout.WEST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SalesmanEditClients saleframe = new SalesmanEditClients();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sales");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 44, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SalesmanEditSales saleframe = new SalesmanEditSales();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
	}

}
