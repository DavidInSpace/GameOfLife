package git.david;

import java.awt.*;

public record Constants() {

    /** -- GAME RULES -- */
    public final static int[] DEAD_BY_UNDERPOPULATION = {1, 0}; // Default: {1, 0} | Alive cell dies of underpopulation
    public final static int[] SURVIVING = {2, 3}; // Default: {2, 3} | Alive cell survives
    public final static int[] DEAD_BY_OVERPOPULATION = {4, 5, 6, 7, 8}; // Default: {4, 5, 6, 7, 8} | Alive cell dies of overpopulation
    public final static int[] REPRODUCE = {3}; // Default: {3} | Dead cell becomes a live cell by reproduction


    /** -- COLORS -- **/
    public final static Color GRID_COLOR = Color.DARK_GRAY; // Default: Color.DARK_GRAY | Color of the grid if it's enabled
    public final static Color ALIVE_CELL_COLOR = Color.WHITE; // Default: Color.WHITE | Color of alive cells
    public final static Color DEAD_CELL_COLOR = Color.BLACK; // Default: Color.BLACK | Color of dead cells

    // Size of the game window
    public final static int[] WINDOW_SIZE = {900, 900}; // Default {900, 900}

    // How big the grid will be {X, Y}. Both values should be the same or the grid won't be made out of squares
    public final static int[] GRID_SIZE = {40, 40}; // Default: {40, 40}

    public final static int TILE_SIZE_X = WINDOW_SIZE[0] / GRID_SIZE[0]; // (shouldn't be changed)
    public final static int TILE_SIZE_Y = WINDOW_SIZE[1] / GRID_SIZE[1]; // (shouldn't be changed)

    /** -- OTHER -- **/
    public final static int DRAW_SLEEP_TIME = 0; // Default: 0 | Sleep time between re-drawing the screen (shouldn't be changed)
    public final static boolean DRAW_GRID_LINES = false; // Default: false | Gets glitchy if enabled (shouldn't be changed)
    public final static int TOTAL_NUMBER_OF_POINTS = 4; // Default: 4 | Setting this to 3 will turn all tiles in to triangles any other value won't work (shouldn't be changed)
    public final static int MOUSE_CLICK_DETECTION_OFFSET = 35; // Default: 35 | (shouldn't be changed)

}
