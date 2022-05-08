package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import org.jbox2d.collision.Collision;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    GameLevel currentLevel;


    public GameView(GameLevel w, int width, int height) {
        super(w, width, height);
        currentLevel = (GameLevel) w;
    }

    @Override
    public void setWorld(World w){
        super.setWorld(w);

        currentLevel = (GameLevel)w;
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(currentLevel.getBackground(), 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {

        g.setColor(Color.black);
        g.drawString("Lives:" + Thief.life, 10, 10);
        g.setFont(new Font("Press Start 2P", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString("Money:" + Thief.money, 10, 30);
        g.setFont(new Font("Press Start 2P", Font.BOLD, 20));

        if (Integer.parseInt(String.valueOf(Thief.life)) < 1) {
            g.setColor(Color.red);
            g.drawString("GAME OVER", 100, 100);
            g.setFont(new Font("Press Start 2P", Font.BOLD, 400));

        } else if (Integer.parseInt(String.valueOf(Thief.life)) < 1) {
            g.setColor(Color.red);
            g.drawString("GAME OVER", 100, 100);
            g.setFont(new Font("Press Start 2P", Font.BOLD, 400));

        }
    }
}



