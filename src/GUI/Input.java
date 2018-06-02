package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Input(Base_frame parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(225,300));
		setLayout(null);
		
		
		JLabel Jlabel_1 = new JLabel("Pre Surgery Data:");
		Jlabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_1.setBounds(10, 10, 489, 20);
		
		JLabel Jlabel_2 = new JLabel("K1");
		Jlabel_2.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_2.setBounds(20,35,489,20);
		
		JLabel Jlabel_3 = new JLabel("K2");
		Jlabel_3.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_3.setBounds(20,65,489,20);
		
		JLabel Jlabel_4 = new JLabel("axis 1");
		Jlabel_4.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_4.setBounds(100,35,489,20);
		
		JLabel Jlabel_5 = new JLabel("axis 2");
		Jlabel_5.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_5.setBounds(100,65,489,20);
		
		add(Jlabel_1);
		add(Jlabel_2);
		add(Jlabel_3);
		add(Jlabel_4);
		add(Jlabel_5);
		
		JTextField pre_k1=new JTextField();
		pre_k1.setBounds(45,35,45,20);
		
		JTextField pre_a1 = new JTextField();
		pre_a1.setBounds(140,35,45,20);
		
		JTextField pre_k2 = new JTextField();
		pre_k2.setBounds(45,65,45,20);
		
		JTextField pre_a2 = new JTextField();
		pre_a2.setBounds(140,65,45,20);
		
		add(pre_k1);
		add(pre_k2);
		add(pre_a1);
		add(pre_a2);
		
		JButton TIA = new JButton("Get TIA");
		TIA.setBounds(100,110,85,25);
		add(TIA);
		
		JLabel Jlabel_6 = new JLabel("Post Surgery Data:");
		Jlabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jlabel_6.setBounds(10, 130, 489, 20);
		
		JLabel Jlabel_7 = new JLabel("K1");
		Jlabel_7.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_7.setBounds(20,155,489,20);
		
		JLabel Jlabel_8 = new JLabel("K2");
		Jlabel_8.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_8.setBounds(20,185,489,20);
		
		JLabel Jlabel_9 = new JLabel("axis 1");
		Jlabel_9.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_9.setBounds(100,155,489,20);
		
		JLabel Jlabel_10 = new JLabel("axis 2");
		Jlabel_10.setFont(new Font("Tahoma", Font.BOLD,12));
		Jlabel_10.setBounds(100,185,489,20);
		
		add(Jlabel_6);
		add(Jlabel_7);
		add(Jlabel_8);
		add(Jlabel_9);
		add(Jlabel_10);
		
		JTextField pos_k1=new JTextField();
		pos_k1.setBounds(45,155,45,20);
		
		JTextField pos_a1 = new JTextField();
		pos_a1.setBounds(140,155,45,20);
		
		JTextField pos_k2 = new JTextField();
		pos_k2.setBounds(45,185,45,20);
		
		JTextField pos_a2 = new JTextField();
		pos_a2.setBounds(140,185,45,20);
		
		add(pos_k1);
		add(pos_k2);
		add(pos_a1);
		add(pos_a2);
		
		JButton outcomes = new JButton("Analyse Surgery");
		outcomes.setBounds(55,230,130,25);
		add(outcomes);
	}

}
