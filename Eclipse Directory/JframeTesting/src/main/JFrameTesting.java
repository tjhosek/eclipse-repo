package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameTesting {
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setTitle("T a n e");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.BLUE);
//		panel.setPreferredSize(new Dimension(300,100));
//		JLabel label = new JLabel("This is my label");
//		panel.add(label);
//		frame.getContentPane().add(panel);
//		frame.pack();
//		frame.setVisible(true);
		
		RectangleComponent component = new RectangleComponent();
		frame.add(component);
		frame.setVisible(true);
		
	}
}
