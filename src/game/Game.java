package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {

    GameLevel currentLevel;
    GameView view;
    ThiefController tc;
    PoliceController pc;

    private Tracker tracker;  //will see this later

    SoundClip gameMusic;
    private ControlPanel controlPanel;

    /**
     * Initialise a new Game.
     */
    public Game() {

        //1. Make an empty game world
        currentLevel = new Level1(this);

        //2. Make a view to look into the game world
        view = new GameView(currentLevel, 800, 600);
        //optional: draw a 1-meter grid over the view
        // view.setGridResolution(1);


       // 3. Add background music
        try {
            gameMusic = new SoundClip("data/backgroundMusic.mp3");   // Open an audio input stream
            gameMusic.loop();                              //  Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }


        //4. Add the controllers and KeyListeners
        tc = new ThiefController(currentLevel.getThief());
        view.addKeyListener(tc);

        pc = new PoliceController(currentLevel.getPolice());
        view.addKeyListener(pc);

        tracker = new Tracker(view, currentLevel.getThief());    //look here
        currentLevel.addStepListener(tracker);                          //look here

        view.addMouseListener(new GiveFocus(view));
        view.addMouseListener(new DirectionalShooting(currentLevel.getPolice(), view));
        //view.addMouseListener(new BoxPlacer(view,world));


        //5. create a Java window (frame) and add the game view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        controlPanel = new ControlPanel(this);
        frame.add(controlPanel.mainPanel,BorderLayout.NORTH);

        //add a button on the right side of the frame
        ////JButton button = new JButton("ButtonLabel");      //look here
        ////frame.add(button, BorderLayout.EAST);

        //JButton Play = new JButton("Play =");      //look here
        //frame.add(Play, BorderLayout.SOUTH);

        //JButton Quit = new JButton("Quit");      //look here
        //frame.add(Quit, BorderLayout.SOUTH);

        //JButton Pause = new JButton("Pause");      //look here
        //frame.add(Pause, BorderLayout.SOUTH);



        //button.addActionListener(new ActionListener() {
         //   @Override
         //   public void actionPerformed(ActionEvent e) {
         //       frame.remove(view);
         //       frame.pack();
         //   }
       // });


        //CHECK THIS ONE FOR A SMALL VERSION VIEW ON TOP
//        //make another view and add it at the bottom of the frame
//        UserView wideView = new UserView(currentLevel,500,100);
//        wideView.setZoom(3);
//        frame.add(wideView, BorderLayout.NORTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //6. Populate it with bodies
        Shape shape = new BoxShape(200, 1.0f);
        StaticBody ground = new StaticBody(currentLevel, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("data/ground.png", 1f));


        // start our game world simulation!
        currentLevel.start();
    }

    public void goToNextLevel() {

        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            currentLevel = new Level2(this);
            view.setWorld(currentLevel);

            tc.updateThief(currentLevel.getThief());
            pc.updatePolice(currentLevel.getPolice());
            tracker = new Tracker(view, currentLevel.getThief());    //look here
            currentLevel.addStepListener(tracker);
            currentLevel.start();
            view.addMouseListener(new GiveFocus(view));
        }
        else if (currentLevel instanceof Level2){
            currentLevel.stop();
            view.setWorld(currentLevel);
            tc.updateThief(currentLevel.getThief());
            currentLevel.start();
        }
        else if (currentLevel instanceof Level3){
            //System.out.println("WELL DONE!GAME COMPLETE");
            //System.exit(0);
            currentLevel.stop();
            view.setWorld(currentLevel);
            tc.updateThief(currentLevel.getThief());
            currentLevel.start();
        }
    }

        /** Run the game. */
        public static void main (String[]args){

            new Game();
        }
    }


//Thief t = world.getThief();
//Police p = world.getPolice();
// StudentController controller = new StudentController(world.getStudent());
//view.addKeyListener(controller);
// view.addMouseListener(new GiveFocus(view));
// view.addKeyListener(new StudentController(world.getStudent()));

//optional: uncomment this to make a debugging view
// JFrame debugView = new DebugViewer(world, 800, 600);
