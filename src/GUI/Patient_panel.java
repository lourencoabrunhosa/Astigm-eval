package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data_structures.Table;
import data_structures.TableManager;
import data_structures.doctor;
import data_structures.patient;
import get_stats.Stats;

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
	
	JTextField name;
	JTextField surname;
	
	JComboBox<Integer> day;
	JComboBox<Month> month;
	JComboBox<Integer> year;
	
	public Patient_panel(Base_frame parent,doctor doc) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(700,120));
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
		JLabel_2.setBounds(12,19,150,20);
		
		JLabel JLabel_3=new JLabel("Surname");
		JLabel_3.setFont(label);
		JLabel_3.setBounds(117,19,150,20);
		
		JLabel JLabel_4=new JLabel("Birth Date");
		JLabel_4.setFont(label);
		JLabel_4.setBounds(5,90,150,20);
		
		JLabel JLabel_5=new JLabel("Day");
		JLabel_5.setFont(label);
		JLabel_5.setBounds(72,65,150,15);
		
		JLabel JLabel_6=new JLabel("Month");
		JLabel_6.setFont(label);
		JLabel_6.setBounds(152,65,150,15);
		
		JLabel JLabel_7=new JLabel("Year");
		JLabel_7.setFont(label);
		JLabel_7.setBounds(272,65,150,15);
		
		name=new JTextField();
		name.setFont(label);
		name.setBounds(10,38,100,20);
		
		surname=new JTextField();
		surname.setFont(label);
		surname.setBounds(115,38,100,20);
		
		day=new JComboBox<Integer>();
		for(int i=1;i<=31;i++) {
			day.addItem(i);
		}
		day.setFont(label);
		day.setBounds(70,90,70,25);
		
		month=new JComboBox<Month>();
		for(Month m:Month.values()) {
			month.addItem(m);
		}
		month.setFont(label);
		month.setBounds(150,90,115,25);
		
		year=new JComboBox<Integer>();
		int y=LocalDate.now().getYear();
		for(int i=0;i<=180;i++) {
			year.addItem(y-i);
		}
		year.setFont(label);
		year.setBounds(270,90,80,25);
		
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
		
		JButton save =new JButton("Save to database");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				savesurgery();
			}		
		});
		save.setBounds(400,40,150,30);
		
		add(save);
		
		JButton stats = new JButton("Show stats");
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println(Stats.getStats(1, 0, 100, doc.getDataBaseName()+"ref"));
			}
		});
		stats.setBounds(400,80,150,30);
		
		add(stats);
	}
	private void savesurgery() {
		if(parent.STATE==1) {
			patient newguy=new patient(1,name.getText()+" "+surname.getText(),
					(int) year.getSelectedItem(),(Month) month.getSelectedItem(),(int) day.getSelectedItem(),
					parent.features.REF_patient.output.preinfo,parent.features.REF_patient.output.posinfo);
			try {
				TableManager tm=new TableManager(doc.getDataBaseName()+"ref");
				((Table) tm.table).add(newguy);
				tm.close();
			} catch(Exception e) {
				Table t=new Table(10);
				t.add(newguy);
				TableManager tm=new TableManager(doc.getDataBaseName()+"ref",t);
				tm.close();
			}	
		} else if(parent.STATE==2){
			patient newguy=new patient(1,name.getText()+" "+surname.getText(),
					(int) year.getSelectedItem(),(Month) month.getSelectedItem(),(int) day.getSelectedItem(),
					parent.features.IOL_patient.output.subjective.preinfo,parent.features.IOL_patient.output.subjective.posinfo);
			try {
				TableManager tm=new TableManager(doc.getDataBaseName()+"iol");
				((Table) tm.table).add(newguy);
				tm.close();
			} catch(Exception e) {
				Table t=new Table(10);
				t.add(newguy);
				TableManager tm=new TableManager(doc.getDataBaseName()+"iol",t);
				tm.close();
			}
		}
	}

}
