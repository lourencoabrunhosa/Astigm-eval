package get_stats;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Filter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	JComboBox<String> parameters;
	JTextField min;
	JTextField max;
	
	Stats_Show parent;
	Filter_Frame container;
	
	@SuppressWarnings("deprecation")
	public Filter(Stats_Show parent, Filter_Frame container) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(240,200));
		setLayout(null);
		
		this.parent=parent;
		this.container=container;
		
		Font label= new Font("Tahoma", Font.BOLD,12);
		
		JLabel label_1=new JLabel("Parameter: ");
		label_1.setFont(label);
		label_1.setBounds(15,15,150,30);
		
		JLabel label_2=new JLabel("Minumum: ");
		label_2.setFont(label);
		label_2.setBounds(15,50,150,30);
		
		JLabel label_3=new JLabel("Maximum: ");
		label_3.setFont(label);
		label_3.setBounds(15,85,150,30);
		
		parameters = new JComboBox<String>();
		parameters.addItem("Pre Cornea Sphere");
		parameters.addItem("Pre Cornea Cylinder");
		parameters.addItem("Pre Cornea Axis");
		
		parameters.addItem("TIA Cornea Sphere");
		parameters.addItem("TIA Cornea Cylinder");
		parameters.addItem("TIA Cornea Axis");
		
		parameters.addItem("SIA Cornea Sphere");
		parameters.addItem("SIA Cornea Cylinder");
		parameters.addItem("SIA Cornea Axis");
		
		parameters.addItem("Diff Cornea Sphere");
		parameters.addItem("Diff Cornea Cylinder");
		parameters.addItem("Diff Cornea Axis");
		
		parameters.addItem("Pos Cornea Sphere");
		parameters.addItem("Pos Cornea Cylinder");
		parameters.addItem("Pos Cornea Axis");
		
		parameters.addItem("Cornea Correction Index");
		
		parameters.addItem("Pre Subjective Sphere");
		parameters.addItem("Pre Subjective Cylinder");
		parameters.addItem("Pre Subjective Axis");
		
		parameters.addItem("TIA Subjective Sphere");
		parameters.addItem("TIA Subjective Cylinder");
		parameters.addItem("TIA Subjective Axis");
		
		parameters.addItem("SIA Subjective Sphere");
		parameters.addItem("SIA Subjective Cylinder");
		parameters.addItem("SIA Subjective Axis");
		
		parameters.addItem("Diff Subjective Sphere");
		parameters.addItem("Diff Subjective Cylinder");
		parameters.addItem("Diff Subjective Axis");
		
		parameters.addItem("Pos Subjective Sphere");
		parameters.addItem("Pos Subjective Cylinder");
		parameters.addItem("Pos Subjective Axis");
		
		parameters.addItem("Subjective Correction Index");
		
		parameters.setBounds(120,15,200,30);
		
		min=new JTextField();
		min.setBounds(120,50,70,30);
		
		
		max=new JTextField();
		max.setBounds(120,85,70,30);
		
		min.setNextFocusableComponent(max);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				okaction();
			}
		});
		ok.setBounds(200,50,70,30);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cancelaction();
			}
		});
		cancel.setBounds(200,85,70,30);
		
		min.setNextFocusableComponent(max);
		max.setNextFocusableComponent(ok);
		ok.setNextFocusableComponent(cancel);
		
		
		add(label_1);
		add(label_2);
		add(label_3);
		add(parameters);
		add(min);
		add(max);
		add(ok);
		add(cancel);
	}
	private void okaction() {
		Object[] row= {parameters.getSelectedItem(),Double.parseDouble(min.getText()),Double.parseDouble(max.getText())," X "};
		parent.my_model.addRow(row);
		container.setVisible(false);
	}
	private void cancelaction() {
		container.setVisible(false);
	}
}
