package git.david.logic;

import git.david.Config;
import git.david.Main;
import git.david.Utility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLogic implements KeyListener {

    @Override public void keyTyped(KeyEvent event) {}

    @Override public void keyPressed(KeyEvent event) {
        System.out.println(event.getKeyCode());
        if (event.getKeyCode() == KeyEvent.VK_1 && !Config.hints_visibility) {
            Config.hints_visibility = true;
        } else if (event.getKeyCode() == KeyEvent.VK_1) {
            Config.hints_visibility = false;
        }
        Main.pauseHintLabel.setVisible(Config.hints_visibility);
        Main.speedHintLabel.setVisible(Config.hints_visibility);
        Main.hintsHintLabel.setVisible(Config.hints_visibility);

        if (event.getKeyCode()  == KeyEvent.VK_SPACE && Main.game_running) {
            Main.game_running = false;
            Main.runningStateLabel.setText("Paused");
            Main.runningStateLabel.setBackground(Color.RED);
            event.getComponent().repaint();
            Utility.printColoredText("STOPPED", "red");
        } else if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            Main.game_running = true;
            Main.runningStateLabel.setText("Running");
            Main.runningStateLabel.setBackground(Color.GREEN);
            event.getComponent().repaint();
            Utility.printColoredText("STARTED", "green");
        }
    }

    @Override public void keyReleased(KeyEvent event) {}
}
