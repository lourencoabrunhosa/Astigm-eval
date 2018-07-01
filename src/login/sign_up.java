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

public class sign_up extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	Login parent;
	int STATE;
	
	JTextField Name;
	JTextField Surname;
	
	JLabel Title;
	public sign_up(Login parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(244,600));
		setLayout(null);
		
		this.parent=parent;
		STATE=0;
		
		Font FONT1=new Font("Tahoma",Font.PLAIN,14);
		Font TitleFont = new Font("Tahoma",Font.BOLD,16);
		
		Title = new JLabel("SIGN IN");
		Title.setFont(TitleFont);
		Title.setBounds(170,10,150,20);
		
		JLabel Jlabel_1 = new JLabel("Name");
		Jlabel_1.setFont(FONT1);
		Jlabel_1.setBounds(155,30,150,20);
		
		
		Name=new JTextField();
		Name.setBounds(150,55,150,20);
		
		JLabel Jlabel_2=new JLabel("Surname");
		Jlabel_2.setFont(FONT1);
		Jlabel_2.setBounds(155,90,150,20);
		
		Surname = new JTextField();
		Surname.setBounds(150,115,150,20);
		
		add(Title);
		add(Jlabel_1);
		add(Jlabel_2);
		add(Name);
		add(Surname);
		
		JButton signin = new JButton("Sign In");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin();
			}
		});
		signin.setBounds(175,150,100,30);
		
		JButton signup =new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup();
			}
		});
		signup.setBounds(175,200,100,30);
	

		add(signin);
		add(signup);
	}
	
	void signup() {
		if(STATE==0) {
			STATE=1;
			Title.setText("SIGN UP");
		}
		else if(STATE==1) {
			doctor doc=new doctor(Name.getText(),Surname.getText());
			TableManager tm;
			try{
				tm=new TableManager("doctors");
				((Doc_Table) tm.table).add(doc);
			} catch(Exception e1) {
				Tables dt=new Doc_Table();
				((Doc_Table) dt).add(doc);
				tm=new TableManager("doctors",dt);
			} 
			tm.close();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Base_frame frame = new Base_frame(doc);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	void signin() {
		if(STATE==0) {
			doctor doc;
			TableManager tm;
			try{
				tm=new TableManager("doctors");
				if(((Doc_Table) tm.table).search(Name.getText(),Surname.getText())) {
					doc=((Doc_Table) tm.table).login(Name.getText(),Surname.getText());
					tm.close();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Base_frame frame = new Base_frame(doc);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					tm.close();
					throw new Exception();
				}
			} catch(Exception e1) {
				System.out.println("doctor not found!");
			} 
		}
		else if(STATE==1) {
			STATE=0;
			Title.setText("SIGN IN");
		}
	}

}
