package FlappyBirdGame;

import java.awt.Graphics;

public class FlappyManager {
	
	Bird angry;
	
	FlappyManager(Bird b) {
		angry = b;
	}
	
	void update() {
		angry.update();
	}
	
	void draw(Graphics g) {
		angry.draw(g);
	}
}
