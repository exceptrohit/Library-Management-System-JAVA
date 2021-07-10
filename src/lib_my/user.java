package lib_my;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user extends JFrame {

	private JPanel contentPane;
	private JTextField textFielduser;
	private JTextField textselected;
	private static int stid;
	private JTextField textFieldid;
	//private JFrame jframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user(stid);
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
	public user( int stid) {
		
		this.stid=stid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 844, 467);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Books highlighted in yellow are requested for return ");
		lblNewLabel_6.setForeground(new Color(204, 255, 153));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(316, 431, 441, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Book issued");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(446, 37, 131, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Student Login\r\n");
		lblNewLabel_5.setForeground(new Color(255, 255, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_5.setBounds(43, 27, 264, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Welcome user");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 94, 121, 28);
		contentPane.add(lblNewLabel);
		
		textFielduser = new JTextField();
		textFielduser.setEditable(false);
		textFielduser.setBounds(178, 98, 116, 22);
		contentPane.add(textFielduser);
		textFielduser.setColumns(10);
		
		textFieldid = new JTextField();
		textFieldid.setEditable(false);
		textFieldid.setBounds(178, 172, 116, 22);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/background.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		//
		
		
		JButton btnNewButton = new JButton("Change password");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 250, 250));

		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn1 = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button1.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnNewButton.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButton.setIcon(imagebtn1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new change_pass(stid).setVisible(true);
			}
		});
		btnNewButton.setBounds(545, 477, 154, 31);
		contentPane.add(btnNewButton);

		// student login
		try {
			conn c=new conn();

            String q="select st_id,st_name,st_pass from studenttable where st_id="+stid;
            ResultSet rs=c.statement.executeQuery(q);
            rs.next();
            String st_id=rs.getString(1);
            //System.out.print(st_id);
            String st_name=rs.getString(2);
            String pass=rs.getString(3);
            textFielduser.setText(st_name);
            textFieldid.setText(st_id);
			 
		}
		catch(Exception e)
		{
			System.out.print("login error");
		}
		
		
		//
		
		String columns[]= {"Book_id","Book_Name","Author","Duedate","Fine"};
		
		int rowsize=0;
		try {
			conn c =new conn();
			String q1="select COUNT(*) from booktable where stid="+stid+";";  
			ResultSet rs1=c.statement.executeQuery(q1);
			rs1.next();
			 rowsize=rs1.getInt(1);
			 System.out.print(rowsize);
		}
		catch(Exception e)
		{
			System.out.print("table error");
		}
		String data[][]=new String[rowsize][6];
		try {
			conn c1=new conn();
			//String q2="select book_id,book_name,author from booktable where stid="+stid;
			String q2="select book_id,book_name,author,duedate,fine,request from booktable where stid="+stid;
			ResultSet rs=c1.statement.executeQuery(q2);
			int i=0;
			while(rs.next())
			{
				for(int j=0;j<6;j++)
				{
					data[i][j]=rs.getString(j+1); //column index indexed from 1
					//System.out.println(data[i][j]);
				}
				String qf="SELECT "
						+ "case when "
						+ "DATEDIFF(CURDATE(), duedate)>0 then DATEDIFF(CURDATE(), duedate)*10 else 0 end AS fine from booktable where book_id=" +data[i][0]+ ";";
				
				//String test = "SELECT DATEDIFF(CURDATE(), \"2016-12-24\");";
				//System.out.println(fine);
				try {
					conn c2=new conn();
					ResultSet rs_fine=c2.statement.executeQuery(qf);
				    rs_fine.next();
				    
					String fine=rs_fine.getString(1);
					data[i][4]="$ "+fine;
					
					//now update fine in table 
					String update_fine="UPDATE booktable "
				    		+ "SET "+ "fine="+fine
		    				+ " where book_id="+data[i][0];
					//System.out.println(update_fine);
				    c2.statement.executeUpdate(update_fine);
				    
				}
				catch(Exception f)
				{
					System.out.println("fine fail");
				}
				i++;
			}
		}
		catch(Exception e) {
			
		}
		//table
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
		JTable table = new JTable(model){
			public boolean isCellEditable(int row,int column)
			
		{
				return false;
		}
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	            Component comp = super.prepareRenderer(renderer, row, column);
            	//System.out.println(row+" "+column+" " +data[row][5]);
            	
	            if (data[row][5].equals("1"))
	            {
	            	//System.out.print("color");
	            	comp.setBackground(Color.YELLOW);
	            }
	           
	            else
	            {
	            	//comp.setBackground(Color.default);
	            	comp.setBackground(getBackground());
	            }
	            return comp;
	         }
		};
		table.setForeground(new Color(47, 79, 79));
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setBackground(new Color(176, 224, 230));
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(306, 76, 466, 344);
		getContentPane().add(jp);
		
		textselected = new JTextField();
		textselected.setBounds(178, 398, 116, 22);
		contentPane.add(textselected);
		textselected.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(53, 174, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Selected Book");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(43, 398, 164, 22);
		contentPane.add(lblNewLabel_3);
		
		JButton btn_return = new JButton("Request Return");
		btn_return.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_return.setForeground(new Color(128, 0, 0));

		btn_return.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btn_return.setHorizontalTextPosition(JButton.CENTER);
		btn_return.setVerticalTextPosition(JButton.CENTER);
		
		btn_return.setIcon(imagebtn);
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String book_id=textselected.getText();
				try {
					conn c =new conn();
					String command="UPDATE booktable "
				    		+ "SET "+ "request=1 "
				    				+ "where book_id="+book_id+" and stid="+stid;
					JOptionPane.showMessageDialog(null, "Return request generated !");
				    c.statement.executeUpdate(command);
				}
				catch(Exception r)
				{
					System.out.print("request error");
				}
				
				dispose();
				new user(stid).setVisible(true);
				
				
				
			}
		});
		btn_return.setBounds(33, 477, 164, 31);
		contentPane.add(btn_return);
		
		JButton btnNewButton_1 = new JButton("Cancel  Request");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(128, 0, 0));

		btnNewButton_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		//ImageIcon imagebtn = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnNewButton_1.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton_1.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButton_1.setIcon(imagebtn);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String book_id=textselected.getText();
				try {
					conn c =new conn();
					String command="UPDATE booktable "
				    		+ "SET "+ "request=0 "
				    				+ "where book_id="+book_id+" and stid="+stid;
					JOptionPane.showMessageDialog(null, "Return request cancelled !");
				    c.statement.executeUpdate(command);
				}
				catch(Exception r)
				{
					System.out.print("request error");
				}
				dispose();
				new user(stid).setVisible(true);
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(281, 477, 154, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnNewButton_2.setForeground(new Color(255, 250, 250));
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		//ImageIcon imagebtn1 = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button1.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnNewButton_2.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton_2.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButton_2.setIcon(imagebtn1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(771, 477, 97, 31);
		contentPane.add(btnNewButton_2);
		//icon
		
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setIcon(imageIcon);
        lblNewLabel_4.setBounds(-60, -18, 983, 588);
        contentPane.add(lblNewLabel_4);
		
		
		
		
		ListSelectionModel selector=table.getSelectionModel();
		selector.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if(!selector.isSelectionEmpty())
					{
						int selected_row=selector.getMinSelectionIndex();
						System.out.println(selected_row);
						textselected.setText(model.getValueAt(selected_row, 0).toString());
					}
					
				}
				
			});
		
		//table ends 
	}
}
