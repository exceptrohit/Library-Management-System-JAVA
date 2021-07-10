package lib_my;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.border.MatteBorder;


public class addbook extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldbname;
	private JTextField textFieldauthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addbook frame = new addbook();
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
	public addbook() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 707, 391);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new admin().setVisible(true);
				
			}
		});
		//btnNewButton_1.setBorder(null);
		btnNewButton_1.setBorder(new RoundedBorder(10));
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		
		JLabel lblNewLabel_1 = new JLabel("Add a new book");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(313, 33, 339, 56);
		contentPane.add(lblNewLabel_1);
		//lblNewLabel.setIcon(imageIcon);
		btnNewButton_1.setIcon(imageIcon);
		
		btnNewButton_1.setBounds(799, 26, 37, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblBookName = new JLabel("Book name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBookName.setForeground(new Color(204, 255, 153));
		lblBookName.setBounds(138, 191, 165, 44);
		contentPane.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author's Name");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAuthor.setForeground(new Color(204, 255, 153));
		lblAuthor.setBounds(138, 310, 194, 44);
		contentPane.add(lblAuthor);
		
		textFieldbname = new JTextField();
		textFieldbname.setColumns(10);
		textFieldbname.setBounds(393, 203, 165, 30);
		contentPane.add(textFieldbname);
		
		textFieldauthor = new JTextField();
		textFieldauthor.setColumns(10);
		textFieldauthor.setBounds(393, 322, 165, 30);
		contentPane.add(textFieldauthor);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));

		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button1.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnNewButton.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButton.setIcon(imagebtn);
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
				conn c=new conn();
				String bname=textFieldbname.getText();
				String author=textFieldauthor.getText();
				if (bname.isEmpty() || author.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Book name or Author's name cannot be empty!");
					return;
				}
				
				String command = "insert into booktable(book_name,author) values ('"+bname+"','"+author+"');";
				//String query = "insert into booktable values(10,'java','auth',1,null,null,null);";
				//ResultSet rs=c.s.executeQuery(query); //for insert you executeUpdate not executeQuery and no resultset for execute update
				c.statement.executeUpdate(command); 
				
				
				String query="select max(book_id) from booktable;";
				ResultSet rs=c.statement.executeQuery(query);
				rs.next();  //rs next is must to move cursor to first row
				int book_id=rs.getInt(1);
				JOptionPane.showMessageDialog(null, "Book id: "+book_id+" added");
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnNewButton.setBounds(332, 444, 136, 44);
		contentPane.add(btnNewButton);
		
		
		
       JLabel lblNewLabel = new JLabel("New label");
		
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/book.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imageIcon1);
		lblNewLabel.setBounds(-67, -139, 1078, 714);
		contentPane.add(lblNewLabel);
	}

}
