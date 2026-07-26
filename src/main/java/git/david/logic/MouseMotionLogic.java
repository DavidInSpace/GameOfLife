package git.david.logic;

import git.david.base.GridTile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionLogic implements MouseMotionListener {
    @Override public void mouseDragged(MouseEvent event) {
        GridTile tile = GridLogic.findTileFromWindowPosition(event.getX(), event.getY(), false);
        assert tile != null;
        tile.state = GridTile.TileState.ALIVE;
        event.getComponent().repaint();
    }

    @Override public void mouseMoved(MouseEvent event) {

    }
}
