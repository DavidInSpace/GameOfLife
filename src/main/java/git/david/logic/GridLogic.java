package git.david.logic;

import git.david.Constants;
import git.david.base.GridTile;

public class GridLogic {

    public static GridTile[][] GridTilePositions = new GridTile[100][100];

    public static void generateGrid() {

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                GridTilePositions[x][y] = new GridTile(x, y);
            }
        }

    }

    public static GridTile findTileFromWindowPosition(int xWindowPos, int yWindowPos, boolean ShowCellInfo) {
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                int HALF_SIZE = Constants.TILE_SIZE_X / 2;
                if (x * Constants.TILE_SIZE_X - HALF_SIZE > xWindowPos - Constants.MOUSE_CLICK_DETECTION_OFFSET && x * Constants.TILE_SIZE_X - HALF_SIZE < xWindowPos + Constants.MOUSE_CLICK_DETECTION_OFFSET && y * Constants.TILE_SIZE_Y - HALF_SIZE > yWindowPos - Constants.MOUSE_CLICK_DETECTION_OFFSET && y * Constants.TILE_SIZE_Y - HALF_SIZE < yWindowPos + Constants.MOUSE_CLICK_DETECTION_OFFSET) {
                    GridTile tile = GridTilePositions[x][y];
                    if (ShowCellInfo) {
                        System.out.println("Cell State: " + tile.state);
                        System.out.println("Cell Alive Neighbours: " + Cycle.getAliveCellsAmountAroundPosition(tile.xGridCoordinate, tile.yGridCoordinate));
                    }
                    return tile;
                }
            }
        }
        return null;
    }

}
