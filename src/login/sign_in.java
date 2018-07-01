package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.Base_frame;
import data_structures.TableManager;
import data_structures.Tables;
import data_structures.doctor;

public class sign_in extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	Login parent;
	public sign_in(Login parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(244,600));
		setLayout(null);
		
		this.parent=parent;
		
		Font FONT1=new Font("Tahoma",Font.PLAIN,14);
		
		
		JLabel Jlabel_1 = new JLabel("Name");
		Jlabel_1.setFont(FONT1);
		Jlabel_1.setBounds(155,30,150,20);
		
		
		JTextField Name=new JTextField();
		Name.setBounds(150,55,150,20);
		
		JLabel Jlabel_2=new JLabel("Surname");
		Jlabel_2.setFont(FONT1);
		Jlabel_2.setBounds(155,90,150,20);
		
		JTextField Surname = new JTextField();
		Surname.setBounds(150,115,150,20);
		
		add(Jlabel_1);
		add(Jlabel_2);
		add(Name);
		add(Surname);
		
		JButton signin = new JButton("Sign In");
		signin.setBounds(175,150,100,30);
		
		JButton signup =new JButton("Sign Up");
		signup.setBounds(175,200,100,30);
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		add(signin);
		add(signup);
	}

}
