package game;

import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 */

public class DirectionalShooting implements MouseListener {

    private final Police police;
    private final GameView view;

    /**
     *
     * @param p
     * @param v
     */

    public DirectionalShooting(Police p,GameView v){
        police = p;
        view = v;
    }

    /**
     *
     * @param e
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        Vec2 worldPoint = view.viewToWorld(e.getPoint());
        police.shoot( worldPoint);

    }

    /**
     *
     * @param e
     */

    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     *
     * @param e
     */

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     *
     * @param e
     */

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
