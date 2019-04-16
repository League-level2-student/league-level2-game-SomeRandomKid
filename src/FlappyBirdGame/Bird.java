package FlappyBirdGame;

import java.awt.Color;
import java.awt.Graphics;

public class Bird extends FlappyObject {
	
	int speed;

	Bird(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = -5;
	}
	
	void update() {
		super.update();
		y -= speed;
	}
	
	void draw(Graphics g) {
		 g.setColor(Color.YELLOW);
	        g.fillRect(x, y, width, height);

	}

}