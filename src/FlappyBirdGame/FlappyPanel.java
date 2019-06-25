package FlappyBirdGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyPanel extends JPanel implements ActionListener, KeyListener {
	Timer frameRate;
	FlappyObject obj;
	final int START_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = START_STATE;
	Font titleFont;
	Font subFont;
	Bird Flappy = new Bird(910, 540, 40, 40);
	FlappyManager manager = new FlappyManager(Flappy);
	   public static BufferedImage FlappyBGImg;
	   public static BufferedImage FlappyBi;
	   public static BufferedImage TopPipe;
	   public static BufferedImage BottomPipe;


	FlappyPanel() {
		frameRate = new Timer(1000 / 60, this);
		obj = new FlappyObject(10, 10, 100, 100);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 24);
		 try {
           FlappyBGImg = ImageIO.read(this.getClass().getResourceAsStream("FB Background.jpg"));
           FlappyBi = ImageIO.read(this.getClass().getResourceAsStream("FlappyBird.jpg"));
           TopPipe = ImageIO.read(this.getClass().getResourceAsStream("TopPipe.png"));
           BottomPipe = ImageIO.read(this.getClass().getResourceAsStream("BottomPipe.png"));
         
         
     } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		obj.update();
		if (currentState == START_STATE) {
			updateStartState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	void startGame() {
		frameRate.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		obj.draw(g);
		if (currentState == START_STATE) {
			drawStartState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = START_STATE;
			}
			if (currentState == GAME_STATE) {
				Flappy = new Bird(910, 540, 50, 50);
				manager = new FlappyManager(Flappy);
				FlappyManager.score= 0; 
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(currentState == START_STATE) {
				JOptionPane.showMessageDialog(null, "Press 'SPACE' to go up. Release to go down. Try to get yor highest score.");
			}
			Flappy.up = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Flappy.up = false;
			Flappy.speed = -18;
		}
	}

	void updateStartState() {

	}

	void updateGameState() {
		manager.update();
		manager.checkCollision();
		if (Flappy.isAlive == false) {
			currentState++;
			if (currentState == END_STATE) {
				updateEndState();
			}
		}
	}

	void updateEndState() {

	}

	void drawStartState(Graphics g) {
		  g.drawImage(FlappyPanel.FlappyBGImg, 0, 0, FlappyBird.xBorder, FlappyBird.yBorder, null);
		//g.fillRect(0, 0, FlappyBird.xBorder, FlappyBird.yBorder);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString("FlAppy BiRd", 820, 220);
		g.setColor(Color.RED);
		g.drawString("Press 'ENTER' to start", 725, 540);
		g.setFont(subFont);
		g.drawString("Press 'SPACE' for instructions", 800, 700);
		

	}

	void drawGameState(Graphics g) {
		 g.drawImage(FlappyPanel.FlappyBGImg, 0, 0, FlappyBird.xBorder, FlappyBird.yBorder, null);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		 g.drawImage(FlappyPanel.FlappyBGImg, 0, 0, FlappyBird.xBorder, FlappyBird.yBorder, null);
		g.setFont(titleFont);
		g.setColor(Color.ORANGE);
		g.drawString("Game Over", 820, 220);
		g.drawString("Score: " + manager.getScore(), 850, 500);
		g.setFont(subFont);
		g.drawString("Press 'ENTER' to go to Menu", 805, 700);

	}

}
