package lib_my;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class background extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					background frame = new background();
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
	public background() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 761, 428);
		setBounds(400, 100, 921, 604);
		//setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnnewbook = new JButton("Add book");
		btnnewbook.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnnewbook.setForeground(new Color(128, 0, 0));
		btnnewbook.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnnewbook.setHorizontalTextPosition(JButton.CENTER);
		btnnewbook.setVerticalTextPosition(JButton.CENTER);
		
		btnnewbook.setIcon(imagebtn);
		btnnewbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addbook().setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Admin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(358, 71, 244, 33);
		contentPane.add(lblNewLabel_1);
		btnnewbook.setBounds(27, 138, 111, 33);
		contentPane.add(btnnewbook);
		
		JButton btnissue = new JButton("Issue");
		btnissue.setForeground(new Color(128, 0, 0));
		btnissue.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));

		btnissue.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		//ImageIcon imagebtn = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnissue.setHorizontalTextPosition(JButton.CENTER);
		btnissue.setVerticalTextPosition(JButton.CENTER);
		
		btnissue.setIcon(imagebtn);
		btnissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new issue().setVisible(true);
			}
		});
		btnissue.setBounds(27, 338, 111, 40);
		contentPane.add(btnissue);
		
		JButton btnreturn = new JButton("Return");
		btnreturn.setForeground(new Color(128, 0, 0));
		btnreturn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnreturn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		//ImageIcon imagebtn = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnreturn.setHorizontalTextPosition(JButton.CENTER);
		btnreturn.setVerticalTextPosition(JButton.CENTER);
		
		btnreturn.setIcon(imagebtn);
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new return_admin().setVisible(true);
			}
		});
		btnreturn.setBounds(27, 236, 111, 33);
		contentPane.add(btnreturn);
		
		JButton btnlog = new JButton("logout");
		btnlog.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnlog.setForeground(new Color(255, 250, 250));

		btnlog.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ImageIcon imagebtn1 = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/button1.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		btnlog.setHorizontalTextPosition(JButton.CENTER);
		btnlog.setVerticalTextPosition(JButton.CENTER);
		
		btnlog.setIcon(imagebtn1);
		btnlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnlog.setBounds(761, 469, 99, 33);
		contentPane.add(btnlog);
		
		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));

		//lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(background.class.getResource("/lib_my/background.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		//lblNewLabel.setIcon(new ImageIcon(background.class.getResource("/lib_my/background.jpg")) );
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(background.class.getResource("/lib_my/background.jpg")).getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imageIcon);


		//lblNewLabel.setIcon(new ImageIcon(background.class.getResource("/lib_my/background.jpg")) );
		lblNewLabel.setBounds(-21, -16, 996, 599);
		contentPane.add(lblNewLabel);
	}

}
