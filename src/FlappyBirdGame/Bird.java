package FlappyBirdGame;

import java.awt.Color;
import java.awt.Graphics;

public class Bird extends FlappyObject {
	
	int speed;
	boolean up = false;

	Bird(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 0;
	}
	
	void update() {
		super.update();
		y += speed;
		speed++;
	if (y  < 0) {
		y = 0;
	}
	}
	
	void draw(Graphics g) {
		 g.drawImage(FlappyPanel.FlappyBi, x, y, width, height, null);

	}

}
