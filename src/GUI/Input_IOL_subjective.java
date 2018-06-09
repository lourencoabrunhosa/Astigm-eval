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

public class Input_IOL_subjective extends JPanel {

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
	
	double inS=-100;
	double inC=-100;
	double inA=-1;
	
	double outS=-100;
	double outC=-100;
	double outA=-1;
	
	double iolS=-100;
	double iolC=-100;
	double iolA=-1;
	
	pre_info preinfo;
	pos_info posinfo;
	
	public Input_IOL_subjective(Input_IOL parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(244,600));
		setLayout(null);
		
		this.parent=parent;
		
		Font section_head= new Font("Tahoma",Font.PLAIN,12);
		Font label = new Font("Tahoma",Font.BOLD,12);
		
		defaultBorder=(new JTextField()).getBorder();
		warningBorder=BorderFactory.createLineBorder(Color.RED);
		
		errorinfo1 = new JLabel("Please insert valid data");
		errorinfo1.setForeground(Color.RED);
		errorinfo1.setFont(new Font("Tahoma",Font.BOLD,8));
		errorinfo1.setBounds(100, 265, 489, 20);
		errorinfo1.setVisible(false);
		add(errorinfo1);
		
		errorinfo2 = new JLabel("Please insert valid data");
		errorinfo2.setForeground(Color.RED);
		errorinfo2.setFont(new Font("Tahoma",Font.BOLD,8));
		errorinfo2.setBounds(100, 295, 489, 20);
		errorinfo2.setVisible(false);
		add(errorinfo2);
		
		JLabel JLabel_1 = new JLabel("Pre Surgery Data: ");
		JLabel_1.setFont(section_head);
		JLabel_1.setBounds(10,10,150,20);
		
		JLabel JLabel_2 = new JLabel("sphr");
		JLabel_2.setFont(label);
		JLabel_2.setBounds(20,40,80,20);
		
		JLabel JLabel_3 = new JLabel("cyl");
		JLabel_3.setFont(label);
		JLabel_3.setBounds(20,70,80,20);
		
		JLabel JLabel_4 = new JLabel("axis");
		JLabel_4.setFont(label);
		JLabel_4.setBounds(110,70,80,20);
		
		add(JLabel_1);
		add(JLabel_2);
		add(JLabel_3);
		add(JLabel_4);
		
		JTextField in_S=new JTextField();
		in_S.setBounds(50,40,45,20);
		
		JTextField in_C=new JTextField();
		in_C.setBounds(50,70,45,20);
		
		JTextField in_A=new JTextField();
		in_A.setBounds(140,70,45,20);
		
		add(in_S);
		add(in_C);
		add(in_A);
		
		JLabel JLabel_5 = new JLabel("Post Surgery Data: ");
		JLabel_5.setFont(section_head);
		JLabel_5.setBounds(10,100,150,20);
		
		JLabel JLabel_6 = new JLabel("sphr");
		JLabel_6.setFont(label);
		JLabel_6.setBounds(20,130,80,20);
		
		JLabel JLabel_7 = new JLabel("cyl");
		JLabel_7.setFont(label);
		JLabel_7.setBounds(20,160,80,20);
		
		JLabel JLabel_8 = new JLabel("axis");
		JLabel_8.setFont(label);
		JLabel_8.setBounds(110,160,80,20);
		
		add(JLabel_5);
		add(JLabel_6);
		add(JLabel_7);
		add(JLabel_8);
		
		JTextField out_S=new JTextField();
		out_S.setBounds(50,130,45,20);
		
		JTextField out_C=new JTextField();
		out_C.setBounds(50,160,45,20);
		
		JTextField out_A=new JTextField();
		out_A.setBounds(140,160,45,20);
		
		add(out_S);
		add(out_C);
		add(out_A);
		
		JLabel JLabel_9 = new JLabel("Intra Ocular Lens:");
		JLabel_9.setFont(section_head);
		JLabel_9.setBounds(10,190,150,20);
		
		JLabel JLabel_10 = new JLabel("sphr");
		JLabel_10.setFont(label);
		JLabel_10.setBounds(20,220,80,20);
		
		JLabel JLabel_11 = new JLabel("cyl");
		JLabel_11.setFont(label);
		JLabel_11.setBounds(20,250,80,20);
		
		JLabel JLabel_12 = new JLabel("axis");
		JLabel_12.setFont(label);
		JLabel_12.setBounds(110,250,80,20);
		
		add(JLabel_9);
		add(JLabel_10);
		add(JLabel_11);
		add(JLabel_12);
		
		JTextField iol_S=new JTextField();
		iol_S.setBounds(50,220,45,20);
		
		JTextField iol_C=new JTextField();
		iol_C.setBounds(50,250,45,20);
		
		JTextField iol_A=new JTextField();
		iol_A.setBounds(140,250,45,20);
		
		add(iol_S);
		add(iol_C);
		add(iol_A);
		
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
		
		in_S.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_SC(in_S)) inS=Double.parseDouble(in_S.getText());
				else inS=-1;
			}
			public void focusGained(FocusEvent e) {
				in_S.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		in_C.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_SC(in_C)) inC=Double.parseDouble(in_C.getText());
				else inC=-1;
			}
			public void focusGained(FocusEvent e) {
				in_C.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		in_A.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(in_A)) inA=Double.parseDouble(in_A.getText());
				else inA=-1;
			}
			public void focusGained(FocusEvent e) {
				in_A.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		out_S.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_SC(out_S)) outS=Double.parseDouble(out_S.getText());
				else outS=-1;
			}
			public void focusGained(FocusEvent e) {
				out_S.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		out_C.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_SC(out_C)) outC=Double.parseDouble(out_C.getText());
				else outC=-1;
			}
			public void focusGained(FocusEvent e) {
				out_C.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		out_A.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(out_A)) outA=Double.parseDouble(out_A.getText());
				else outA=-1;
			}
			public void focusGained(FocusEvent e) {
				out_A.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		iol_S.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_SC(iol_S)) iolS=Double.parseDouble(iol_S.getText());
				else iolS=-1;
			}
			public void focusGained(FocusEvent e) {
				iol_S.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		iol_C.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_SC(iol_C)) iolC=Double.parseDouble(iol_C.getText());
				else iolC=-1;
			}
			public void focusGained(FocusEvent e) {
				iol_C.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		iol_A.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(check_A(iol_A)) iolA=Double.parseDouble(iol_A.getText());
				else iolA=-1;
			}
			public void focusGained(FocusEvent e) {
				iol_A.setBorder(defaultBorder);
				errorinfo1.setVisible(false);
			}
		});
		
		

	}
	
	public boolean readyT() {
		return (inS!=-100 &&  inC!=-100 &&  inA!=-1);
	}
	
	public boolean readyS() {
		return ( inS!=-100 &&  inC!=-100 &&  inA!=-1 &&
				outS!=-100 && outC!=-100 && outA!=-1 &&
				iolS!=-100 && iolC!=-100 && iolA!=-1);
	}
	
	private void get_TIA() {
		if(readyT() && parent.cornea.readyT()) {
			preinfo=new pre_info_IOL(parent.cornea.prek1,parent.cornea.prek2,parent.cornea.prea1,parent.cornea.prea2,
					inS,inC,inA);
			parent.cornea.preinfo=preinfo;
			System.out.println("pre_info_iol calculated");
		}
		else {
			System.out.println("aborted due to lack of arguments");
			errorinfo1.setVisible(true);
			parent.cornea.errorinfo1.setVisible(true);
		}
	}
	
	private void get_SIA() {
		if(readyS() && parent.subjective.readyS()) {
			preinfo=new pre_info_IOL(parent.cornea.prek1,parent.cornea.prek2,parent.cornea.prea1,parent.cornea.prea2,
					inS,inC,inA);
			parent.cornea.preinfo=preinfo;
			posinfo=new pos_info_IOL(parent.cornea.posk1,parent.cornea.posk2,parent.cornea.posa1,parent.cornea.posa2,
					outS,outC,outA,
					iolS,iolC,iolA,
					preinfo);
			parent.cornea.posinfo=posinfo;
			System.out.println("pos_info_iol calculated");
		}
		else {
			System.out.println("aborted due to lack of arguments");
			errorinfo2.setVisible(true);
			parent.subjective.errorinfo2.setVisible(true);
		}
	}
	
	private boolean check_SC(JTextField tf) {
		try {
			if(tf.getText().equals("")) throw new Custum_Exception();
			Double.parseDouble(tf.getText());
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
