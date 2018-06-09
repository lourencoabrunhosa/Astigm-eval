package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import data_structures.Custum_Exception;
import data_structures.pos_info;
import data_structures.pos_info_IOL;
import data_structures.pre_info;
import data_structures.pre_info_IOL;

public class Input_IOL_cornea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	Input_IOL parent;
	
	Border defaultBorder;
	Border warningBorder;
	
	JLabel errorinfo1;
	JLabel errorinfo2;
	
	double prek1=-1;
	double prek2=-1;
	double prea1=-1;
	double prea2=-1;
	
	double posk1=-1;
	double posk2=-1;
	double posa1=-1;
	double posa2=-1;
	
	pre_info preinfo;
	pos_info posinfo;
	
	public Input_IOL_cornea(Input_IOL parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(244,600));
		setLayout(null);
		
		this.parent=parent;
		
		defaultBorder=(new JTextField()).getBorder();
		warningBorder=BorderFactory.createLineBorder(Color.RED);
		
		Font section_head=new Font("Tahoma",Font.PLAIN,12);
		Font label=new Font("Tahoma",Font.BOLD,12);
		
		errorinfo1 = new JLabel("Please insert valid data");
		errorinfo1.setForeground(Color.RED);
		errorinfo1.setFont(new Font("Tahoma",Font.BOLD,8));
		errorinfo1.setBounds(80, 105, 489, 20);
		errorinfo1.setVisible(false);
		add(errorinfo1);
		
		errorinfo2 = new JLabel("Please insert valid data");
		errorinfo2.setForeground(Color.RED);
		errorinfo2.setFont(new Font("Tahoma",Font.BOLD,8));
		errorinfo2.setBounds(80, 265, 489, 20);
		errorinfo2.setVisible(false);
		add(errorinfo2);
		
		JLabel Jlabel_1 = new JLabel("Pre Surgery Data:");
		Jlabel_1.setFont(section_head);
		Jlabel_1.setBounds(10, 10, 489, 20);
		
		JLabel Jlabel_2 = new JLabel("K1");
		Jlabel_2.setFont(label);
		Jlabel_2.setBounds(20,50,489,20);
		
		JLabel Jlabel_3 = new JLabel("K2");
		Jlabel_3.setFont(label);
		Jlabel_3.setBounds(20,80,489,20);
		
		JLabel Jlabel_4 = new JLabel("axis 1");
		Jlabel_4.setFont(label);
		Jlabel_4.setBounds(100,50,489,20);
		
		JLabel Jlabel_5 = new JLabel("axis 2");
		Jlabel_5.setFont(label);
		Jlabel_5.setBounds(100,80,489,20);
		
		add(Jlabel_1);
		add(Jlabel_2);
		add(Jlabel_3);
		add(Jlabel_4);
		add(Jlabel_5);
		
		JTextField pre_k1=new JTextField();
		pre_k1.setBounds(45,50,45,20);
		
		JTextField pre_a1 = new JTextField();
		pre_a1.setBounds(140,50,45,20);
		
		JTextField pre_k2 = new JTextField();
		pre_k2.setBounds(45,80,45,20);
		
		JTextField pre_a2 = new JTextField();
		pre_a2.setBounds(140,80,45,20);
		
		add(pre_k1);
		add(pre_k2);
		add(pre_a1);
		add(pre_a2);
		
		JLabel Jlabel_6 = new JLabel("Post Surgery Data:");
		Jlabel_6.setFont(section_head);
		Jlabel_6.setBounds(10, 130, 489, 20);
		
		JLabel Jlabel_7 = new JLabel("K1");
		Jlabel_7.setFont(label);
		Jlabel_7.setBounds(20,170,489,20);
		
		JLabel Jlabel_8 = new JLabel("K2");
		Jlabel_8.setFont(label);
		Jlabel_8.setBounds(20,200,489,20);
		
		JLabel Jlabel_9 = new JLabel("axis 1");
		Jlabel_9.setFont(label);
		Jlabel_9.setBounds(100,170,489,20);
		
		JLabel Jlabel_10 = new JLabel("axis 2");
		Jlabel_10.setFont(label);
		Jlabel_10.setBounds(100,200,489,20);
		
		add(Jlabel_6);
		add(Jlabel_7);
		add(Jlabel_8);
		add(Jlabel_9);
		add(Jlabel_10);
		
		JTextField pos_k1=new JTextField();
		pos_k1.setBounds(45,170,45,20);
		
		JTextField pos_a1 = new JTextField();
		pos_a1.setBounds(140,170,45,20);
		
		JTextField pos_k2 = new JTextField();
		pos_k2.setBounds(45,200,45,20);
		
		JTextField pos_a2 = new JTextField();
		pos_a2.setBounds(140,200,45,20);
		
		add(pos_k1);
		add(pos_k2);
		add(pos_a1);
		add(pos_a2);
		
		JButton TIA = new JButton("Get TIA");
		TIA.setBounds(100,290,85,25);
		add(TIA);
		
		JButton outcomes = new JButton("Analyse Surgery");
		outcomes.setBounds(55,320,130,25);
		add(outcomes);
		

		TIA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_TIA();
			}
		});
		
		outcomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_SIA();
			}
		});
		
		pre_k1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_K(pre_k1)) prek1=Double.parseDouble(pre_k1.getText());
				else prek1=-1;
			}
			public void focusGained(FocusEvent e) {
				pre_k1.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		pre_k2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_K(pre_k2)) prek2=Double.parseDouble(pre_k2.getText());
				else prek2=-1;
			}
			public void focusGained(FocusEvent e) {
				pre_k2.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		pre_a1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(pre_a1)) prea1=Double.parseDouble(pre_a1.getText());
				else prea1=-1;
			}
			public void focusGained(FocusEvent e) {
				pre_a1.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		pre_a2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(pre_a2)) prea2=Double.parseDouble(pre_a2.getText());
				else prea2=-1;
			}
			public void focusGained(FocusEvent e) {
				pre_a2.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		pos_k1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_K(pos_k1)) posk1=Double.parseDouble(pos_k1.getText());
				else posk1=-1;
			}
			public void focusGained(FocusEvent e) {
				pos_k1.setBorder(defaultBorder);
				errorinfo2.setVisible(false);
			}
		});
		
		pos_k2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_K(pos_k2)) posk2=Double.parseDouble(pos_k2.getText());
				else posk2=-1;
			}
			public void focusGained(FocusEvent e) {
				pos_k2.setBorder(defaultBorder);
				errorinfo2.setVisible(false);
			}
		});
		
		pos_a1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(pos_a1)) posa1=Double.parseDouble(pos_a1.getText());
				else posa1=-1;
			}
			public void focusGained(FocusEvent e) {
				pos_a1.setBorder(defaultBorder);
				errorinfo2.setVisible(false);
			}
		});
		
		pos_a2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(pos_a2)) posa2=Double.parseDouble(pos_a2.getText());
				else posa2=-1;
			}
			public void focusGained(FocusEvent e) {
				pos_a2.setBorder(defaultBorder);
				errorinfo2.setVisible(false);
			}
		});
	}
	
	public boolean readyT() {
		return (prek1!=-1 && prek2!=-1 && prea1!=-1 && prea2!=-1);
	}
	
	public boolean readyS() {
		return (prek1!=-1 && prek2!=-1 && prea1!=-1 && prea2!=-1 &&
				posk1!=-1 && posk2!=-1 && posa1!=-1 && posa2!=-1);
	}
	
	private void get_TIA() {
		if(readyT() && parent.subjective.readyT()) {
			preinfo=new pre_info_IOL(prek1,prek2,prea1,prea2,
					parent.subjective.inS,parent.subjective.inC,parent.subjective.inA);
			parent.subjective.preinfo=preinfo;
			parent.parent.output.cornea.Output_TIA(preinfo);
			parent.parent.output.subjective.Output_TIA(preinfo);
			System.out.println("pre_info_iol calculated");
		}
		else {
			System.out.println("aborted due to lack of arguments");
			errorinfo1.setVisible(true);
			parent.subjective.errorinfo1.setVisible(true);
		}
	}
	
	private void get_SIA() {
		if(readyS() && parent.subjective.readyS()) {
			preinfo=new pre_info_IOL(prek1,prek2,prea1,prea2,
					parent.subjective.inS,parent.subjective.inC,parent.subjective.inA);
			parent.subjective.preinfo=preinfo;
			posinfo=new pos_info_IOL(posk1,posk2,posa1,posa2,
					parent.subjective.outS,parent.subjective.outC,parent.subjective.outA,
					parent.subjective.iolS,parent.subjective.iolC,parent.subjective.iolA,
					preinfo);
			parent.subjective.posinfo=posinfo;
			parent.parent.output.cornea.Output_analisis(preinfo, posinfo);
			parent.parent.output.subjective.Output_analisis(preinfo, posinfo);
			System.out.println("pos_info_iol calculated");
		}
		else {
			System.out.println("aborted due to lack of arguments");
			errorinfo2.setVisible(true);
			parent.subjective.errorinfo2.setVisible(true);
		}
	}
	
	private boolean check_K(JTextField tf) {
		try {
			if(tf.getText().equals("")) throw new Custum_Exception();
			double k=Double.parseDouble(tf.getText());
			if(k<0) throw new Exception();
			tf.setBorder(defaultBorder);
			return true;
		}
		catch(Custum_Exception ce) {
			tf.setBorder(defaultBorder);
			return false;
		}
		catch(Exception e){
			tf.setBorder(warningBorder);
			return false;
		}
	}
	
	private boolean check_A(JTextField tf) {
		try {
			if(tf.getText().equals("")) throw new Custum_Exception();
			double a=Double.parseDouble(tf.getText());
			if(a<0||a>180) throw new Exception();
			tf.setBorder(defaultBorder);
			return true;
		}
		catch(Custum_Exception ce) {
			tf.setBorder(defaultBorder);
			return false;
		}
		catch(Exception e){
			tf.setBorder(warningBorder);
			return false;
		}
	}
}
