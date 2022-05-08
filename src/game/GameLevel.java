package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {

    private final Thief thief;
    private final Police police;


    public GameLevel(Game game){
        //super();
        //populate it with bodies (ex: platforms, collectibles, characters)

        //make a ground platform
        //Shape shape = new BoxShape(200, 1.0f);
        //StaticBody ground = new StaticBody(this, shape);
        //ground.setPosition(new Vec2(-5f, -16f));
        //ground.addImage(new BodyImage("data/ground.png", 12f));

/*
        //make a wall
        Shape wallShape = new BoxShape(1f, 15f);
        StaticBody wall1= new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-20f, 3f));
        wall1.addImage(new BodyImage("data/wall.png", 30));

        //make another wall
        StaticBody wall2= new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(53f, 3f));
        wall2.addImage(new BodyImage("data/wall.png", 30));

 */

        // make safe
        //Safe safe = new Safe(this,new Vec2(45,12));

        //make a character (with an overlaid image)
        thief = new Thief(this);
        police = new Police(this);

        //money pickup field
        MoneyPickup pickup= new MoneyPickup(thief);
        thief.addCollisionListener(pickup);

        //bullet collision field
        BulletCollision collision = new BulletCollision(thief);
        thief.addCollisionListener(collision);

        //add collisionListeners
        SafeEncounter encounter = new SafeEncounter(this, game);
        thief.addCollisionListener(encounter);
    }

    public Thief getThief(){
        return thief;
    }
    public Police getPolice(){
        return police;
    }

    public abstract boolean isComplete();

    public abstract Image getBackground();
}

// make a suspended platform
//Shape platformShape = new BoxShape(3, 0.5f);
//StaticBody platform1 = new StaticBody(this, platformShape);
//platform1.setPosition(new Vec2(-8, -4f));

/*public abstract class GameLevel extends World {
    private Student student;
    private Professor professor;
    public GameLevel(){
        student = new Student(this);
        professor = new Professor(this);
    }
    public Student getStudent(){
        return student;
    }
    public Professor getProfessor(){
        return professor;
    }
    public abstract boolean isComplete();
}
 */
