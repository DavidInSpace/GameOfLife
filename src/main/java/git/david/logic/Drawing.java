package git.david.logic;

import git.david.Constants;
import git.david.Main;
import git.david.Utility;
import git.david.base.GridTile;

import java.awt.*;

import static git.david.logic.GridLogic.GridTilePositions;

public class Drawing extends Canvas {

    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        try {Thread.sleep(Constants.DRAW_SLEEP_TIME);
        Cycle.nextGeneration();} catch (InterruptedException e) {throw new RuntimeException(e);}
        for (int x = 0; x < GridTilePositions.length; x++) {
            for (int y = 0; y < GridTilePositions.length; y++) {
                GridTile tile = GridTilePositions[x][y];

                if (tile.state == GridTile.TileState.ALIVE) {
                    g.setColor(Constants.ALIVE_CELL_COLOR);
                } else if (tile.state == GridTile.TileState.DEAD) {
                    g.setColor(Constants.DEAD_CELL_COLOR);
                }

                if (Main.game_running) {
                if (tile.nextState != tile.state) {
                    //Utility.printColoredText("repaint", "yellow");
                    this.repaint(x * Constants.TILE_SIZE_X, y * Constants.TILE_SIZE_Y, Constants.TILE_SIZE_X, Constants.TILE_SIZE_Y);



                    if (tile.nextState == GridTile.TileState.DEAD) {
                        tile.state = GridTile.TileState.DEAD;
                    } else if (tile.nextState == GridTile.TileState.ALIVE) {
                        tile.state = GridTile.TileState.ALIVE;
                    }}
                }

                int[] xPos = calculateTilePolygonXPosition(x * Constants.TILE_SIZE_X);
                int[] yPos = calculateTilePolygonYPosition(y * Constants.TILE_SIZE_Y);
                g.fillPolygon(xPos, yPos, Constants.TOTAL_NUMBER_OF_POINTS);

                if (Constants.DRAW_GRID_LINES) {
                    g.setColor(Constants.GRID_COLOR);
                    g.drawPolygon(xPos, yPos, Constants.TOTAL_NUMBER_OF_POINTS);
                }
            }
        }
    }

    public static int[] calculateTilePolygonXPosition(int x) {
        return new int[]{x, x + Constants.TILE_SIZE_X, x + Constants.TILE_SIZE_X, x};
    }

    public static int[] calculateTilePolygonYPosition(int y) {
        return new int[]{y, y, y + Constants.TILE_SIZE_Y, y + Constants.TILE_SIZE_Y};
    }

}