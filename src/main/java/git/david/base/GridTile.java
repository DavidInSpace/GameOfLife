package git.david.base;

import java.awt.*;

public class GridTile extends Canvas {

    public enum TileState {
        DEAD,
        ALIVE,
    }

    public int xGridCoordinate;
    public int yGridCoordinate;
    public TileState state = TileState.DEAD;
    public TileState nextState = TileState.DEAD;

    public GridTile(int xGridCoordinate, int yGridCoordinate) {
        this.xGridCoordinate = xGridCoordinate;
        this.yGridCoordinate = yGridCoordinate;
        this.state = Math.random() < 0.5 ? TileState.ALIVE : TileState.DEAD;
    }

}
