package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 */

public class BulletCollision implements CollisionListener {

    private Thief thief;

    /**
     *
     * @param a
     */

    public BulletCollision(Thief a) {
        this.thief = a;
    }

    /**
     *
     * @param e
     */

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bullet) {
            Thief.setLife(Thief.getLife() - 1);
            if (Thief.life == 0) {

            }
            e.getOtherBody().destroy();
        }
    }
}



/*public class BulletCollision implements CollisionListener{

    private Thief thief;
    public BulletCollision(Thief a){this.thief= a;}
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bullet) {
            Thief.setLife(Thief.getLife()-1);

        }
    }
}
 */

