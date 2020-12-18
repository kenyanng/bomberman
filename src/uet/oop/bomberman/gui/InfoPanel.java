package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;
import javax.swing.*;
import java.awt.*;

/**
 * Swing Panel hiển thị thông tin thời gian, điểm mà người chơi đạt được
 */
public class InfoPanel extends JPanel {
	
	private JLabel timeLabel;
	private JLabel pointsLabel;
	private JLabel livesLabel;
	private JLabel highScore;
        
	public InfoPanel(Game game) {
		setLayout(new GridLayout());

		livesLabel = new JLabel("Lives: " + game.getBoard().getLives());
		livesLabel.setForeground(Color.WHITE);
		livesLabel.setHorizontalAlignment(JLabel.CENTER);

		pointsLabel = new JLabel("Points: " + game.getBoard().getPoints());
		pointsLabel.setForeground(Color.WHITE);
		pointsLabel.setHorizontalAlignment(JLabel.CENTER);

		highScore = new JLabel("High Scores : " + game.getBoard().getHighScores());
		highScore.setForeground(Color.WHITE);
		highScore.setHorizontalAlignment(JLabel.CENTER);

		timeLabel = new JLabel("Time: " + game.getBoard().getTime());
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);

		add(livesLabel);
		add(pointsLabel);
		add(highScore);
		add(timeLabel);
		setBackground(Color.black);
		setPreferredSize(new Dimension(0, 40));
	}


	public void setPoints(int t) {
		pointsLabel.setText("Points: " + t);
	}

	public void setLives(int t) {
		livesLabel.setText("Lives: " + t);
        }

	public void setTime(int t) {
		timeLabel.setText("Time: " + t);
	}
	
}
