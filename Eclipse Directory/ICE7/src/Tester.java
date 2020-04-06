import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Tester extends JFrame implements KeyListener {

	static ICESevenStarter tester;

	
	// again if you want to use Tester as a keyListener, then you should:
	//1. setup the keyListener in the constructor
	//2. setup the three functions for keyListener, you only need to complete one of them
	
	public Tester() {
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new Tester();
		try
		{
			tester = new ICESevenStarter(250, 250);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.addKeyListener((KeyListener) frame);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().add(tester);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getExtendedKeyCode()) 
		{
		case KeyEvent.VK_C:
			tester.setSelection(tester.getCountryOfBirth());
			break;
		case KeyEvent.VK_N:
			tester.setSelection(tester.getNames());
			break;
		case KeyEvent.VK_B:
			tester.setSelection("Bye!");;
			break;
		default:
			break;
		}
		tester.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
