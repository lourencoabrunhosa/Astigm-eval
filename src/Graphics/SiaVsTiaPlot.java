package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import data_structures.Round;


public class SiaVsTiaPlot extends Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double max=Double.NEGATIVE_INFINITY;
	
	private double[][] data; 
	
	
	double xporpotion;
	double yporpotion;

	public SiaVsTiaPlot(double[][] data) {
		this.data=data;
		for(int i=0;i<data[0].length;i++) {
			if(data[0][i]>max) max=data[0][i];
			if(data[1][i]>max) max=data[1][i];
		}
		try {
			max=Math.ceil(max);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		xporpotion=(420-40)/max;
		yporpotion=(225-25)/max;
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.BLACK);
		
		g.drawLine(40, 225, 40, 25);
		g.drawLine(40, 225, 420, 225);
		
		int xstep=(420-40)/20;
		int ystep=(225-25)/20;
		
		int x=40+xstep;
		int y=225-ystep;
		
		g.drawString("0", 30, 240);
		
		double labelstep=max/10;
		double label=labelstep;
		for(int i=0;i<10;i++) {
			
			g.drawLine(x, 225, x, 227);
			g.drawLine(40, y, 38, y);
			
			
			x+=xstep;
			y-=ystep;
			
			g.drawLine(x, 225, x, 230);
			g.drawLine(40, y, 35, y);
			
			try {
				g.drawString(""+Round.round(label,1), x-10, 245);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				g.drawString(""+Round.round(label,1), 10, y+5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			x+=xstep;
			y-=ystep;
			label+=labelstep;
		}
		
		
		g.setColor(Color.GREEN);
		g.drawLine(40+1, 225-1, 420, 25);
		
		g.setColor(Color.YELLOW);
		try {
			g.drawLine((int) Round.round(40+0.5*xporpotion, 0),225-1, 420,(int) Round.round(25+0.5*yporpotion,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			g.drawLine(40+1,(int) Round.round(225-0.5*yporpotion,0), (int) Round.round(420-0.5*xporpotion, 0),25);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setColor(Color.RED);
		try {
			g.drawLine((int) Round.round(40+xporpotion, 0),225-1, 420,(int) Round.round(25+yporpotion,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			g.drawLine(40+1,(int) Round.round(225-yporpotion,0), (int) Round.round(420-xporpotion, 0),25);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setColor(Color.DARK_GRAY);
		for(int i=0;i<data[0].length;i++) {
			try {
				g.fillOval(40-2+(int) Round.round(data[0][i]*xporpotion, 0), 225-3-(int) Round.round(data[1][i]*yporpotion, 0), 5, 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
