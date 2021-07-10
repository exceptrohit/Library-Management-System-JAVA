package lib_my;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class return_admin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldbid;
	private JTextField textFieldsid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return_admin frame = new return_admin();
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
	public return_admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 863, 463);
		setBounds(400, 100, 921, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//table stars 
		
		//String columns[]= {"Book_id","Book_Name","Std_id","Issue_Date","Due_Date","Fine","Request"};
		String columns[]= {"Book_id","Book_Name","Std_id","Issue_Date","Due_Date","Fine"};
		int rowsize=0;
		try {
			conn c =new conn();
			String q1="select COUNT(*) from booktable where status=0;"; //ie currently issued 
			ResultSet rs1=c.statement.executeQuery(q1);
			rs1.next();
			 rowsize=rs1.getInt(1);
			 System.out.println(rowsize);
		}
		catch(Exception e)
		{
			
		}
	
			String data[][]=new String[rowsize][7];
		try {
			conn c1=new conn();
			String q2="select book_id,book_name,stid,issuedate,duedate,fine,request from booktable where status=0;"; //currently issues-->0
			ResultSet rs=c1.statement.executeQuery(q2);
			int i=0;
			while(rs.next())
			{
				
				for(int j=0;j<7;j++)
				{
					
					data[i][j]=rs.getString(j+1); //column index indexed from 1
					
					//System.out.println(data[i][j]);
				}
				int curr_book=Integer.parseInt(data[i][0]);
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
				    data[i][5]="$ "+fine;
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
			System.out.println("fine fail");
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
		
		JButton btnNewButton = new JButton("");
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
		
		JLabel lblNewLabel_4 = new JLabel("Books highlighted in yellow are requested for return ");
		lblNewLabel_4.setForeground(new Color(204, 255, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(366, 464, 410, 23);
		contentPane.add(lblNewLabel_4);
		btnNewButton.setBounds(734, 26, 42, 34);
		contentPane.add(btnNewButton);
		JTable table = new JTable(model){
			public boolean isCellEditable(int row,int column)
		{
			return false;
		}
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	            Component comp = super.prepareRenderer(renderer, row, column);
            	System.out.println(row+" "+column+" " +data[row][6]);
            	
	            if (data[row][6].equals("1"))
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
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(295, 141, 504, 287);
		getContentPane().add(jp);
		
		//table ends 
		//additional table selected row listener
		ListSelectionModel selector=table.getSelectionModel();
		selector.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if(!selector.isSelectionEmpty())
					{
						int selected_row=selector.getMinSelectionIndex();
						//System.out.println(selected_row);
						//Component comp = table.prepareRenderer(table.getCellRenderer(selected_row, 6), selected_row, 6);
						//comp.setBackground(Color.cyan);
						textFieldbid.setText(model.getValueAt(selected_row, 0).toString());
						textFieldsid.setText(model.getValueAt(selected_row, 2).toString());
						
					}
					
				}
				
			});
		//table selection model listenerends 
		
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(43, 213, 68, 23);
		contentPane.add(lblNewLabel);
		
		textFieldbid = new JTextField();
		textFieldbid.setBounds(203, 214, 54, 21);
		contentPane.add(textFieldbid);
		textFieldbid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(43, 286, 108, 20);
		contentPane.add(lblNewLabel_1);
		
		textFieldsid = new JTextField();
		textFieldsid.setEditable(false);
		textFieldsid.setBounds(203, 286, 54, 23);
		contentPane.add(textFieldsid);
		textFieldsid.setColumns(10);
		
		JButton btnNewButtonissue = new JButton("Return");
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
				//String stid=textFieldsid.getText();
				if(book_id.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"No book id selected");
					return;
				}
				try {
					
					conn c=new conn();
					
					String check1="select * from booktable where book_id="+book_id+" and status=0";
					ResultSet rs=c.statement.executeQuery(check1);
					//rs.next();
				    if(!rs.next())
				    {
				    	//System.out.println("book error");
				    	throw new OutOfRange(1);
				    }
				    
				    //String fine="select fine from booktable where book_id="+book_id+" and status=0";
				    //int Fine=0;
				    int Fine=rs.getInt(7);
				    
				    //ResultSet rs_fine=c.statement.executeQuery(fine);
				   // rs_fine.next();
				    //Fine=rs_fine.getInt(1);
				    
				   
				    
				    
	
				    String command="UPDATE booktable "
				    		+ "SET "+ "stid=null,status= 1,issuedate=null,fine= 0,duedate=null,request=0 "
				    				+ "where book_id="+book_id;
				    System.out.println(command);
				    c.statement.executeUpdate(command);
				    if (Fine==0)
						{
				    	JOptionPane.showMessageDialog(null,"Return  Successful! with No fine");
						}
				    else
				    {
				    	JOptionPane.showMessageDialog(null,"Return  Successful!, You need to pay Fine: "+Fine);
				    }
					
					dispose();
					new return_admin().setVisible(true);


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
		btnNewButtonissue.setBounds(62, 370, 159, 44);
		contentPane.add(btnNewButtonissue);
		
		JLabel lblNewLabel_2 = new JLabel("Issued books list");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(460, 102, 203, 13);
		contentPane.add(lblNewLabel_2);
		
		
      JLabel lblNewLabel_3 = new JLabel("New label");
		
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(admin.class.getResource("/lib_my/background.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(imageIcon1);
		lblNewLabel_3.setBounds(-85, -23, 1087, 603);
		contentPane.add(lblNewLabel_3);
	}
}
