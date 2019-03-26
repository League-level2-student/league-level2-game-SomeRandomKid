package FlappyBirdGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyPanel extends JPanel implements ActionListener{
	Timer frameRate;
	
	FlappyPanel() {
		frameRate = new Timer(1000/60, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("lol");
	}
	
	void startGame() {
		frameRate.start();
	}

}
