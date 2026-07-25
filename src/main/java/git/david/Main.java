package git.david;

import git.david.logic.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {

    public static boolean game_running = true;
    public static Label runningStateLabel = new Label();
    public static Label speedLabel = new Label();

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

        canvas.addMouseWheelListener(new MouseWheelLogic());
        canvas.addMouseListener(new MouseLogic());
        canvas.addKeyListener(new KeyLogic());

        runningStateLabel.setBackground(Color.GREEN);
        runningStateLabel.setAlignment(Label.CENTER);
        runningStateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        runningStateLabel.setBounds(Constants.WINDOW_SIZE[0] / 2 - 75, 0, 150, 25);
        runningStateLabel.setText("Running");

        Label pauseHintLabel = new Label();
        pauseHintLabel.setBackground(Color.BLACK);
        pauseHintLabel.setForeground(Color.GRAY);
        pauseHintLabel.setAlignment(Label.CENTER);
        pauseHintLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        pauseHintLabel.setBounds(Constants.WINDOW_SIZE[0] / 2 - 250, 25, 500, 25);
        pauseHintLabel.setText("Cells can only be placed when paused  |  Press Space to pause/unpause");


        speedLabel.setBackground(Color.BLACK);
        speedLabel.setForeground(Color.CYAN);
        speedLabel.setAlignment(Label.CENTER);
        speedLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        speedLabel.setBounds(30, 0, 125, 25);
        speedLabel.setText("Game Speed: " + (int) (Config.draw_sleep_time / 150F + (150F - Config.draw_sleep_time)));

         Label speedHintLabel = new Label();
         speedHintLabel.setBackground(Color.BLACK);
         speedHintLabel.setForeground(Color.GRAY);
         speedHintLabel.setAlignment(Label.CENTER);
         speedHintLabel.setFont(new Font("Arial", Font.PLAIN, 12));
         speedHintLabel.setBounds(20, 25, 150, 25);
         speedHintLabel.setText("Scroll to change speed");

        frame.add(runningStateLabel);
        frame.add(pauseHintLabel);
         frame.add(speedLabel);
         frame.add(speedHintLabel);
        frame.add(canvas);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
