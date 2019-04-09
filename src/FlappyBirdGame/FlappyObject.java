package FlappyBirdGame;

import java.awt.Graphics;

public class FlappyObject {
	 int x;
     int y;
     int width;
     int height;
     
     FlappyObject(int x, int y, int width, int height) {
    	 this.x = x; this.y = y; this.width = width; this.height = height;
     }
     
     void update() {
    	 x += 5;
     }
     
     void draw(Graphics g) {
    		g.fillRect(x, y, 100, 100);
     }
}
