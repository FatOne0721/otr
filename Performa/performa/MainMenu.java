package performa;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class MainMenu extends JFrame {
	JFrame frmMain;
	JButton btnViewTrucks;
	JPasswordField txtPassword;
	JTextField txtUser;
	JComboBox<String> cmboProfile;
	JLabel lblTest;
 
	public static void main(String[] args) {
//		MainMenu db = new MainMenu();
		JFrame frmMain = new MainMenu();
		frmMain.setTitle("My Window");
		frmMain.setSize(500, 300);
		frmMain.setLocationRelativeTo(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setVisible(true);
	}
	public MainMenu() {
//		Container cont = frmMain.getContentPane();
//		cont.setLayout(new FlowLayout());
//		cont.setBackground(Color.GRAY);
//		frmMain.setSize(500,300);
		

		txtPassword = new JPasswordField(8);
		txtPassword.setBackground(Color.white);
		txtPassword.setEditable(true);
		txtPassword.setHorizontalAlignment(JPasswordField.LEFT);
		add(txtPassword);
		
		
		cmboProfile = new JComboBox<String>();
		cmboProfile.addItem("Admin");
		cmboProfile.addItem("Nicholas Work");
		cmboProfile.addItem("Standard User");
		cmboProfile.addItem("Guest");
		add(cmboProfile);
		
		
		
		JButton btnViewTrucks = new JButton("View Trucks");
		btnViewTrucks.setBackground(Color.GRAY);
//		btnViewTrucks.addActionListener( new ButtonAction());
		add(btnViewTrucks);
		
		lblTest = new JLabel("Testing", JLabel.CENTER);
		add(lblTest);		
	}
//	public MainMenu() {
//
//		
//	}
}