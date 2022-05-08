package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Safe extends StaticBody{
    public static final BodyImage safeImage = new BodyImage("data/safe.png", 5f);

    public static final Shape safeShape = new BoxShape(0.5f,1);

    //Shape safeShape = new PolygonShape(-0.878f,0.765f, -0.848f,-0.687f, 0.822f,-0.657f, 0.818f,0.656f);


    // constructor
    public Safe(World world) {
        super(world, safeShape);
        // "world here is an object of the GameWorld class"
        //StaticBody safe = new StaticBody(world, safeShape);
        //safe.setPosition(position);
        addImage(safeImage);
    }
}

    //private static final Shape safeShape = new PolygonShape(
            //-1.57f, 1.53f, -1.66f, -1.29f, 1.5f, -1.32f, 1.49f, 1.53f);

   // private static final BodyImage safeImage = new BodyImage("data/safe.png", 2.5f);

    //public Safe(World world) {
       // super(world, safeShape);
        //addImage();



        
    //Shape safeShape = new BoxShape(0.5f, 0.5f);


    // constructor
    //public Safe (World world) {
        // "world here is an object of the GameWorld class"
        //StaticBody safe = new StaticBody(world, safeShape);
       // safe.setPosition(position);
      //  safe.addImage(safeImage);




//public Safe(GameWorld world) {
    //}





