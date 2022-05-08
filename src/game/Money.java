package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.UnknownServiceException;

public class Money extends StaticBody{
    private static final  Shape moneyShape = new PolygonShape(-0.672f,0.66f, -0.648f,-0.744f, 0.652f,-0.72f, 0.624f,0.668f, 0.616f,0.732f, -0.668f,0.68f);
    private static final BodyImage moneyImage = new BodyImage("data/money.png", 2f);

    private static SoundClip moneySound;

    static {
        try{
            moneySound = new SoundClip("data/moneySound.wav");
            System.out.println("Loading money sound");
        } catch (UnsupportedAudioFileException| IOException| LineUnavailableException e) {
            System.out.println(e);
        }
    }


    // constructor
    public Money(World world) {
        // "world here is an object of the GameWorld class"
        super(world, moneyShape);
        addImage(moneyImage);

    }

    @Override
    public void destroy()
    {
        moneySound.play();
        super.destroy();
    }
}


