package gui;

import java.awt.event.*;
import javax.swing.*;
import java.io.PrintWriter;

public class RMenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 4739059537960077853L;
	PrintWriter pw = new PrintWriter(System.out, true);
	public RMenuBar(){
	JMenu fileMenu = new JMenu("File");
	//fileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
	//fileMenu.setAccelerator();
	
	JMenuItem fileOpenItem = new JMenuItem("Open",KeyEvent.VK_O);
	fileOpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
	fileOpenItem.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			OpenFile();
		}
	});
	
	JMenuItem fileFindItem = new JMenuItem("Find..",KeyEvent.VK_F);
	fileFindItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
	fileFindItem.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			OpenFile();
		}
	});	
	//Exit Button
	JMenuItem fileExitItem = new JMenuItem("Exit",KeyEvent.VK_X);
	fileExitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
	fileExitItem.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			pw.println("Now my watch is ended!");
			System.exit(0);
		}
	});
	fileMenu.add(fileOpenItem);
	fileMenu.add(fileFindItem);
	fileMenu.add(fileExitItem);
	this.add(fileMenu);
	}
	
	private void OpenFile(){
		
	}
}
