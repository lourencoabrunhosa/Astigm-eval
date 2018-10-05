package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import data_structures.Round;



public class AstigmPlot extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private double maxS=Double.NEGATIVE_INFINITY;
	private double minS=Double.POSITIVE_INFINITY;
	
	private double maxC=0.0;
	
	private double[][] data; 
	
	private double µcx=0;
	private double µcy=0;
	private double n;
	private double cov11;
	private double cov12;
	private double cov22;
	
	private double c;
	private double l1;
	private double l2;
	
	private double theta;
	
	
	
	public AstigmPlot(double[][] data) {
		this.data=data;
		n=data[0].length;
		for(int i=0;i<n;i++) {
			µcx+=data[1][i];
			µcy+=data[2][i];
			if(data[0][i]>maxS) maxS=data[0][i];
			if(data[0][i]<minS) minS=data[0][i];
			if(Math.sqrt(Math.pow(data[1][i], 2)+Math.pow(data[2][i], 2))>maxC) maxC=Math.sqrt(Math.pow(data[1][i], 2)+Math.pow(data[2][i], 2));
		}
		try {
			maxC=Round.round(maxC, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		µcx/=n;
		µcy/=n;
		
		cov11=0;
		cov22=0;
		cov12=0;
		for(int i=0;i<n;i++) {
			cov11+=(data[1][i]-µcx)*(data[1][i]-µcx);
			cov22+=(data[2][i]-µcy)*(data[2][i]-µcy);
			cov12+=(data[1][i]-µcy)*(data[2][i]-µcy);
		}
		cov11/=n;
		cov22/=n;
		cov12/=n;
		
		
		
		l1=((cov11+cov22)+Math.sqrt((cov11*cov11)+4*(cov12*cov12)+(cov22*cov22)-2*cov11*cov22))/2;
		l2=((cov11+cov22)-Math.sqrt((cov11*cov11)+4*(cov12*cov12)+(cov22*cov22)-2*cov11*cov22))/2;
		
		c=(l1+l2)/2;
		
		if(cov12>=0) theta=-(Math.acos((cov11-c)/(l1-c)))/2;
		else if(cov11>l1) theta=0;
		else theta=(Math.acos((cov11-c)/(l1-c)))/2;
		
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		
		/**
		 * Creates half polar axis grid
		 */
		g.drawArc(200, 230, 50, 50, 0, 180);
		g.drawArc(175, 205, 100, 100, 0, 180);
		g.drawArc(150, 180, 150, 150, 0, 180);
		g.drawArc(125, 155, 200, 200, 0, 180);
		g.drawArc(100, 130, 250, 250, 0, 180);
		g.drawArc(75, 105, 300, 300, 0, 180);
		
		g.drawLine(225, 255, 400, 255);
		g.drawLine(225, 255, 50, 255);
		g.drawLine(225, 255, 225, 80);
		
		g.drawLine(225, 255, 377, 168);
		g.drawLine(225, 255, 313, 103);
		g.drawLine(225, 255, 400, 255);
		
		g.drawLine(225, 255, 73, 168);
		g.drawLine(225, 255, 137, 103);
		g.drawLine(225, 255, 50, 255);
		
		g.drawLine(225, 255, 225, 260);
		g.drawLine(200, 255, 200, 260);
		g.drawLine(175, 255, 175, 260);
		g.drawLine(150, 255, 150, 260);
		g.drawLine(125, 255, 125, 260);
		g.drawLine(100, 255, 100, 260);
		g.drawLine(75, 255, 75, 260);
		
		g.drawLine(250, 255, 250, 260);
		g.drawLine(275, 255, 275, 260);
		g.drawLine(300, 255, 300, 260);
		g.drawLine(325, 255, 325, 260);
		g.drawLine(350, 255, 350, 260);
		g.drawLine(375, 255, 375, 260);
		
		
		
		
		/**
		 * Creates color "axis" 
		 */
		g.drawRect(425, 55, 30, 202);
		
		int y=56;
		for(double c=1;c>=0;c-=0.01) {
			g.setColor(ColorMap.colorMap(c));
			g.fillRect(426, y, 28, 2);
			y+=2;
		}
		g.setColor(Color.BLACK);
		y=55;
		for(int x=0;x<10;x++) {
			g.drawLine(455, y, 460, y);
			g.drawLine(455, y+10, 457, y+10);
			y+=20;
		}
		g.drawLine(455, 257, 460, 257);
		
		
		
		/**
		 * Creates subtitles
		 */
		
		g.drawString("0°",405,255);
		g.drawString("30°",385,165);
		g.drawString("60°",315,100);
		g.drawString("90°",220,75);
		g.drawString("120°",110,100);
		g.drawString("150°",45,165);
		g.drawString("180°",20,255);
		
		double step=(maxS-minS)/10;
		double val=maxS;
		y=58;
		for(int i=0;i<10;i++) {
			try {
				g.drawString(""+Round.round(val,1),465 , y);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			val-=step;
			y+=20;
		}
		try {
			g.drawString(""+Round.round(val,1),465 , 260);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		step=maxC/6;
		val=maxC;
		g.drawString("0", 221, 275);
		for(int x=1;x<7;x++) {
			try {
				g.drawString(""+Round.round((x*step),1), 218+(x*25), 275);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				g.drawString(""+Round.round((x*step),1), 218-(x*25), 275);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * Plots points
		 */
		
		double porpotion=(6*25)/maxC;
		
		for(int i=0;i<data[0].length;i++) {
			g.setColor(ColorMap.colorMap((data[0][i]-minS)/(maxS-minS)));
			try {
				g.fillOval((int) Round.round(data[1][i]*porpotion, 0)+223,253-((int) Round.round(data[2][i]*porpotion, 0)), 5, 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		g.setColor(Color.BLACK);
		
		g.drawString("Cyl [D]", 390-g.getFontMetrics().stringWidth("Cyl [D]")/2, 290);
		g.drawString("Sphr [D]", 425-2*g.getFontMetrics().stringWidth("Sphr [D]")/3, 45);
		g.setFont(new Font("Tahoma",Font.BOLD,15));
		g.drawString("Difference observed at this surgery group",225-g.getFontMetrics().stringWidth("Difference observed at this surgery group")/2,20);
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(theta,225+µcx*porpotion,255-µcy*porpotion);
		
		try {
			g2d.drawOval((int) Round.round(225+(µcx-Math.sqrt(l1*5.991))*porpotion,0),(int) Round.round(255-(µcy+Math.sqrt(l2*5.991))*porpotion,0),(int) Round.round(2*porpotion*Math.sqrt(l1*5.991),0),(int) Round.round(2*porpotion*Math.sqrt(l2*5.991),0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBounds(int x,int y) {
		super.setBounds(x,y,530,310);
	}

}
