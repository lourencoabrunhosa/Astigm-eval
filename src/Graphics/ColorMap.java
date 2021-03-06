package Graphics;

import java.awt.Color;

public class ColorMap {
	
	final private static Color[] pallet= 
			   {new Color(0,0,250),
				new Color(0,5,245),
				new Color(0,10,240),
				new Color(0,15,235),
				new Color(0,20,230),
				new Color(0,25,225),
				new Color(0,30,220),
				new Color(0,35,215),
				new Color(0,40,210),
				new Color(0,45,205),
				new Color(0,50,200),
				new Color(0,55,195),
				new Color(0,60,190),
				new Color(0,65,185),
				new Color(0,70,180),
				new Color(0,75,175),
				new Color(0,80,170),
				new Color(0,85,165),
				new Color(0,90,160),
				new Color(0,95,155),
				new Color(0,100,150),
				new Color(0,105,145),
				new Color(0,110,140),
				new Color(0,115,135),
				new Color(0,120,130),
				new Color(0,125,125),
				new Color(0,130,120),
				new Color(0,135,115),
				new Color(0,140,110),
				new Color(0,145,105),
				new Color(0,150,100),
				new Color(0,155,95),
				new Color(0,160,90),
				new Color(0,165,85),
				new Color(0,170,80),
				new Color(0,175,75),
				new Color(0,180,70),
				new Color(0,185,65),
				new Color(0,190,60),
				new Color(0,195,55),
				new Color(0,200,50),
				new Color(0,205,45),
				new Color(0,210,40),
				new Color(0,215,35),
				new Color(0,220,30),
				new Color(0,225,25),
				new Color(0,230,20),
				new Color(0,235,15),
				new Color(0,240,10),
				new Color(0,245,5),
				new Color(0,250,0),
				new Color(5,245,0),
				new Color(10,240,0),
				new Color(15,235,0),
				new Color(20,230,0),
				new Color(25,225,0),
				new Color(30,220,0),
				new Color(35,215,0),
				new Color(40,210,0),
				new Color(45,205,0),
				new Color(50,200,0),
				new Color(55,195,0),
				new Color(60,190,0),
				new Color(65,185,0),
				new Color(70,180,0),
				new Color(75,175,0),
				new Color(80,170,0),
				new Color(85,165,0),
				new Color(90,160,0),
				new Color(95,155,0),
				new Color(100,150,0),
				new Color(105,145,0),
				new Color(110,140,0),
				new Color(115,135,0),
				new Color(120,130,0),
				new Color(125,125,0),
				new Color(130,120,0),
				new Color(135,115,0),
				new Color(140,110,0),
				new Color(145,105,0),
				new Color(150,100,0),
				new Color(155,95,0),
				new Color(160,90,0),
				new Color(165,85,0),
				new Color(170,80,0),
				new Color(175,75,0),
				new Color(180,70,0),
				new Color(185,65,0),
				new Color(190,60,0),
				new Color(195,55,0),
				new Color(200,50,0),
				new Color(205,45,0),
				new Color(210,40,0),
				new Color(215,35,0),
				new Color(220,30,0),
				new Color(225,25,0),
				new Color(230,20,0),
				new Color(235,15,0),
				new Color(240,10,0),
				new Color(245,5,0),
				new Color(250,0,0)
			};
	
	
	public static Color colorMap(double x) {
		return pallet[(int) Math.floor(x*100)];
		
	}
}
