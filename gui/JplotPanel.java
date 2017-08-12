package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.PrintWriter;
import javax.swing.JPanel;
import process.Calc;

class JPlotPanel extends JPanel{
	private static final long serialVersionUID = -3533139197129903285L;
	boolean setFlag = false;
	int[] y = new int[Calc.MAX_DIV];
	String Max;
	String Low;
	int maxPix;
	int lowPix;
	PrintWriter pw = new PrintWriter(System.out,true);
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawString("wn", 10,(int)Math.round(MainUI.MAX_HEIGHT*0.45));
		g.drawString("setup",(int)Math.round(MainUI.MAX_WIDTH*0.45),(int)Math.round(MainUI.MAX_HEIGHT*0.82));
		
		g.setColor(Color.LIGHT_GRAY);
		
		g.drawLine(40, (int)Math.round(MainUI.MAX_HEIGHT*0.8), (int)Math.round(MainUI.MAX_WIDTH*0.95),(int)Math.round(MainUI.MAX_HEIGHT*0.8));
		g.drawLine(40, (int)Math.round(MainUI.MAX_HEIGHT*0.08), 40, (int)Math.round(MainUI.MAX_HEIGHT*0.8));
		
		//Vertical Line Triangle
		int[] polxv = {35,40,45};
		int[] polyv = {(int)Math.round(MainUI.MAX_HEIGHT*0.08),(int)Math.round(MainUI.MAX_HEIGHT*0.08)-10,(int)Math.round(MainUI.MAX_HEIGHT*0.08)};
		g.fillPolygon(polxv, polyv, 3);
		
		//Horizontal Line Triangle
		int[] polxh ={(int)Math.round(MainUI.MAX_WIDTH*0.95),(int)Math.round(MainUI.MAX_WIDTH*0.95)+10,(int)Math.round(MainUI.MAX_WIDTH*0.95)};
		int[] polyh = {(int)Math.round(MainUI.MAX_HEIGHT*0.8)-5,(int)Math.round(MainUI.MAX_HEIGHT*0.8),(int)Math.round(MainUI.MAX_HEIGHT*0.8)+5};
		g.fillPolygon(polxh, polyh, 3);
		
		if(setFlag){
			int j=1;
			for(int i = Calc.MAX_DIV-1; i>1; i--){
				//pw.println("Dolorous Edd: Sam told "+y[i]+" for "+(j+40));
				g.setColor(Color.RED);
				g.drawLine(j+40,y[i],j+40,y[i-1]);
				j++;
			}
			g.setColor(Color.BLUE);
			g.drawString("Max",10,lowPix+10);
			g.drawString(Max.substring(0,4),10,lowPix);
			g.drawString(Low.substring(0,4), 10, maxPix);
			g.drawString("Low",10,maxPix+10);
			g.drawString("Max Wn = "+Max, MainUI.MAX_WIDTH-200 , 40);
			g.drawString("Min Wn = "+Low, MainUI.MAX_WIDTH-200, 50);
			pw.println("Dolorous Edd: Painting the Wall..");
		}else{
			pw.println("Dolorous Edd: No brush, No paint.");
		}

		g.setColor(Color.GRAY);
		g.setFont(new Font("GreekS",Font.BOLD,20));
		g.drawString("ResSpect", MainUI.MAX_WIDTH - 150, 25);
		
	}
}