package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameLevel{

    Image background;
    //private SoundClip gameMusic;
    private Game game;

    public Level2(Game game){
        super(game);
        this.game = game;

//        try {
//            SoundClip gameMusic = new SoundClip("data/Level2Sound.mp3");   // Open an audio input stream
//            gameMusic.stop();
//            gameMusic.play();                              //  Set it to continuous playback (looping)
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            //code in here will deal with any errors
//            //that might occur while loading/playing sound
//            System.out.println(e);
//        }


        //paint Background for this level
        background = new ImageIcon("data/City2.png").getImage();

        //make a ground platform
        Shape shape = new BoxShape(50, 1.0f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -16f));

        //make a wall
        Shape wallShape = new BoxShape(1f, 15f);
        StaticBody wall1= new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-20f, 3f));
        wall1.addImage(new BodyImage("data/wall.png", 30));

        //make another wall
        StaticBody wall2= new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(53f, 3f));
        wall2.addImage(new BodyImage("data/wall.png", 30));

        //make platforms
        Platform platform1 = new Platform(this, new Vec2(-3,-3.5f));
        Platform platform2 = new Platform(this, new Vec2(22,2f));
        Platform platform3 = new Platform(this, new Vec2(3,3f));
        Platform platform4 = new Platform(this, new Vec2(15,-4f));
        Platform platform5 = new Platform(this, new Vec2(43,10f));
        //Platform platform6 = new Platform(this, new Vec2(30,15f));
        //Platform platform7 = new Platform(this, new Vec2(15,17f));
        Platform platform8 = new Platform(this, new Vec2(9,12f));
        Platform platform9 = new Platform(this, new Vec2(35,6f));

        //populate the world with money items
        new Money(this).setPosition(new Vec2(-5f,5));
        new Money(this).setPosition(new Vec2(4,-2));
        new Money(this).setPosition(new Vec2(3,-3.5f));
        new Money(this).setPosition(new Vec2(35,2f));
        new Money(this).setPosition(new Vec2(0,10f));
        new Money(this).setPosition(new Vec2(-10,5f));
        new Money(this).setPosition(new Vec2(15,-1f));
        new Money(this).setPosition(new Vec2(22,4f));
        new Money(this).setPosition(new Vec2(43,11f));

        new Safe(this).setPosition(new Vec2(45,12));

        //setting the position of the characters
        getThief().setPosition(new Vec2(0,0));
        getPolice().setPosition(new Vec2(4,-5));
    }

    @Override
    public boolean isComplete() {
            return true;
    }

    @Override
    public Image getBackground() {
        return background;
    }


}
