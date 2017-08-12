package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import process.*;
import java.io.PrintWriter;

public class MainUI extends JFrame{
	private static final long serialVersionUID = -6293271488878581581L;
	public static int MAX_WIDTH = 1024;
	public static int MAX_HEIGHT = 680;

	//input Buttons
	JTextField SpringStiffnessLow = new JTextField(8);
	JTextField SpringStiffnessHigh = new JTextField(8);
	JTextField DashpotStiffnessLow = new JTextField(8);
	JTextField DashpotStiffnessHigh = new JTextField(8);
	JTextField MassLow = new JTextField(8);
	JTextField MassHigh = new JTextField(8);
	public String SSLow;
	public String SSHigh;
	public String DPSLow;
	public String DPSHigh;
	public String MLow;
	public String MHigh;
	boolean SetFlag = false;
	
	PrintWriter pw = new PrintWriter(System.out,true);
	
	public JPlotPanel PlotLayout = new JPlotPanel();
	
	public MainUI(){
		
		setTitle("Response Spectra Plotter");
		setSize(MAX_WIDTH,MAX_HEIGHT);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				pw.println("Marsh: For the Watch!");
				System.exit(0);
			}
		});
		//Menu Bar
		RMenuBar menu = new RMenuBar();
		setJMenuBar(menu);
		
		//main Plot Panel
		PlotLayout.setBorder(BorderFactory.createTitledBorder("Response Spectra"));
		PlotLayout.setBackground(Color.WHITE);

		//Input Panel
		
		JPanel InputPanel  = new JPanel();
		InputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		InputPanel.setLayout(new FlowLayout());
		
		//Input Labels
		JLabel LSSL = new JLabel("Ks Low");
		JLabel LSSH = new JLabel("Ks High");
		JLabel LDSL = new JLabel("Kt Low");
		JLabel LDSH = new JLabel("Kt High");
		JLabel LML = new JLabel("Mass Low");
		JLabel LMH = new JLabel("Mass High");
		
		//adding input text field values to Input Panel
		InputPanel.add(LSSL);
		InputPanel.add(SpringStiffnessLow);
		InputPanel.add(LSSH);
		InputPanel.add(SpringStiffnessHigh);
		InputPanel.add(LDSL);
		InputPanel.add(DashpotStiffnessLow);
		InputPanel.add(LDSH);
		InputPanel.add(DashpotStiffnessHigh);
		InputPanel.add(LML);
		InputPanel.add(MassLow);
		InputPanel.add(LMH);
		InputPanel.add(MassHigh);
		//update action
		
		JButton UpdateButton = new JButton("Plot");
		UpdateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pw.println("Men at Wall: Wildlings at the gate!");
				SSLow = SpringStiffnessLow.getText();
				SSHigh =SpringStiffnessHigh.getText();
				DPSLow = DashpotStiffnessLow.getText();
				DPSHigh =DashpotStiffnessHigh.getText();
				MLow = MassLow.getText();
				MHigh = MassHigh.getText();
				SetFlag = true;
				pw.println("Lord Snow: Aegon, is everything under control?");
				Calc Res = new Calc(MainUI.this);
				if(Res.ConFlag){
					pw.println("Lord Snow: "+SSLow+","+SSHigh+","+DPSLow+","+DPSHigh+","+MLow+","+MHigh);
					PlotLayout.setFlag =true;
					PlotLayout.y = Res.y;
					PlotLayout.Max = Res.Max+"000";
					PlotLayout.Low = Res.Low+"000";
					PlotLayout.maxPix = Res.maxPix;
					PlotLayout.lowPix = Res.lowPix;
					PlotLayout.repaint();
					pw.println("Lord Snow: Nice Painting!");
				}
				else{
					pw.println("Lord Snow: Damn The Wildlings!");
				}
				pw.println("Lord Snow: Good bye, Ageon.");
			}
		});
		
		InputPanel.add(UpdateButton);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(PlotLayout,BorderLayout.CENTER);
		getContentPane().add(InputPanel, BorderLayout.SOUTH);

	}
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MainUI main = new MainUI();
				main.setVisible(true);
			}
		});
	}
}