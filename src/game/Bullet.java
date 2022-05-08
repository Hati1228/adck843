package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 */

public class Bullet extends StaticBody {
    private static final Shape bulletShape = new BoxShape(0.5f,1f);

    private static final BodyImage image =
            new BodyImage("data/bullet.png", 1f);

    /**
     *
     * @param world
     */

    public Bullet(World world) {
        super(world, bulletShape);
        addImage(image);
    }
}



