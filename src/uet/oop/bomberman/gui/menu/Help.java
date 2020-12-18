package uet.oop.bomberman.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import uet.oop.bomberman.gui.Frame;

public class Help extends JMenu {

    public Help(Frame frame)  {
        super("Help");


        JMenuItem helpgame = new JMenuItem("Tutorial");
        helpgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        helpgame.addActionListener(new MenuActionListener(frame));
        add(helpgame);


        JMenuItem news = new JMenuItem("Infor");
        news.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        news.addActionListener(new MenuActionListener(frame));
        add(news);

    }

    class MenuActionListener implements ActionListener {
        public Frame _frame;
        public MenuActionListener(Frame frame) {
            _frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("Tutorial")) {
                JOptionPane.showMessageDialog(_frame,
                        "Di chuyển: W,A,S,D hoặc UP,DOWN, RIGHT, LEFT (Phím điều hướng)\nĐặt Bombs: SPACE hoặc X",
                        "Cách chơi",
                        JOptionPane.WARNING_MESSAGE);
            }

            if(e.getActionCommand().equals("Infor")) {
                JOptionPane.showMessageDialog(_frame,
                        "Version 1.0 \nNguồn Lượm nhặt:))",
                        "Vesion",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}