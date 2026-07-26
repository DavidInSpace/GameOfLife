package git.david.logic;

import git.david.Config;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import static git.david.Main.speedLabel;

public class MouseWheelLogic implements MouseWheelListener {
    @Override public void mouseWheelMoved(MouseWheelEvent event) {
        if (event.getWheelRotation() > 0) {
            Config.draw_sleep_time--;
        } else {
            Config.draw_sleep_time++;
        }

        if (Config.draw_sleep_time < 1) {
            Config.draw_sleep_time = 150;
        } else if (Config.draw_sleep_time > 150) {
            Config.draw_sleep_time = 1;
        }

        speedLabel.setText("Game Speed: " + (int) (Config.draw_sleep_time / 150F + (150F - Config.draw_sleep_time)));
    }

}
