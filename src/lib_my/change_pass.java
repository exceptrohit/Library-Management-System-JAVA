package lib_my;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class change_pass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_current;
	private JPasswordField passwordField_new;
	private JPasswordField passwordField_confirm;
	private static int stid;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					change_pass frame = new change_pass(stid);
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
	public change_pass(int stid) {
		this.stid=stid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 639, 394);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Change Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4.setBounds(332, 62, 261, 38);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Current Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(79, 156, 159, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(79, 224, 144, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(79, 312, 159, 26);
		contentPane.add(lblNewLabel_2);
		
		passwordField_current = new JPasswordField();
		passwordField_current.setBounds(496, 156, 127, 26);
		contentPane.add(passwordField_current);
		
		passwordField_new = new JPasswordField();
		passwordField_new.setBounds(496, 234, 127, 28);
		contentPane.add(passwordField_new);
		
		passwordField_confirm = new JPasswordField();
		passwordField_confirm.setBounds(500, 312, 123, 28);
		contentPane.add(passwordField_confirm);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));

		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnNewButton.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButton.setIcon(imagebtn);
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String curr=passwordField_current.getText();
				String newpass=passwordField_new.getText();
				String confirm=passwordField_confirm.getText();
				
				// student login
				try {
					conn c=new conn();

		            String q="select st_id,st_name,st_pass from studenttable where st_id="+stid;
		            ResultSet rs=c.statement.executeQuery(q);
		            rs.next();
		            String st_id=rs.getString(1);
		            
		            String st_name=rs.getString(2);
		            String pass=rs.getString(3);
		            if (!curr.equals(pass))
					{
		            	JOptionPane.showMessageDialog(null, "Current password is wrong!");
		            	return;
					}
		            if(!newpass.equals(confirm))
		            {
		            	JOptionPane.showMessageDialog(null, "New Password and confirm password does not match!");
		            	return;
		            }
		            
		            String command="UPDATE studenttable "
				    		+ "SET "+ "st_pass=\""+newpass
				    				+ "\"where st_id="+stid;
				    System.out.println(command);
				    c.statement.executeUpdate(command);
				    JOptionPane.showMessageDialog(null, "Password changed successfully!");
		            
				}
				catch(Exception l)
				{
					System.out.print("password update error");
				}
				
				
			}
		});
		btnNewButton.setBounds(344, 423, 113, 38);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1.setForeground(new Color(238, 232, 170));
		btnNewButton_1.setBorder(new RoundedBorder(10));
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		//lblNewLabel.setIcon(imageIcon);
		btnNewButton_1.setIcon(imageIcon);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new user(stid).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(812, 37, 40, 38);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(-13, -43, 936, 616);
		
		
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/background.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(imageIcon1);
		contentPane.add(lblNewLabel_3);
	}
}
