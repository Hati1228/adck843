package game;

import city.cs.engine.*;

public class Thief extends Walker {
    private static final Shape thiefShape = new PolygonShape(
            -1.08f,1.78f,
            -1.07f,-1.82f,
            1.13f,-1.76f,
            1.16f,1.82f);


    private static final BodyImage leftImage =
            new BodyImage("data/thiefLeft.png", 4f);

    private static final BodyImage rightImage =
            new BodyImage("data/thiefRight.png", 4f);

    private String direction;

    static int money;
    static int life;



    public Thief(World world){
        super (world, thiefShape);
        addImage(leftImage);

        money = 0;
        life = 3;
        direction = "left";
    }

    public int getMoney(){
        return money;
    }
    public static void setMoney(int money){
        Thief.money = money;
    }
    public static int getLife(){
        return life;
    }
    public static void setLife(int life){
        Thief.life= life;
    }



   /* public static String life() {
        String life="3";                   //will check later
        return life;
    }

    public static String money() {
       String money = "20";
        return money;
    }
*/
    //public void setMoney(int money){ this.money = money;}
    //public int getMoney(){return money;}

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
    public void dropBomb(){
        new Bomb(this.getWorld(),this.getPosition(),3000);
    }
}









