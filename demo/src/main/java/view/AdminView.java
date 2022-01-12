package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.example.controllers.JPAMainController;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import view.AdminViews.*;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminView extends JFrame {

	private JPanel contentPane;
	private JPAMainController mainController;
	private static AdminView frame = new AdminView();

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
	public AdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		mainController = new JPAMainController();
		
		JButton EditSmButton = new JButton("Edit salesman");
		sl_contentPane.putConstraint(SpringLayout.WEST, EditSmButton, 118, SpringLayout.WEST, contentPane);
		EditSmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AdminEditSm saleframe = new AdminEditSm();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(EditSmButton);
		
		JButton EditProdButton = new JButton("Edit products");
		sl_contentPane.putConstraint(SpringLayout.WEST, EditProdButton, 118, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, EditProdButton, -90, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, EditProdButton, -171, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, EditSmButton, 19, SpringLayout.SOUTH, EditProdButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, EditSmButton, 0, SpringLayout.EAST, EditProdButton);
		EditProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AdminEditPerfume saleframe = new AdminEditPerfume();
					frame.setVisible(false);
					saleframe.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(EditProdButton);
		
		JButton seeSalesmanButton = new JButton("See salesman sales");
		sl_contentPane.putConstraint(SpringLayout.WEST, seeSalesmanButton, 118, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, seeSalesmanButton, -18, SpringLayout.NORTH, EditProdButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, seeSalesmanButton, -171, SpringLayout.EAST, contentPane);
		seeSalesmanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(seeSalesmanButton);
		
		
		JButton seePeriodButton = new JButton("See periods sales");
		sl_contentPane.putConstraint(SpringLayout.WEST, seePeriodButton, 118, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, seePeriodButton, -17, SpringLayout.NORTH, seeSalesmanButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, seePeriodButton, -171, SpringLayout.EAST, contentPane);
		seeSalesmanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(seePeriodButton);
	}
	
	

}
