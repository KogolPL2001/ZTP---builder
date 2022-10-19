package pl.wipb.ztp.ps3;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Mario {
	public static void main(String[] args)	{
		
		System.setProperty("sun.java2d.opengl", "true");	
		
		JFrame frame = new JFrame("Mario");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JScrollPane(new Game("/data/plansza01.txt")));
		frame.pack();
		frame.setVisible(true);
	}
}
