package process;

import gui.*;
import java.io.PrintWriter;

public class Calc {
	//defaults
	MainUI main;
	public static int MAX_PIXELS = (int)Math.round(MainUI.MAX_HEIGHT*0.70);
	public static int MAX_DIV = (int)Math.round(MainUI.MAX_WIDTH*0.87);
	public static int GAP = (int)Math.round(MainUI.MAX_HEIGHT*0.08);
	//UI variables
	
	double ResS;
	double ResDP;
	double ResM;
	
	//set of variables
	int SSL;
	int SSH;
	int DPSL;
	int DPSH;
	int ML;
	int MH;
	
	//Result array
	public boolean ConFlag = false;
	double[] res = new double[MAX_DIV];
	public int[] y = new int[MAX_DIV];
	public double Max = 0;
	public double Low = 99999;
	public int maxPix;
	public int lowPix;

	PrintWriter pw = new PrintWriter(System.out, true);
	
	public Calc(MainUI main){
		this.main = main;
		pw.println("Ageon: Clydas, Convert them.");
		SSL = ConvertText(main.SSLow);
		SSH = ConvertText(main.SSHigh);
		DPSL = ConvertText(main.DPSLow);
		DPSH = ConvertText(main.DPSHigh);
		ML = ConvertText(main.MLow);
		MH = ConvertText(main.MHigh);
		pw.println("Ageon: "+SSL+" "+SSH+" "+DPSL+" "+DPSH+" "+ML+" "+MH);
		
		if(((SSH-SSL)>=0) & ((DPSH-DPSL)>=0) & ((MH - ML)>=0) & ( ML> 0) ){
			pw.println("Ageon: Looks good, Jon.");
			ConFlag = true;
			pw.println("Ageon: I'll solve this for you!");
			EqSolver();
		}else{
			pw.println("Ageon: I'm sorry Jon.");
		}
	}
	public void EqSolver(){
		ResS = (double)(SSH - SSL )/MAX_DIV;
		ResDP = (double)(DPSH - DPSL)/MAX_DIV;
		ResM = (double)(MH - ML)/MAX_DIV;
		pw.println("Ageon: ResS ="+ResS);
		pw.println("Ageon: ResDP ="+ResDP);
		pw.println("Ageon: ResM = "+ResM);
		pw.println("Ageon: MAX_DIV = "+MAX_DIV);
		
		for( int i =0; i<MAX_DIV; i++){
			res[i] = (Math.sqrt(((SSL+ResS*i)+(DPSL+ResDP*i))/(ML+ResM*i)))/(2*Math.PI);
		}
		pw.println("Ageon: Wn done!");
		for(int i=0; i<MAX_DIV;i++){
			Max = Math.max(Max, res[i]);
			Low = Math.min(Low, res[i]);
		}
		pw.println("Ageon: Max"+Max);
		pw.println("Ageon: Low"+Low);
		for( int i =1; i<MAX_DIV;i++){
			y[i] = toPixel(res[i],Max);
		}
		pw.println("Ageon: Pix from Sam Done!");
		pw.println("Ageon: Max Pix from Sam "+(maxPix = toPixel(Max,Max)));
		pw.println("Ageon: Low pix from Sam "+(lowPix = toPixel(Low,Max)));
	pw.println("Ageon rests in peace");	
	}
	
	public static int toPixel(double val,double Max){
		return((int) (Math.round((val/Max)*MAX_PIXELS)+GAP));
		//pw.println("Sam: Pix "+pixel);
	}
	public int ConvertText(String str){
		int res=0;
		double pow = Math.pow(10, (double)str.length()-1);
		for(int i=0; i<str.length();i++){
			switch(str.charAt(i)){
			case '0' :
				res+= 0*pow;
				break;
			case '1' :
				res+= 1*pow;
				break;
			case '2' :
				res+= 2*pow;
			break;
			case '3' :
				res+= 3*pow;
			break;
			case '4' :
				res+= 4*pow;
			break;
			case '5' :
				res+= 5*pow;
			break;
			case '6' :
				res+= 6*pow;
			break;
			case '7' :
				res+= 7*pow;
			break;
			case '8' :
				res+= 8*pow;
			break;
			case '9' :
				res+= 9*pow;
			break;
			}
			pow /=10;
		}
		pw.println("Clydas: Done "+res);
		return res;
	}
}