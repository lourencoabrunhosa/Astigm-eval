package get_stats;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data_structures.Round;

public class Stats_Out_IOL_Sub extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param parent 
	 */
	
	protected final int PRE_SURGERY=1;
	protected final int TIA_SURGERY=2;
	protected final int POS_SURGERY=3;
	protected final int SIA_SURGERY=4;
	protected final int DIFF_SURGERY=5;
	protected final int CI_SURGERY=6;
	
	protected final int REAL_IOL_AXIS=13;
	protected final int IOL_LENS=14;
	protected final int IOL_AXIS_DESV=15;
	
	Stats_Panel parent;
	
	JLabel Title;
	JLabel Title2;
	JLabel in;
	JLabel tia;
	JLabel in_vals;
	JLabel tia_vals;
	
	JLabel out;
	JLabel sia;
	JLabel diff;
	JLabel ci;
	JLabel ria;
	JLabel il;
	JLabel iad;
	JLabel out_vals;
	JLabel sia_vals;
	JLabel diff_vals;
	JLabel ci_val;
	JLabel ria_val;
	JLabel il_vals;
	JLabel iad_val;
	
	public Stats_Out_IOL_Sub(Stats_Panel parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(418,600));
		setLayout(null);
		
		this.parent=parent;
		
		Title=new JLabel("Statistical outcomes for selected");
		Title.setFont(new Font("Tahoma",Font.BOLD,16));
		Title.setBounds(10,10,350,20);
		add(Title);
		
		Title2=new JLabel("IOL implants");
		Title2.setFont(new Font("Tahoma",Font.BOLD,16));
		Title2.setBounds(10,30,350,20);
		add(Title2);
		
		in=new JLabel("Pre-surgery: ");
		in.setFont(new Font("Tahoma",Font.BOLD,12));
		in.setBounds(20,100,100,20);
		add(in);
		
		tia=new JLabel("TIA: ");
		tia.setFont(new Font("Tahoma",Font.BOLD,12));
		tia.setBounds(20,150,100,20);
		add(tia);
		
		double[][] stat=Stats.getStats(PRE_SURGERY,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		in_vals=new JLabel(writeAst(stat));
		in_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		in_vals.setBounds(120,95,250,30);
		add(in_vals);
		
		stat=Stats.getStats(TIA_SURGERY,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		tia_vals=new JLabel(writeAst(stat));
		tia_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		tia_vals.setBounds(120,145,250,30);
		add(tia_vals);
		
		out=new JLabel("Post-surgery: ");
		out.setFont(new Font("Tahoma",Font.BOLD,12));
		out.setBounds(20,200,100,20);
		add(out);
		
		sia=new JLabel("SIA: ");
		sia.setFont(new Font("Tahoma",Font.BOLD,12));
		sia.setBounds(20,250,100,20);
		add(sia);
		
		diff=new JLabel("difference: ");
		diff.setFont(new Font("Tahoma",Font.BOLD,12));
		diff.setBounds(20,300,100,20);
		add(diff);
		
		ci=new JLabel("Correction Index: ");
		ci.setFont(new Font("Tahoma",Font.BOLD,12));
		ci.setBounds(20,350,150,20);
		add(ci);
		
		ci=new JLabel("IOL real axis: ");
		ci.setFont(new Font("Tahoma",Font.BOLD,12));
		ci.setBounds(20,400,150,20);
		add(ci);
		
		ci=new JLabel("IOL: ");
		ci.setFont(new Font("Tahoma",Font.BOLD,12));
		ci.setBounds(20,450,150,20);
		add(ci);
		
		ci=new JLabel("IOL axis desv.: ");
		ci.setFont(new Font("Tahoma",Font.BOLD,12));
		ci.setBounds(20,500,150,20);
		add(ci);
		
		stat=Stats.getStats(POS_SURGERY,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		out_vals=new JLabel(writeAst(stat));
		out_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		out_vals.setBounds(120,195,250,30);
		add(out_vals);
		
		stat=Stats.getStats(SIA_SURGERY,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		sia_vals=new JLabel(writeAst(stat));
		sia_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		sia_vals.setBounds(120,245,250,30);
		add(sia_vals);
		
		stat=Stats.getStats(DIFF_SURGERY,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		diff_vals=new JLabel(writeAst(stat));
		diff_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		diff_vals.setBounds(120,295,250,30);
		add(diff_vals);
		
		stat=Stats.getStats(CI_SURGERY,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		ci_val=new JLabel(writePer(stat));
		ci_val.setFont(new Font("Tahoma",Font.PLAIN,12));
		ci_val.setBounds(140,345,250,30);
		add(ci_val);
		
		stat=Stats.getStats(REAL_IOL_AXIS,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		ria_val=new JLabel(writeVal(stat));
		ria_val.setFont(new Font("Tahoma",Font.PLAIN,12));
		ria_val.setBounds(140,395,250,30);
		add(ria_val);
		
		stat=Stats.getStats(IOL_LENS,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		il_vals=new JLabel(writeAst(stat));
		il_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		il_vals.setBounds(140,445,250,30);
		add(il_vals);
		
		stat=Stats.getStats(IOL_AXIS_DESV,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		iad_val=new JLabel(writeVal(stat));
		iad_val.setFont(new Font("Tahoma",Font.PLAIN,12));
		iad_val.setBounds(140,495,250,30);
		add(iad_val);
		
		JButton seeCornea = new JButton("Cornea Stats");
		seeCornea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				parent.output.showIOLCor();
			}
		});
		seeCornea.setBounds(250,520,150,30);
		add(seeCornea);
	}
	
	private String writeAst(double[][] results) {
		try {
			return Round.round(results[0][0],2)+" / "+Round.round(results[0][1],2)+","+Round.round(results[0][2],2)+" ± "+
					Round.round(results[1][0],2)+" / "+Round.round(results[1][1],2)+","+Round.round(results[1][2],2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No data available";
		}
	}
	
	private String writeVal(double[][] results) {
		try {
			return Round.round(results[0][0],2)+" ± "+Round.round(results[1][0],2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No data available";
		}
	}
	
	private String writePer(double[][] results) {
		try {
			return Round.round(results[0][0]*100,2)+"% ± "+Round.round(results[1][0]*100,2)+"%";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No data available";
		}
	}

}
