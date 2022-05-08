package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.geom.Point2D;


public class Tracker implements StepListener {
    private final GameView view;
    private final Thief thief;
    public Tracker(GameView view, Thief thief) {
        this.view = view;
        this.thief = thief;

    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(thief.getPosition().x,0));
    }
}

