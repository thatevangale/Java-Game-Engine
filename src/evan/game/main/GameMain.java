package evan.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameMain extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	//private static final long TARGET_FPS = 60;
	
	protected GameTimer timer;
	
	public GameMain() {
		timer = new GameTimer();
		timer.init();
	}

	public static void main(String[] args) {
		GameMain game = new GameMain();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jframe = new JFrame("Hello World!");
				jframe.add(game);
				jframe.setPreferredSize(new Dimension(WIDTH, HEIGHT));
				jframe.setResizable(false);
				jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe.pack();
				jframe.setLocationRelativeTo(null);
				jframe.setVisible(true);
			}
		});
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		onPaint(g);
	}

	protected void onPaint(Graphics g) {
		// Set background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// Print FPS
		timer.calculate();
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + timer.getFPS(), 30, 30);
		
		repaint();
	}

}
