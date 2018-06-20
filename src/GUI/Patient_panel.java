package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data_structures.doctor;
import data_structures.patient;

public class Patient_panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	doctor doc;
	patient patient;
	
	Base_frame parent;
	
	public Patient_panel(Base_frame parent,doctor doc) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(700,100));
		setLayout(null);
		
		this.parent=parent;
		this.doc=doc;
		
		Font Title = new Font("Tahoma",Font.BOLD,16);
		Font label = new Font("Tahoma",Font.PLAIN,12);
		
		
		JLabel JLabel_1=new JLabel("Patient");
		JLabel_1.setFont(Title);
		JLabel_1.setBounds(1,1,150,20);
		
		JLabel JLabel_2=new JLabel("Name");
		JLabel_2.setFont(label);
		JLabel_2.setBounds(10,5,150,20);
		
		JLabel JLabel_3=new JLabel("Surname");
		JLabel_3.setFont(label);
		JLabel_3.setBounds(100,10,150,20);
		
		JLabel JLabel_4=new JLabel("Birth Date");
		JLabel_4.setFont(label);
		JLabel_4.setBounds(5,80,150,20);
		
		JLabel JLabel_5=new JLabel("Day");
		JLabel_5.setFont(label);
		JLabel_5.setBounds(50,55,150,20);
		
		JLabel JLabel_6=new JLabel("Month");
		JLabel_6.setFont(label);
		JLabel_6.setBounds(100,55,150,20);
		
		JLabel JLabel_7=new JLabel("Year");
		JLabel_7.setFont(label);
		JLabel_7.setBounds(150,55,150,20);
		
		JTextField name=new JTextField();
		name.setFont(label);
		name.setBounds(10,25,100,20);
		
		JTextField surname=new JTextField();
		surname.setFont(label);
		surname.setBounds(100,25,100,20);
		
		JComboBox<Integer> day=new JComboBox<Integer>();
		for(int i=1;i<=31;i++) {
			day.addItem(i);
		}
		day.setFont(label);
		day.setBounds(50,80,50,20);
		
		JComboBox<Integer> month=new JComboBox<Integer>();
		for(int i=1;i<=12;i++) {
			month.addItem(i);
		}
		month.setFont(label);
		month.setBounds(100,80,50,20);
		
		JComboBox<Integer> year=new JComboBox<Integer>();
		int y=LocalDate.now().getYear();
		for(int i=0;i<=180;i++) {
			year.addItem(y-i);
		}
		year.setFont(label);
		year.setBounds(150,80,50,20);
		
		add(JLabel_1);
		add(JLabel_2);
		add(JLabel_3);
		add(JLabel_4);
		add(JLabel_5);
		add(JLabel_6);
		add(JLabel_7);
		add(name);
		add(surname);
		add(day);
		add(month);
		add(year);
		
	}

}
