package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.BLACK);
		
		Font regular = g.getFont();
		
		g.drawLine(80, 255, 80, 55);
		g.drawLine(80, 255, 460, 255);
		
		int xstep=(460-80)/20;
		int ystep=(255-55)/20;
		
		int x=80+xstep;
		int y=255-ystep;
		
		g.drawString("0", 70, 270);
		
		double labelstep=max/10;
		double label=labelstep;
		for(int i=0;i<10;i++) {
			
			g.drawLine(x, 255, x, 257);
			g.drawLine(80, y, 78, y);
			
			
			x+=xstep;
			y-=ystep;
			
			g.drawLine(x, 255, x, 260);
			g.drawLine(80, y, 75, y);
			
			try {
				g.drawString(""+Round.round(label,1), x-g.getFontMetrics().stringWidth(""+Round.round(label,1))/2, 275);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				g.drawString(""+Round.round(label,1), 75-g.getFontMetrics().stringWidth(""+Round.round(label,1)), y+5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			x+=xstep;
			y-=ystep;
			label+=labelstep;
		}
		
		g.drawString("TIA Magnitude [D]", 460-2*g.getFontMetrics().stringWidth("TIA Magnitude [D]")/3, 290);
		
		g.setFont(new Font("Tahoma",Font.BOLD,15));
		g.drawString("SIA vs TIA", 225-g.getFontMetrics().stringWidth("SIA vs TIA")/2,20);
		
		g.setColor(Color.GREEN);
		g.drawLine(80+1, 255-1, 460, 55);
		
		g.setColor(Color.YELLOW);
		try {
			g.drawLine((int) Round.round(80+0.5*xporpotion, 0),255-1, 460,(int) Round.round(55+0.5*yporpotion,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			g.drawLine(80+1,(int) Round.round(255-0.5*yporpotion,0), (int) Round.round(460-0.5*xporpotion, 0),55);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setColor(Color.RED);
		try {
			g.drawLine((int) Round.round(80+xporpotion, 0),255-1, 460,(int) Round.round(55+yporpotion,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			g.drawLine(80+1,(int) Round.round(255-yporpotion,0), (int) Round.round(460-xporpotion, 0),55);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setColor(Color.DARK_GRAY);
		for(int i=0;i<data[0].length;i++) {
			try {
				g.fillOval(80-2+(int) Round.round(data[0][i]*xporpotion, 0), 255-3-(int) Round.round(data[1][i]*yporpotion, 0), 5, 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		g.setFont(regular);
		Graphics2D g2d= (Graphics2D) g;
		g2d.rotate(-Math.PI/2,30,150);
		
		g2d.drawString("SIA Magnitude [D]", 30-g2d.getFontMetrics().stringWidth("SIA Magnitude [D]")/2, 150);
	}
}
