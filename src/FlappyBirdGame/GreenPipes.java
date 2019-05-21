package FlappyBirdGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class GreenPipes extends FlappyObject{

	Rectangle topPipe;
	Rectangle bottomPipe;
	
	GreenPipes(int x, int y, int width, int height) {
		super(x, y, width, height);
		topPipe = new Rectangle(x, y, width, height);
		bottomPipe = new Rectangle(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		super.update();
		x-=6;
		if (x <= 0) {
			Random PipeY = new Random();
			y = PipeY.nextInt(FlappyBird.yBorder - 100) + 50;
			x = FlappyBird.xBorder;
		}
		
		topPipe.setBounds(x, 0, width, y);
		bottomPipe.setBounds(x, y+height, width, FlappyBird.yBorder-(y+height));
	}
	
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, 0, width, y);
		g.fillRect(x, y+height, width, FlappyBird.yBorder-(y+height));
	}

}
