package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;

/**
 *
 */

public class ExplosionCollision implements CollisionListener {

    /**
     *
     * @param collisionEvent
     */

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Destroyable){
            collisionEvent.getOtherBody().destroy();
        }
    }
}
