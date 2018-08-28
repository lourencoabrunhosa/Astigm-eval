package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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
			
		
		g.setColor(Color.BLACK);
		
		g.drawLine(50,225,440,225);
		g.drawLine(50, 225, 50, 21);
		
		for(int i=1;i<=10;i++) {
			g.drawLine(50+i*39, 225, 50+i*39, 230);
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(50+i*39, 225, 50+i*39, 25);
			g.setColor(Color.BLACK);
		}
		
		for(int i=1;i<=17;i++) {
			g.drawLine(50, 225-i*12, 45, 225-i*12);
		}
		
		g.setColor(Color.BLUE);
		for(int i=0;i<data[0].length;i++) {
			try {
				g.fillRect(51, 225-(i+1)*12-3,((int) Round.round(data[1][i]*porpotion,0)), 6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		g.setColor(Color.BLACK);
		double val=0;
		for(int i=0;i<=10;i++) {
			g.drawString(""+val,50+i*39-g.getFontMetrics().stringWidth(""+val)/2,242);
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
			
			g.drawString(xlabels1[i], 40-g.getFontMetrics().stringWidth(xlabels1[i]), 225-(i+1)*12+g.getFontMetrics().getHeight()/4);
		}
	}
}
