package get_stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Graphics.Graphic_Show;

public class Stats_Intro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	Stats_Panel parent;
	
	final String[] colnames= {"Variable", "min", "Max", "Remove"};

	DefaultTableModel my_model;
	
	public Stats_Intro(Stats_Panel parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(270,600));
		setLayout(null);
		
		this.parent=parent;
		
		my_model=new DefaultTableModel(null,colnames);
		
		JTable filter_table=new JTable(my_model);
		
		filter_table.setDefaultRenderer(Object.class, new ColorRenderer());
		
		filter_table.getColumnModel().getColumn(0).setPreferredWidth(140);
		filter_table.getColumnModel().getColumn(1).setPreferredWidth(35);
		filter_table.getColumnModel().getColumn(2).setPreferredWidth(35);
		filter_table.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		JScrollPane sp=new JScrollPane(filter_table);
		sp.setBounds(10,50,260,200);
		
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
		addFilter.setBounds(10,10,100,30);
		
		JButton removeFilters = new JButton("Remove all Filters");
		removeFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				my_model.setDataVector(null,colnames);
				
				filter_table.getColumnModel().getColumn(0).setPreferredWidth(140);
				filter_table.getColumnModel().getColumn(1).setPreferredWidth(35);
				filter_table.getColumnModel().getColumn(2).setPreferredWidth(35);
				filter_table.getColumnModel().getColumn(3).setPreferredWidth(50);
			}
		});
		removeFilters.setBounds(110,10,150,30);
		
		JComboBox<String> surgery=new JComboBox<String>();
		surgery.addItem("Refractive surgery");
		surgery.addItem("IOL implant");
		surgery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		surgery.setBounds(10,270,150,30);
		
		JButton getStats = new JButton("Get Stats");
		getStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(surgery.getSelectedIndex()==0)parent.output.showREF();
				else parent.output.showIOLSub();
			}
		});
		getStats.setBounds(170,270,100,30);
		
		JButton back = new JButton("Return");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				parent.parent.getContentPane().removeAll();
				parent.parent.getContentPane().add(parent.parent.patient_panel, BorderLayout.PAGE_START);
				parent.parent.getContentPane().add(parent.parent.features);
				parent.parent.getContentPane().revalidate();
				parent.parent.getContentPane().repaint();
			}
		});
		back.setBounds(170,330,100,30);
		
		JButton getGraphics = new JButton("get Graphics");
		getGraphics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				newplot();
			}
		});
		getGraphics.setBounds(170,300,100,30);
		
		add(sp);
		add(addFilter);
		add(removeFilters);
		add(getStats);
		add(back);
		add(surgery);
		add(getGraphics);
	}
	
	public void newfilter() {
		Stats_Intro origin=this;
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
	
	public void newplot() {
		Thread t2= new Thread(new Runnable() {
			public void run() {
				try {
					Graphic_Show frame = new Graphic_Show();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t2.start();
	}

}
