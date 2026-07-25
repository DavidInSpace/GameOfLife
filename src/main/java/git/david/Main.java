package git.david;

import git.david.logic.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {

    public static boolean game_running = true;
    public static Label runningStateLabel = new Label();

    void main() {
        this.createWindow();
        GridLogic.generateGrid();
        Cycle.nextGeneration();
    }

     void createWindow() {
        JFrame frame = new JFrame("Game Of Life");

        // Set window icon
        URL iconURL = getClass().getResource("/GOF_window_icon.png");
        assert iconURL != null;
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Drawing();
        canvas.setSize(Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1]);
        canvas.setBackground(Color.BLACK);

        canvas.addMouseListener(new MouseLogic());
        canvas.addKeyListener(new KeyLogic());

        runningStateLabel.setBackground(Color.GREEN);
        runningStateLabel.setAlignment(Label.CENTER);
        runningStateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        runningStateLabel.setBounds(Constants.WINDOW_SIZE[0] / 2 - 75, 0, 150, 25);
        runningStateLabel.setText("Running");

        Label hintLabel = new Label();
        hintLabel.setBackground(Color.BLACK);
        hintLabel.setAlignment(Label.CENTER);
        hintLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        hintLabel.setBounds(Constants.WINDOW_SIZE[0] / 2 - 250, 30, 500, 25);
        hintLabel.setText("Cells can only be placed when paused  |  Press Space to pause/unpause");

        frame.add(runningStateLabel);
        frame.add(hintLabel);
        frame.add(canvas);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
