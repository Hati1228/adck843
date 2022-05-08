package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform {


    //make platform Image here
    BodyImage platformImage = new BodyImage("data/platform.png", 1f);
    // make  platformShape here
    Shape platformShape = new BoxShape(5f, 0.3f);



    // constructor
    public Platform(World world, Vec2 position) {
        // "world here is an object of the GameWorld class"
        StaticBody platform = new StaticBody(world, platformShape);
        platform.setPosition(position);
        platform.addImage(platformImage);
    }
}

