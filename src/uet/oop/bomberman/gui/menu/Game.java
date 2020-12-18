package uet.oop.bomberman.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.gui.SetGame;

public class Game extends JMenu {

	public Frame frame;
	
	public Game(Frame frame) {
		super("Menu");
		this.frame = frame;

		// Ctrl+N tạo game mới
		JMenuItem newgame = new JMenuItem("New Game");
		newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newgame.addActionListener(new MenuActionListener(frame));
		add(newgame);
		
		// Ctrl+T chọn level để chơi
		JMenuItem scores = new JMenuItem("Set Game");
		scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		scores.addActionListener(new MenuActionListener(frame));
		add(scores);
	}
	
	class MenuActionListener implements ActionListener {
		public Frame _frame;

		public MenuActionListener(Frame frame) {
			_frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("New Game")) {
				_frame.newGame();
			}
			if (e.getActionCommand().equals("Set Game")) {
				new SetGame(_frame);
			}
		}
	}
}
