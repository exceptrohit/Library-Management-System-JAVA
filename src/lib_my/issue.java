package lib_my;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class issue extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldbid;
	private JTextField textFieldsid;
	//private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issue frame = new issue();
					
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
	public issue() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 729, 411);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		
		btnNewButton.setBorder(null);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		//lblNewLabel.setIcon(imageIcon);
		btnNewButton.setIcon(imageIcon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new admin().setVisible(true);
			}
		});
		btnNewButton.setBounds(817, 22, 44, 36);
		contentPane.add(btnNewButton);
		textFieldbid = new JTextField();
		textFieldbid.setBounds(149, 241, 96, 19);
		contentPane.add(textFieldbid);
		textFieldbid.setColumns(10);
		
		textFieldsid = new JTextField();
		textFieldsid.setBounds(149, 315, 96, 19);
		contentPane.add(textFieldsid);
		textFieldsid.setColumns(10);
		
		//table starts
		//String data[][]= {};
		String columns[]= {"Book_id","Book_Name","Author"};
		int rowsize=0;
		try {
			conn c =new conn();
			String q1="select COUNT(*) from booktable where status=1;"; //ie available too be issues 
			ResultSet rs1=c.statement.executeQuery(q1);
			rs1.next();
			 rowsize=rs1.getInt(1);
			 System.out.print(rowsize);
		}
		catch(Exception e)
		{
		}
	
			String data[][]=new String[rowsize][3];
		try {
			conn c1=new conn();
			String q2="select book_id,book_name,author from booktable where status=1";
			ResultSet rs=c1.statement.executeQuery(q2);
			int i=0;
			while(rs.next())
			{
				for(int j=0;j<3;j++)
				{
					data[i][j]=rs.getString(j+1); //column index indexed from 1
					//System.out.println(data[i][j]);
				}
				i++;
			}
		}
		catch(Exception e) {
			
		}
		
		TableModel model=new DefaultTableModel(data,columns) {
			public Class getColumnClass(int column)
			{
				if(column>=0 && column<= getColumnCount())
				{
					return getValueAt(0, column).getClass();
				}
				else
					return Object.class;
			}
		};
		contentPane.setLayout(null);
		JTable table = new JTable(model){public boolean isCellEditable(int row,int column)
		{return false;
		}};
		table.setForeground(new Color(47, 79, 79));
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setBackground(new Color(176, 224, 230));
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(270, 167, 432, 281);
		getContentPane().add(jp);
		
		ListSelectionModel selector=table.getSelectionModel();
		selector.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if(!selector.isSelectionEmpty())
					{
						int selected_row=selector.getMinSelectionIndex();
						System.out.println(selected_row);
						textFieldbid.setText(model.getValueAt(selected_row, 0).toString());
					}
					
				}
				
			});
		
		//table ends 
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(29, 240, 85, 21);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Student Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(29, 316, 108, 17);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButtonissue = new JButton("Issue");
		btnNewButtonissue.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));

		btnNewButtonissue.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnNewButtonissue.setHorizontalTextPosition(JButton.CENTER);
		btnNewButtonissue.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButtonissue.setIcon(imagebtn);
		btnNewButtonissue.setForeground(new Color(128, 0, 0));
		btnNewButtonissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book_id=textFieldbid.getText();
				String stid=textFieldsid.getText();
				if(book_id.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"No book id selected");
					return;
				}
				
				if(stid.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"No student id selected");
					return;
				}
				try {
					/*String check1="IF NOT EXISTS(select *from studenttable where st_id="+stid+")"
							+ "BEGIN"
							+ "select 1"
							+ "IF NOT EXISTS(select * from booktable where bood_id="+book_id+")"
									+ "BEGIN"
									+ "select 2"
									+ "ELSE"
									+ "UPDATE booktable SET"
									+ "status=0,stid="+stid+",fine=0"
											+ "where book_id="+book_id;*/
					conn c=new conn();
					
					String check1="select * from booktable where book_id="+book_id+" and status=1";
					String check2="select * from studenttable where st_id="+stid;
					ResultSet rs=c.statement.executeQuery(check1);
					//rs.next();
				    if(!rs.next())
				    {
				    	//System.out.println("book error");
				    	throw new OutOfRange(1);
				    }
				     rs=c.statement.executeQuery(check2);
				     //rs.next();
				    if(!rs.next())
				    {
				    	//System.out.println("student error");
				    	throw new OutOfRange(2);
				    }
				    System.out.print("pass: book "+book_id+" stid: "+stid);
				    String command="UPDATE booktable "
				    		+ "SET "+ "stid="+stid+",status= 0,issuedate=CURRENT_DATE,fine= 0,duedate=DATE_ADD(CURRENT_DATE,INTERVAL 1 month),request=0 "
				    				+ "where book_id="+book_id;
				    System.out.println(command);
				    c.statement.executeUpdate(command);
					JOptionPane.showMessageDialog(null,"Book ID:  "+book_id+"  to student ID:  "+stid+"  issued Successfully!");
					dispose();
					new issue().setVisible(true);


				}
				catch(SQLException  exp)
				{
					
						JOptionPane.showMessageDialog(null,"Update unsuccesfull : error");

					
				} 
				catch (OutOfRange e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();  this prints all the red error lines 
					//JOptionPane.showMessageDialog(null,"Book id not in record");
				} 
				
				
				
			}
		});
		btnNewButtonissue.setBounds(71, 427, 85, 36);
		contentPane.add(btnNewButtonissue);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Books available to be issued");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(356, 121, 273, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(-13, 0, 936, 589);
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/background.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(imageIcon1);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
