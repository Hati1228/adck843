package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SafeEncounter implements CollisionListener {

    private final GameLevel currentLevel;
    private final Game game;

    public SafeEncounter(GameLevel level, Game game){
        this.currentLevel = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if thief collided with safe and the
        //conditions for completing the level are fullfilled
        //goToNextLevel
        if(e.getOtherBody() instanceof Safe){

            //if (currentLevel.isComplete())
             //   System.out.println("transition to next level");
            game.goToNextLevel();
            //e.getOtherBody().destroy();
        }
    }
}
