package lib_my;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textuser;
	private JPasswordField textpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 664, 374);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Rohit's Library ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(216, 49, 447, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbluser = new JLabel("User ID");
		lbluser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbluser.setForeground(Color.WHITE);
		lbluser.setBounds(134, 175, 85, 26);
		contentPane.add(lbluser);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpass.setForeground(Color.WHITE);
		lblpass.setBounds(134, 275, 119, 26);
		contentPane.add(lblpass);
		
		textuser = new JTextField();
		textuser.setBounds(435, 179, 135, 19);
		contentPane.add(textuser);
		textuser.setColumns(10);
		
		textpass = new JPasswordField();
		textpass.setBounds(435, 279, 135, 19);
		contentPane.add(textpass);
		
		JButton btnlogin = new JButton("login");
		btnlogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));

		btnlogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnlogin.setHorizontalTextPosition(JButton.CENTER);
		btnlogin.setVerticalTextPosition(JButton.CENTER);
		
		btnlogin.setIcon(imagebtn);
		btnlogin.setForeground(new Color(128, 0, 0));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textuser.getText().equals("admin"))
				{
					setVisible(false);
					new admin().setVisible(true);
				}
				else if(textuser.getText().isEmpty() || textpass.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "User ID or password cannot be empty!");
					return;
				}
				else
				{
					  try {
		                   conn c=new conn();

		                    String q="select st_id,st_pass from studenttable where st_id="+textuser.getText()+";";
		                    

		                    ResultSet rs=c.statement.executeQuery(q);
		        			rs.next();
		        			int stid=rs.getInt(1);
		        			String pass=rs.getString(2);
		        			System.out.println(stid+" "+pass);
		        			if (!pass.equals(textpass.getText()))
		        			{
		        				JOptionPane.showMessageDialog(null, "Wrong password!");
		        			}
		        			else
		        			{
		        				setVisible(false);
		        				new user(stid).setVisible(true);
		        			}
					  }
					  catch(Exception user)
					  {
						  JOptionPane.showMessageDialog(null, "student ID not registered");
						  //System.out.println("login error");
					  }
				}
				/*else
				{
					JOptionPane.showMessageDialog(null, "message");
				}*/
				
			}
		});
		btnlogin.setBounds(702, 427, 85, 37);
		contentPane.add(btnlogin);
		
		JButton btnReg = new JButton("Register");
		btnReg.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));

		btnReg.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		//ImageIcon imagebtn = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnReg.setHorizontalTextPosition(JButton.CENTER);
		btnReg.setVerticalTextPosition(JButton.CENTER);
		
		btnReg.setIcon(imagebtn);
		btnReg.setForeground(new Color(128, 0, 0));
		btnReg.setBackground(Color.WHITE);
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new register().setVisible(true);
			}
		});
		btnReg.setBounds(66, 427, 85, 37);
		contentPane.add(btnReg);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/login.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(-34, -143, 1139, 714);
		contentPane.add(lblNewLabel);
		
	}
}
