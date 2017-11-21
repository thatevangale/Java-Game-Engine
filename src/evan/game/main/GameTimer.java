package evan.game.main;

public class GameTimer {
	
	private long lastTime, deltaTime;
	private int fpsCount;
	
	public void init() {
		lastTime = System.nanoTime();
	}
	
	public void calculate() {
		long currentTime = System.nanoTime();
		deltaTime += currentTime - lastTime;
		lastTime = currentTime;
		fpsCount++;
		
		if (deltaTime > 1e9) {
			deltaTime -= 1e9;
			fpsCount = 0;
		}
	}
	
	public int getFPS() {
		return fpsCount;
	}

}
