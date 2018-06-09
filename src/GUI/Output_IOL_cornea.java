package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data_structures.Round;
import data_structures.pos_info;
import data_structures.pos_info_IOL;
import data_structures.pre_info;
import data_structures.pre_info_IOL;

public class Output_IOL_cornea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	Output_IOL parent;
	
	pre_info preinfo;
	pos_info posinfo;
	
	JLabel Title;
	JLabel in;
	JLabel tia;
	JLabel in_vals;
	JLabel tia_vals;
	
	JLabel out;
	JLabel sia;
	JLabel diff;
	JLabel ci;
	JLabel out_vals;
	JLabel sia_vals;
	JLabel diff_vals;
	JLabel ci_val;
	
	public Output_IOL_cornea(Output_IOL parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(390,600));
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
		in_vals.setBounds(80,45,200,30);
		add(in_vals);
		in_vals.setVisible(false);
		
		tia_vals=new JLabel();
		tia_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		tia_vals.setBounds(80,95,200,30);
		add(tia_vals);
		tia_vals.setVisible(false);
		
		out=new JLabel("Output: ");
		out.setFont(new Font("Tahoma",Font.BOLD,12));
		out.setBounds(20,150,100,20);
		add(out);
		out.setVisible(false);
		
		sia=new JLabel("SIA: ");
		sia.setFont(new Font("Tahoma",Font.BOLD,12));
		sia.setBounds(20,200,100,20);
		add(sia);
		sia.setVisible(false);
		
		diff=new JLabel("difference: ");
		diff.setFont(new Font("Tahoma",Font.BOLD,12));
		diff.setBounds(20,250,100,20);
		add(diff);
		diff.setVisible(false);
		
		ci=new JLabel("Correction Index: ");
		ci.setFont(new Font("Tahoma",Font.BOLD,12));
		ci.setBounds(20,300,150,20);
		add(ci);
		ci.setVisible(false);
		
		out_vals=new JLabel();
		out_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		out_vals.setBounds(100,145,150,30);
		add(out_vals);
		out_vals.setVisible(false);
		
		sia_vals=new JLabel();
		sia_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		sia_vals.setBounds(100,195,150,30);
		add(sia_vals);
		sia_vals.setVisible(false);
		
		diff_vals=new JLabel();
		diff_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		diff_vals.setBounds(100,245,150,30);
		add(diff_vals);
		diff_vals.setVisible(false);
		
		ci_val=new JLabel();
		ci_val.setFont(new Font("Tahoma",Font.PLAIN,12));
		ci_val.setBounds(140,295,150,30);
		add(ci_val);
		ci_val.setVisible(false);
	}
	
	public void Output_TIA(pre_info preinfo) {
		this.preinfo=preinfo;
		
		out.setVisible(false);
		sia.setVisible(false);
		diff.setVisible(false);
		ci.setVisible(false);
		
		out_vals.setVisible(false);
		sia_vals.setVisible(false);
		diff_vals.setVisible(false);
		ci_val.setVisible(false);
		
		Title.setText("Presenting outcomes for TIA request");
		in.setVisible(true);
		tia.setVisible(true);
		double[] invals=((pre_info_IOL) preinfo).getPreCornea().show();
		in_vals.setText(Round.round(invals[0],2)+"  /  "+Round.round(invals[1],2)+"    "+Round.round(invals[2],2));
		in_vals.setVisible(true);
		double[] tiavals=((pre_info_IOL) preinfo).getTIACornea().show();
		tia_vals.setText(Round.round(tiavals[0],2)+"  /  "+Round.round(tiavals[1],2)+"    "+Round.round(tiavals[2],2));
		tia_vals.setVisible(true);
		
	}
	
	public void Output_analisis(pre_info preinfo, pos_info posinfo) {
		this.preinfo=preinfo;
		this.posinfo=posinfo;
		
		Title.setText("Presenting outcomes for surgery analisis");
		in.setVisible(true);
		tia.setVisible(true);
		double[] invals=((pre_info_IOL) preinfo).getPreCornea().show();
		in_vals.setText(Round.round(invals[0],2)+"  /  "+Round.round(invals[1],2)+"    "+Round.round(invals[2],2));
		in_vals.setVisible(true);
		double[] tiavals=((pre_info_IOL) preinfo).getTIACornea().show();
		tia_vals.setText(Round.round(tiavals[0],2)+"  /  "+Round.round(tiavals[1],2)+"    "+Round.round(tiavals[2],2));
		tia_vals.setVisible(true);
		
		out.setVisible(true);
		sia.setVisible(true);
		diff.setVisible(true);
		ci.setVisible(true);
		double[] outvals=((pos_info_IOL) posinfo).getPosCornea().show();
		out_vals.setText(Round.round(outvals[0],2)+"  /  "+Round.round(outvals[1],2)+"    "+Round.round(outvals[2],2));
		out_vals.setVisible(true);
		double[] siavals=((pos_info_IOL) posinfo).getSIACornea().show();
		sia_vals.setText(Round.round(siavals[0],2)+"  /  "+Round.round(siavals[1],2)+"    "+Round.round(siavals[2],2));
		sia_vals.setVisible(true);
		double[] diffvals=((pos_info_IOL) posinfo).getDiffCornea().show();
		diff_vals.setText(Round.round(diffvals[0],2)+"  /  "+Round.round(diffvals[1],2)+"    "+Round.round(diffvals[2],2));
		diff_vals.setVisible(true);
		double cival=((pos_info_IOL) posinfo).getCICornea();
		ci_val.setText(Round.round(cival*100,2)+"%");
		ci_val.setVisible(true);
	}

}
