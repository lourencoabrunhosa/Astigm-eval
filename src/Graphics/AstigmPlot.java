package Graphics;

import java.awt.Canvas;
import java.awt.Color;
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
		g.drawArc(200, 200, 50, 50, 0, 180);
		g.drawArc(175, 175, 100, 100, 0, 180);
		g.drawArc(150, 150, 150, 150, 0, 180);
		g.drawArc(125, 125, 200, 200, 0, 180);
		g.drawArc(100, 100, 250, 250, 0, 180);
		g.drawArc(75, 75, 300, 300, 0, 180);
		
		g.drawLine(225, 225, 400, 225);
		g.drawLine(225, 225, 50, 225);
		g.drawLine(225, 225, 225, 50);
		
		g.drawLine(225, 225, 377, 138);
		g.drawLine(225, 225, 313, 73);
		g.drawLine(225, 225, 400, 225);
		
		g.drawLine(225, 225, 73, 138);
		g.drawLine(225, 225, 137, 73);
		g.drawLine(225, 225, 50, 225);
		
		g.drawLine(225, 225, 225, 230);
		g.drawLine(200, 225, 200, 230);
		g.drawLine(175, 225, 175, 230);
		g.drawLine(150, 225, 150, 230);
		g.drawLine(125, 225, 125, 230);
		g.drawLine(100, 225, 100, 230);
		g.drawLine(75, 225, 75, 230);
		
		g.drawLine(250, 225, 250, 230);
		g.drawLine(275, 225, 275, 230);
		g.drawLine(300, 225, 300, 230);
		g.drawLine(325, 225, 325, 230);
		g.drawLine(350, 225, 350, 230);
		g.drawLine(375, 225, 375, 230);
		
		
		
		
		/**
		 * Creates color "axis" 
		 */
		g.drawRect(425, 25, 30, 202);
		
		int y=26;
		for(double c=1;c>=0;c-=0.01) {
			g.setColor(ColorMap.colorMap(c));
			g.fillRect(426, y, 28, 2);
			y+=2;
		}
		g.setColor(Color.BLACK);
		y=25;
		for(int x=0;x<10;x++) {
			g.drawLine(455, y, 460, y);
			g.drawLine(455, y+10, 457, y+10);
			y+=20;
		}
		g.drawLine(455, 227, 460, 227);
		
		
		
		/**
		 * Creates subtitles
		 */
		
		g.drawString("0°",405,225);
		g.drawString("30°",385,135);
		g.drawString("60°",315,70);
		g.drawString("90°",220,45);
		g.drawString("120°",110,70);
		g.drawString("150°",45,135);
		g.drawString("180°",20,225);
		
		double step=(maxS-minS)/10;
		double val=maxS;
		y=28;
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
			g.drawString(""+Round.round(val,1),465 , 230);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		step=maxC/6;
		val=maxC;
		g.drawString("0", 221, 245);
		for(int x=1;x<7;x++) {
			try {
				g.drawString(""+Round.round((x*step),1), 218+(x*25), 245);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				g.drawString(""+Round.round((x*step),1), 218-(x*25), 245);
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
				g.fillOval((int) Round.round(data[1][i]*porpotion, 0)+223,223-((int) Round.round(data[2][i]*porpotion, 0)), 5, 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(theta,225+µcx*porpotion,225-µcy*porpotion);
		
		try {
			g2d.drawOval((int) Round.round(225+(µcx-Math.sqrt(l1*5.991))*porpotion,0),(int) Round.round(225-(µcy+Math.sqrt(l2*5.991))*porpotion,0),(int) Round.round(2*porpotion*Math.sqrt(l1*5.991),0),(int) Round.round(2*porpotion*Math.sqrt(l2*5.991),0));
			System.out.println("cenas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBounds(int x,int y) {
		super.setBounds(x,y,500,300);
	}

}
