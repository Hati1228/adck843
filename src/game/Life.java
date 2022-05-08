package game;

import city.cs.engine.*;

public class Life extends StaticBody {
    private static final Shape lifeShape = new BoxShape(0.5f,1f);

    private static final BodyImage image =
            new BodyImage("data/Life.png", 1f);

    public Life(World world) {
        super(world, lifeShape);
        addImage(image);
    }

}
