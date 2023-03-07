package view;

import static interfaces.PropertyChangeGamePieces.PROPERTY_CHANGED;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JPanel;
import model.Board;
import interfaces.BoardLayoutAndControls;


/**
 * Class holds the next piece panel with on the info panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class NextPiecePanel extends JPanel implements PropertyChangeListener {

    //instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -3254087614079880441L;

    /** Width constant. */
    private static final int NEXT_PIECE_WIDTH = 400;

    /** Height constant. */
    private static final int NEXT_PIECE_HEIGHT = 205;

    /** TestPiece X coordinate value. */
    private static final int X_COOR_VALUE = 50;

    /** TestPiece Y coordinate value. */
    private static final int Y_COOR_VALUE = 50;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 50;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 50;



    /** This TEST PIECE. */
    private final RectangularShape myTestPiece;

    /**The Board.*/
    private final BoardLayoutAndControls myBoard;


    // constructor

    /**
     * Sets up the next piece panel to display next piece to user.
     */
    public NextPiecePanel() {
        super();
        myBoard = new Board();
        myBoard.addPropertyChangeListener(this);
        myTestPiece = new Rectangle2D.Double(X_COOR_VALUE, Y_COOR_VALUE,
                RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(NEXT_PIECE_WIDTH, NEXT_PIECE_HEIGHT));
        this.setVisible(true);

    }


    /**
     * Helps to draw the next game piece (right now just TestPiece)
     * on the NextPiece display panel.
     *
     * @param theGraphics the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.PINK);
        g2d.draw(new Rectangle2D.Double(X_COOR_VALUE, Y_COOR_VALUE,
                RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
        g2d.fill(myTestPiece);

//        g2d.setPaint(Color.PINK);
//        g2d.fill(myTestPiece);
    }


    /**
     * Once a certain property is changed within the model, a propertyChange
     * is fired and game board is updated.
     *
     * @param theEvent A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            // TODO: Need to implement what happens to update the board.
            final Point location = (Point) theEvent.getNewValue();

            myTestPiece.setFrame(location.getX() * RECTANGLE_WIDTH,
                    location.getY() * RECTANGLE_HEIGHT,
                    RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

            repaint();
        }
    }

}
