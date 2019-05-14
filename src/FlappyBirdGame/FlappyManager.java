package FlappyBirdGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class FlappyManager {

	Bird angry;
	GreenPipes obstacle;
	
	FlappyManager(Bird b) {
		angry = b;
		Random PipeY = new Random();
		int PipeH = PipeY.nextInt(FlappyBird.yBorder - 100) + 50;
		obstacle = new GreenPipes(FlappyBird.xBorder, PipeH, 175, 300);
	}
	
	void update() {
		angry.update();
		obstacle.update();
	}
	
	void draw(Graphics g) {
		angry.draw(g);
		obstacle.draw(g);
	}
}
	
