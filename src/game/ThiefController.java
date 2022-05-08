package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ThiefController implements KeyListener {

    private static final float WALKING_SPEED = 6;
    private static final float JUMPING_SPEED = 14;

    private Thief thief;
    public ThiefController(Thief thief){
        this.thief = thief;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) { //to the left
            thief.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) { //to the right
            thief.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_UP) {
            thief.jump(JUMPING_SPEED);
        } else if (code == KeyEvent.VK_DOWN){
            thief.stopWalking();
        }else if (code == KeyEvent.VK_ENTER){
            thief.dropBomb();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            thief.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            thief.stopWalking();
        }
    }

    public void updateThief(Thief newThief){
        thief = newThief;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
