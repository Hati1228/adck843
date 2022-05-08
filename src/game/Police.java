package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Police extends Walker {
    private static final Shape policeShape = new PolygonShape(
            -1.1f,1.62f,
            -1.09f,-1.92f,
            1.21f,-1.9f,
            1.2f,1.65f,
            -1.09f,1.64f);


    private static final BodyImage leftImage =
            new BodyImage("data/policeLeft.png", 4f);

    private static final BodyImage rightImage =
            new BodyImage("data/policeRight.png", 4f);

    //private int money = 0;
    private String direction;

    public Police(World world) {
        super (world, policeShape);
        //super(world);
        //Fixture f1 = new GhostlyFixture(this, thiefShape);
        //this.setGravityScale(0);


        addImage(leftImage);
        //setAlwaysOutline(true); //this is optional
        //money = 0;
        direction = "left";

    }

    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        if(speed < 0){
            this.removeAllImages();
            this.addImage(leftImage);
            direction = "left";
        }
        else{
            this.removeAllImages();
            this.addImage(rightImage);
            direction = "right";
        }
    }

    public void shoot() {
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));

        if (direction.equals("left")) {
            projectile.setPosition(new Vec2(this.getPosition().x - 1, this.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-25, 3));
        } else {
            projectile.setPosition(new Vec2(this.getPosition().x + 1, this.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-25, 3));
        } 
    }

    public void shoot(Vec2 t){

        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));

        Vec2 dir = t.sub(this.getPosition());
        dir.normalize();

        projectile.setPosition(this.getPosition().add(dir.mul(1f)));
        projectile.setLinearVelocity(dir.mul(30));
    }
}


