package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data_structures.Round;
import data_structures.pos_info;
import data_structures.pre_info;

public class Output_REF extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	REF_case parent;
	
	pre_info preinfo;
	pos_info posinfo;
	
	JLabel Title;
	JLabel in;
	JLabel tia;
	JLabel in_vals;
	JLabel tia_vals;
	
	public Output_REF(REF_case parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(370,400));
		setLayout(null);
		
		this.parent=parent;
		
		Title=new JLabel();
		Title.setFont(new Font("Tahoma",Font.BOLD,16));
		Title.setBounds(10,10,350,20);
		add(Title);
		
		in=new JLabel("Input: ");
		in.setFont(new Font("Tahoma",Font.BOLD,12));
		in.setBounds(20,50,100,20);
		add(in);
		in.setVisible(false);
		
		tia=new JLabel("TIA: ");
		tia.setFont(new Font("Tahoma",Font.BOLD,12));
		tia.setBounds(20,100,100,20);
		add(tia);
		tia.setVisible(false);
		
		in_vals=new JLabel();
		in_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		//in_vals.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		in_vals.setBounds(80,45,200,30);
		add(in_vals);
		in_vals.setVisible(false);
		
		tia_vals=new JLabel();
		tia_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		//tia_vals.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tia_vals.setBounds(80,95,200,30);
		add(tia_vals);
		tia_vals.setVisible(false);
	}
	
	public void Output_TIA(pre_info preinfo) {
		this.preinfo=preinfo;
		
		Title.setText("Presenting outcomes for TIA request");
		in.setVisible(true);
		tia.setVisible(true);
		double[] invals=preinfo.getPre().show();
		in_vals.setText(Round.round(invals[0],2)+"  /  "+Round.round(invals[1],2)+"    "+Round.round(invals[2],2));
		in_vals.setVisible(true);
		double[] tiavals=preinfo.getTIA().show();
		tia_vals.setText(Round.round(tiavals[0],2)+"  /  "+Round.round(tiavals[1],2)+"    "+Round.round(tiavals[2],2));
		tia_vals.setVisible(true);
		
	}
	
	public void Output_analisis(pre_info preinfo, pos_info posinfo) {
		this.preinfo=preinfo;
		this.posinfo=posinfo;
	}

}
