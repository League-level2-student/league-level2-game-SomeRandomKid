package FlappyBirdGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyPanel extends JPanel implements ActionListener, KeyListener{
	Timer frameRate;
	FlappyObject obj;
	final int START_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = START_STATE;
	Font titleFont;
	Bird Flappy = new Bird(910, 540, 50, 50);
	
	FlappyPanel() {
		frameRate = new Timer(1000/60, this);
		obj = new FlappyObject(10, 10, 100, 100);
		titleFont = new Font("Arial" , Font.PLAIN, 48);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		obj.update();
		  if(currentState == START_STATE){
              updateStartState();
		  }
		  else if(currentState == GAME_STATE){
              updateGameState();
		  }
		  else if(currentState == END_STATE){
              updateEndState();
      }
	}
	
	void startGame() {
		frameRate.start();
	}
	@Override
	public void paintComponent(Graphics g){
	obj.draw(g);
	 if(currentState == START_STATE){
         drawStartState(g);
	 }
	 else if(currentState == GAME_STATE){
         drawGameState(g);
	 }
	 else if(currentState == END_STATE){
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
		currentState++;
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		if(currentState > END_STATE){
            currentState = START_STATE;
		}
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	void updateStartState() {
		
	}
	
	void updateGameState() {
		Flappy.update();
	}
	
	void updateEndState() {
		
	}
	
	void drawStartState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, FlappyBird.xBorder, FlappyBird.yBorder); 
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
        g.drawString("FlAppy BiRd", 820, 220);

	}
	
	void drawGameState (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FlappyBird.xBorder, FlappyBird.yBorder);
		Flappy.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, FlappyBird.xBorder, FlappyBird.yBorder);
		g.setFont(titleFont);
		g.setColor(Color.ORANGE);
		g.drawString("Game Over", 820, 220 );
	}

}
