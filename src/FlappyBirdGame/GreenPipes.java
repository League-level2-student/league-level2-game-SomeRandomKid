package FlappyBirdGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GreenPipes extends FlappyObject{

	GreenPipes(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		x-=6;
		if (x <= 0) {
			Random PipeY = new Random();
			y = PipeY.nextInt(FlappyBird.yBorder - 100) + 50;
			x = FlappyBird.xBorder;
		}
	}
	
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, 0, width, y);
		g.fillRect(x, y+height, width, FlappyBird.yBorder-(y+height));
	}

}
