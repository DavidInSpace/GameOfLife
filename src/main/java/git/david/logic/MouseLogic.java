package git.david.logic;

import git.david.base.GridTile;

import java.awt.event.MouseEvent;

public class MouseLogic implements java.awt.event.MouseListener {

    @Override public void mouseClicked(MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON1) {
            GridTile tile = GridLogic.findTileFromWindowPosition(event.getX(), event.getY(), false);
            assert tile != null;
            tile.state = GridTile.TileState.ALIVE;
            event.getComponent().repaint();
        }

        if (event.getButton() == MouseEvent.BUTTON3) {
            GridTile tile = GridLogic.findTileFromWindowPosition(event.getX(), event.getY(), false);
            assert tile != null;
            tile.state = GridTile.TileState.DEAD;
            event.getComponent().repaint();
        }
    }

    @Override public void mousePressed(MouseEvent event) {}

    @Override public void mouseReleased(MouseEvent event) {}

    @Override public void mouseEntered(MouseEvent event) {}

    @Override public void mouseExited(MouseEvent event) {}
}
