package git.david.logic;

import git.david.Constants;
import git.david.base.GridTile;

import java.util.stream.IntStream;

import static git.david.logic.GridLogic.GridTilePositions;

public class Cycle {

    public final static int[][] CELLS_CHECK_POSITIONS = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

    public static void nextGeneration() {

        for (int x = 0; x < GridTilePositions.length; x++) {
            for (int y = 0; y < GridTilePositions[x].length; y++) {

                GridTile tile = GridTilePositions[x][y];

                int aliveCells = getAliveCellsAmountAroundPosition(x, y);

                if (tile.state == GridTile.TileState.ALIVE) {
                    if (IntStream.of(Constants.DEAD_BY_UNDERPOPULATION).anyMatch(i -> i == aliveCells)) {
                        tile.nextState = GridTile.TileState.DEAD;
                    } else if (IntStream.of(Constants.SURVIVING).anyMatch(i -> i == aliveCells)) {
                        tile.nextState = tile.state;
                    } else if (IntStream.of(Constants.DEAD_BY_OVERPOPULATION).anyMatch(i -> i == aliveCells)) {
                        tile.nextState = GridTile.TileState.DEAD;
                    }
                } else if (tile.state == GridTile.TileState.DEAD) {

                    if (IntStream.of(Constants.REPRODUCE).anyMatch(i -> i == aliveCells)) {
                        tile.nextState = GridTile.TileState.ALIVE;
                    }

                }

            }
        }
    }

    static int getAliveCellsAmountAroundPosition(int x, int y) {
        int AliveCellsAmount = 0;
        for (int[] cellsCheckPosition : CELLS_CHECK_POSITIONS) {
            try {
                if (GridTilePositions[x + cellsCheckPosition[0]][y + cellsCheckPosition[1]].state == GridTile.TileState.ALIVE) {
                    AliveCellsAmount++;
                }
            } catch (Exception e) {

            }
        }
        return AliveCellsAmount;
    }

}
