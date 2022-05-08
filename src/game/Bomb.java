package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 */

public class Bomb implements ActionListener {

    private static final BodyImage bombImage =
            new BodyImage("data/bomb.png",2f);

    private static final BodyImage explosionImage =
            new BodyImage("data/explosion.png",6f);

    private static SoundClip bombDropSound;
    private static SoundClip explosionSound;

    static {
        try {
            bombDropSound = new SoundClip("data/bombDrop.wav");   // Open an audio input stream
            System.out.println("Loading bomb sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    static {
        try {
            explosionSound = new SoundClip("data/explosion.wav");   // Open an audio input stream
            System.out.println("Loading bomb sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private final DynamicBody bomb;
    private DynamicBody explosion;
    private int counter;

    /**
     *
     * @param world
     * @param pos
     * @param detonationTime
     */

    public Bomb(World world, Vec2 pos, int detonationTime){

        bomb = new DynamicBody(world, new CircleShape(2));
        bomb.addImage(bombImage);
        bomb.setPosition(pos);

        bombDropSound.play();

        Timer t = new Timer(detonationTime, this);
        t.setRepeats(false);
        t.start();

        counter = 0;

    }

    /**
     *
     * @param e
     */


    @Override
    public void actionPerformed(ActionEvent e) {

        if (counter == 0) {

            bomb.destroy();
            bombDropSound.stop();

            explosion = new DynamicBody(bomb.getWorld(), new CircleShape(3));
            explosion.addImage(explosionImage);
            explosion.setPosition(bomb.getPosition());
            explosionSound.play();

            explosion.addCollisionListener(new ExplosionCollision());


            Timer t2 = new Timer(300, this);
            t2.setRepeats(false);
            t2.start();

        }
        else if (counter == 1){
            explosion.destroy();
        }

        counter++;
    }
}