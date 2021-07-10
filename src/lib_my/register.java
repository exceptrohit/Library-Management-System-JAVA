package lib_my;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 721, 386);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		
		JLabel lblNewLabel_1 = new JLabel("Student Registration");
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(292, 40, 306, 46);
		contentPane.add(lblNewLabel_1);

		btnNewButton.setIcon(imageIcon1);
		btnNewButton.setBorder(null);
		
				btnNewButton.setBounds(781, 28, 42, 40);
				contentPane.add(btnNewButton);
		
		JLabel stdName = new JLabel("Name");
		stdName.setForeground(new Color(255, 255, 255));
		stdName.setFont(new Font("Tahoma", Font.BOLD, 25));
		stdName.setBounds(87, 147, 97, 31);
		contentPane.add(stdName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(87, 220, 138, 46);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 255, 255));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConfirmPassword.setBounds(87, 327, 272, 33);
		contentPane.add(lblConfirmPassword);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(422, 150, 127, 28);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(422, 234, 127, 28);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(422, 330, 127, 31);
		contentPane.add(passwordField_1);
		
		//btnAdd.setIcon(new ImageIcon(register.class.getResource("/lib_my/button.png")));
		//btnNewButton_1.setBorder(new RoundedBorder(10));
		JButton btnAdd = new JButton("Register");
		btnAdd.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnAdd.setHorizontalTextPosition(JButton.CENTER);
		btnAdd.setVerticalTextPosition(JButton.CENTER);
		
		btnAdd.setIcon(imagebtn);
		btnAdd.setForeground(new Color(128, 0, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					conn c=new conn();
					String std_name=textFieldName.getText();
					String std_pass=passwordField.getText();
					String confirm=passwordField_1.getText();
					if (std_name.isEmpty() || std_pass.isEmpty())
					{
						JOptionPane.showMessageDialog(null, " Name or password cannot be empty!");
		            	return;
					}
					if (!std_pass.equals(confirm))
					{
						JOptionPane.showMessageDialog(null, " Password and confirm password does not match!");
		            	return;

					}
					
					String command = "insert into studenttable(st_name,st_pass) values ('"+std_name+"','"+std_pass+"');";
					//String query = "insert into booktable values(10,'java','auth',1,null,null,null);";
					//ResultSet rs=c.s.executeQuery(query); //for insert you executeUpdate not executeQuery and no resultset for execute update
					c.statement.executeUpdate(command); 
					
					
					String query="select max(st_id) from studenttable;";
					ResultSet rs=c.statement.executeQuery(query);
					rs.next();  //rs next is must to move cursor to first row
					int std_id=rs.getInt(1);
					JOptionPane.showMessageDialog(null, "Your account with ID:  "+std_id+" is succesfully registered");
					}
				
					catch(Exception e1)
					{
						
					}
				
				
				
				
			}
		});
		btnAdd.setBounds(360, 445, 114, 46);
		contentPane.add(btnAdd);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/register.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(-16, -32, 930, 607);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
