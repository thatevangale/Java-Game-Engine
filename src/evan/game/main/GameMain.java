package evan.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameMain extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String TITLE = "Hello World!";
	
	//private static final long TARGET_FPS = 60;
	
	protected GameTimer timer;
	
	protected Thread thread;
	
	private volatile boolean running = false;
	
	public GameMain() {
		timer = new GameTimer();
		timer.init();
	}
	
	private void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@Override
	public void run() {
		while (running) {
			input();
			update();
			render();
		}
	}
	
	private void input() {
		// TODO Auto-generated method stub
		
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void render() {
		
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

	public static void main(String[] args) {
		GameMain game = new GameMain();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jframe = new JFrame(TITLE);
				jframe.add(game);
				jframe.setPreferredSize(new Dimension(WIDTH, HEIGHT));
				jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe.setResizable(false);
				jframe.pack();
				jframe.setLocationRelativeTo(null);
				jframe.setVisible(true);
				
				game.start();
			}
		});
	}

}
