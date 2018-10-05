package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import data_structures.Round;

public class HorizontalBars extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double[][] data;
	double max;
	
	public HorizontalBars(double[][] data) {
	 this.data=data;
	 for(int i=0;i<data[0].length;i++) {
		 if(data[1][i]>max)max=data[1][i];
	 }
	 max=Math.min(10.0*((int) max/10)+10, 100);
	 setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		double porpotion=(390/max);
			
		Font regular = g.getFont();
		
		g.setColor(Color.BLACK);
		
		g.drawLine(90,255,480,255);
		g.drawLine(90, 255, 90, 51);
		
		for(int i=1;i<=10;i++) {
			g.drawLine(90+i*39, 255, 90+i*39, 260);
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(90+i*39, 255, 90+i*39, 55);
			g.setColor(Color.BLACK);
		}
		
		for(int i=1;i<=17;i++) {
			g.drawLine(90, 255-i*12, 85, 255-i*12);
		}
		
		g.setColor(Color.BLUE);
		for(int i=0;i<data[0].length;i++) {
			try {
				g.fillRect(91, 255-(i+1)*12-3,((int) Round.round(data[1][i]*porpotion,0)), 6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		g.setColor(Color.BLACK);
		
		g.drawString("[%]", 470, 285);
		
		double val=0;
		for(int i=0;i<=10;i++) {
			g.drawString(""+val,90+i*39-g.getFontMetrics().stringWidth(""+val)/2,272);
			val+=max/10;
		}
		
		String[] xlabels1= {"<-75","-75 - -65","-65 - -55","-55 - -45",
								   "-45 - -35","-35 - -25","-25 - -15",
								   "-15 - -5","-5 - 5","5 - 15",
								   "15 - 25","25 - 35","35 - 45",
								   "45 - 55","55 - 65","65 - 75",
							">75"};
 		
		g.setFont(new Font(getFont().getFontName(),getFont().getStyle(),8));
		for(int i=0;i<xlabels1.length;i++) {
			
			g.drawString(xlabels1[i], 80-g.getFontMetrics().stringWidth(xlabels1[i]), 255-(i+1)*12+g.getFontMetrics().getHeight()/4);
		}
		
		g.setFont(new Font(regular.getFontName(),Font.BOLD,15));
		
		g.drawString("Axial difference between SIA and TIA", 250-g.getFontMetrics().stringWidth("Axial difference between SIA and TIA")/2, 20);
		
		g.setFont(regular);
		Graphics2D g2d= (Graphics2D) g;
		g2d.rotate(-Math.PI/2,30,150);
		
		g2d.drawString("Axial difference [°]", 30-g2d.getFontMetrics().stringWidth("Axial difference [°]")/2, 150);
	}
}
