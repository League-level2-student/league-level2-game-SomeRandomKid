package FlappyBirdGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class FlappyManager {

	Bird angry;
	GreenPipes obstacle;
	public static int score = 0;
	
	
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
	
	void checkCollision() {
		 if(angry.collisionBox.intersects(obstacle.topPipe)){
             angry.isAlive = false;
     }
		 else if(angry.collisionBox.intersects(obstacle.bottomPipe)){
             angry.isAlive = false;
           
     }
		 else if(angry.y >= FlappyBird.yBorder) {
			 angry.isAlive = false;
		 }
	}
	 int getScore() {
			return score;
		}
}

	
