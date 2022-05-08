package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class MoneyPickup implements CollisionListener {

    private final Thief thief;
    public MoneyPickup(Thief a){this.thief= a;}

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Money) {
            Thief.setMoney(thief.getMoney()+1);
            e.getOtherBody().destroy();
        }
    }
}
