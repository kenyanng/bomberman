package uet.oop.bomberman.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SetGame implements WindowListener, ActionListener {

    private Frame _frame;
    private JFrame _dialog;
    private JTextField _code;
    private boolean _valid = false;

    public SetGame(Frame f) {
        _frame = f;

        _dialog = new JFrame("Next Level !!");
        final JButton button = new JButton("Load!");
        button.addActionListener(this);

        JPanel pane = new JPanel(new BorderLayout());
        _code = new JTextField("1");

        pane.add(new JLabel("Level: "), BorderLayout.WEST);
        pane.add(_code, BorderLayout.CENTER);
        pane.add(button, BorderLayout.PAGE_END);

        _dialog.getContentPane().add(pane);
        _dialog.setLocationRelativeTo(f);
        _dialog.setSize(400, 100);
        _dialog.setVisible(true);
        _dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        _dialog.addWindowListener(this);

    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if(_valid == false)
            _frame.resumeGame();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
        _frame.pauseGame();
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code = _code.getText();
        int co = (int) Long.parseLong(code);
        if( co > 0) {
            _frame.changeLevel(co);
            _valid = true;
            _dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(_frame,
                    "Nhap Level :",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
