package get_stats;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.Base_frame;

public class Stats_Show extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	Base_frame parent;
	
	final String[] colnames= {"Variable", "min", "Max", "Remove"};
	DefaultTableModel my_model;
	
	public Stats_Show(Base_frame parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(260,600));
		setLayout(null);
		
		this.parent=parent;
		
		my_model=new DefaultTableModel(null,colnames);
		
		JTable filter_table=new JTable(my_model);
		
		filter_table.setDefaultRenderer(Object.class, new ColorRenderer());
		
		JScrollPane sp=new JScrollPane(filter_table);
		sp.setBounds(50,50,240,200);
		
		filter_table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i=filter_table.getSelectedRow();
				if(filter_table.getSelectedColumn()==3) my_model.removeRow(i);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton addFilter = new JButton("Add Filter");
		addFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				newfilter();
			}
		});
		addFilter.setBounds(50,10,100,30);
		
		JButton removeFilters = new JButton("Remove all Filters");
		removeFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				my_model.setDataVector(null,colnames);
			}
		});
		removeFilters.setBounds(150,10,100,30);
		
		JButton getStats = new JButton("Get Stats");
		getStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println(Stats.getStats(1, my_model.getDataVector(), parent.doc.getDataBaseName()+"ref"));
			}
		});
		getStats.setBounds(100,270,100,30);
		
		add(sp);
		add(addFilter);
		add(removeFilters);
		add(getStats);
	}
	
	public void newfilter() {
		Stats_Show origin=this;
		Thread t=new Thread(new Runnable() {
			public void run() {
				try {
					Filter_Frame frame = new Filter_Frame(origin);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

}
