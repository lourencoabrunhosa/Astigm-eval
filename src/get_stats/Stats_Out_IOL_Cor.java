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

public class Stats_Out_IOL_Cor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param parent 
	 */
	
	protected final int PRE_CORNEA=7;
	protected final int TIA_CORNEA=8;
	protected final int POS_CORNEA=9;
	protected final int SIA_CORNEA=10;
	protected final int DIFF_CORNEA=11;
	protected final int CI_CORNEA=12;
	
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
	JLabel out_vals;
	JLabel sia_vals;
	JLabel diff_vals;
	JLabel ci_val;
	
	public Stats_Out_IOL_Cor(Stats_Panel parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(418,600));
		setLayout(null);
		
		this.parent=parent;
		
		Title=new JLabel("Statistical outcomes for selected");
		Title.setFont(new Font("Tahoma",Font.BOLD,16));
		Title.setBounds(10,10,350,20);
		add(Title);
		
		Title2=new JLabel("IOL implant surgeries - Cornea");
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
		
		double[][] stat=Stats.getStats(PRE_CORNEA,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		in_vals=new JLabel(writeAst(stat));
		in_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		in_vals.setBounds(120,95,250,30);
		add(in_vals);
		
		stat=Stats.getStats(TIA_CORNEA,
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
		
		stat=Stats.getStats(POS_CORNEA,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		out_vals=new JLabel(writeAst(stat));
		out_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		out_vals.setBounds(120,195,250,30);
		add(out_vals);
		
		stat=Stats.getStats(SIA_CORNEA,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		sia_vals=new JLabel(writeAst(stat));
		sia_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		sia_vals.setBounds(120,245,250,30);
		add(sia_vals);
		
		stat=Stats.getStats(DIFF_CORNEA,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		diff_vals=new JLabel(writeAst(stat));
		diff_vals.setFont(new Font("Tahoma",Font.PLAIN,12));
		diff_vals.setBounds(120,295,250,30);
		add(diff_vals);
		
		stat=Stats.getStats(CI_CORNEA,
				parent.input.my_model.getDataVector(),
				parent.parent.doc.getDataBaseName()+"iol");
		
		ci_val=new JLabel(writePer(stat));
		ci_val.setFont(new Font("Tahoma",Font.PLAIN,12));
		ci_val.setBounds(140,345,250,30);
		add(ci_val);
		
		JButton seeSubjective = new JButton("Subjective Stats");
		seeSubjective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				parent.output.removeAll();
				parent.output.add(parent.output.subiolstats);
				parent.output.revalidate();
				parent.output.repaint();
			}
		});
		seeSubjective.setBounds(250,520,150,30);
		add(seeSubjective);
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
