package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PoliceController implements KeyListener {

    private static final float WALKING_SPEED = 6;
    private static final float JUMPING_SPEED = 12;

    private Police police;
    public PoliceController(Police police){
        this.police = police;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            police.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            police.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_W) {
            police.jump(JUMPING_SPEED);
            }else if (code == KeyEvent.VK_S){
            police.stopWalking();
        } else if (code == KeyEvent.VK_SPACE){
            police.shoot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            police.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            police.stopWalking();
        }
    }
    public void updatePolice(Police newPolice){
        police = newPolice;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
}
