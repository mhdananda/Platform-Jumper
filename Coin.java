import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
     private ScoreBoard scoreboard;

    public Coin(ScoreBoard scoreboard) {
        this.scoreboard = scoreboard;
        GreenfootImage img = new GreenfootImage("Coin.png");
        img.scale(24, 24);
        setImage(img);
    }

    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (isTouching(Player.class)) {
            scoreboard.addScore(10);
            getWorld().removeObject(this);
        }
    }
}
