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

import data_structures.pre_info;
import data_structures.pre_info_REF;

public class Input_REF extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	Border defaultBorder;
	JTextField pre_k1;
	JTextField pre_k2;
	JTextField pre_a1;
	JTextField pre_a2;
	
	JTextField pos_k1;
	JTextField pos_k2;
	JTextField pos_a1;
	JTextField pos_a2;
	
	pre_info preinfo;
	public Input_REF(Base_frame parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(225,400));
		setLayout(null);
		
		
		JLabel Jlabel_1 = new JLabel("Pre Surgery Data:");
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_1.setBounds(10, 10, 489, 20);
		
		JLabel Jlabel_2 = new JLabel("K1");
		Jlabel_2.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_2.setBounds(20,50,489,20);
		
		JLabel Jlabel_3 = new JLabel("K2");
		Jlabel_3.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_3.setBounds(20,80,489,20);
		
		JLabel Jlabel_4 = new JLabel("axis 1");
		Jlabel_4.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_4.setBounds(100,50,489,20);
		
		JLabel Jlabel_5 = new JLabel("axis 2");
		Jlabel_5.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_5.setBounds(100,80,489,20);
		
		add(Jlabel_1);
		add(Jlabel_2);
		add(Jlabel_3);
		add(Jlabel_4);
		add(Jlabel_5);
		
		pre_k1=new JTextField();
		defaultBorder=pre_k1.getBorder();
		pre_k1.setBounds(45,50,45,20);
		
		pre_a1 = new JTextField();
		pre_a1.setBounds(140,50,45,20);
		
		pre_k2 = new JTextField();
		pre_k2.setBounds(45,80,45,20);
		
		pre_a2 = new JTextField();
		pre_a2.setBounds(140,80,45,20);
		
		add(pre_k1);
		add(pre_k2);
		add(pre_a1);
		add(pre_a2);
		
		JButton TIA = new JButton("Get TIA");
		TIA.setBounds(100,130,85,25);
		add(TIA);
		
		JLabel Jlabel_6 = new JLabel("Post Surgery Data:");
		Jlabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_6.setBounds(10, 170, 489, 20);
		
		JLabel Jlabel_7 = new JLabel("K1");
		Jlabel_7.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_7.setBounds(20,210,489,20);
		
		JLabel Jlabel_8 = new JLabel("K2");
		Jlabel_8.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_8.setBounds(20,240,489,20);
		
		JLabel Jlabel_9 = new JLabel("axis 1");
		Jlabel_9.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_9.setBounds(100,210,489,20);
		
		JLabel Jlabel_10 = new JLabel("axis 2");
		Jlabel_10.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_10.setBounds(100,240,489,20);
		
		add(Jlabel_6);
		add(Jlabel_7);
		add(Jlabel_8);
		add(Jlabel_9);
		add(Jlabel_10);
		
		pos_k1=new JTextField();
		pos_k1.setBounds(45,210,45,20);
		
		pos_a1 = new JTextField();
		pos_a1.setBounds(140,210,45,20);
		
		pos_k2 = new JTextField();
		pos_k2.setBounds(45,240,45,20);
		
		pos_a2 = new JTextField();
		pos_a2.setBounds(140,240,45,20);
		
		add(pos_k1);
		add(pos_k2);
		add(pos_a1);
		add(pos_a2);
		
		JButton outcomes = new JButton("Analyse Surgery");
		outcomes.setBounds(55,290,130,25);
		add(outcomes);
		

		TIA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_TIA();
				System.out.println("pre_info calculated");
			}
		});
		
		pre_k1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_K(pre_k1);
			}
			public void focusGained(FocusEvent e) {
				pre_k1.setBorder(defaultBorder);
			}
		});
		
		pre_k2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_K(pre_k2);
			}
			public void focusGained(FocusEvent e) {
				pre_k2.setBorder(defaultBorder);
			}
		});
		
		pre_a1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_A(pre_a1);
			}
			public void focusGained(FocusEvent e) {
				pre_a1.setBorder(defaultBorder);
			}
		});
		
		pre_a2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_A(pre_a2);
			}
			public void focusGained(FocusEvent e) {
				pre_a2.setBorder(defaultBorder);
			}
		});
		
		pos_k1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_K(pos_k1);
			}
			public void focusGained(FocusEvent e) {
				pos_k1.setBorder(defaultBorder);
			}
		});
		
		pos_k2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_K(pos_k2);
			}
			public void focusGained(FocusEvent e) {
				pos_k2.setBorder(defaultBorder);
			}
		});
		
		pos_a1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_A(pos_a1);
			}
			public void focusGained(FocusEvent e) {
				pos_a1.setBorder(defaultBorder);
			}
		});
		
		pos_a2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				check_A(pos_a2);
			}
			public void focusGained(FocusEvent e) {
				pos_a2.setBorder(defaultBorder);
			}
		});
	}
	
	private void get_TIA() {
		preinfo=new pre_info_REF(Double.parseDouble(pre_k1.getText()),Double.parseDouble(pre_k2.getText()),Double.parseDouble(pre_a1.getText()),Double.parseDouble(pre_a2.getText()));
	}
	
	private void check_K(JTextField tf) {
		try {
			if(tf.getText().equals("")) throw new Custum_Exception();
			double prek1=Double.parseDouble(tf.getText());
			if(prek1<0) throw new Exception();
			tf.setBorder(defaultBorder);
		}
		catch(Custum_Exception ce) {
			tf.setBorder(defaultBorder);
		}
		catch(Exception e){
			tf.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
	}
	
	private void check_A(JTextField tf) {
		try {
			if(tf.getText().equals("")) throw new Custum_Exception();
			double prek1=Double.parseDouble(tf.getText());
			if(prek1<0||prek1>180) throw new Exception();
			tf.setBorder(defaultBorder);
		}
		catch(Custum_Exception ce) {
			tf.setBorder(defaultBorder);
		}
		catch(Exception e){
			tf.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
	}

}
