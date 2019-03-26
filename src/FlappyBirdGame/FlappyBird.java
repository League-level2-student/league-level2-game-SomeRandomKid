package FlappyBirdGame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FlappyBird {
	JFrame Frame;
	public static int xBorder = 1920;
	public static int yBorder = 1080;
	FlappyPanel Panel;
	
	FlappyBird() {
	Frame = new JFrame();
	Panel = new FlappyPanel();
	Frame.getContentPane().setPreferredSize(new Dimension(xBorder, yBorder));
	Frame.pack();
	}
	
	public static void main(String[] args) {
		FlappyBird game = new FlappyBird();
		game.setup();
	}
	
	public void setup() {
		Frame.add(Panel);
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel.startGame();
	}
}
