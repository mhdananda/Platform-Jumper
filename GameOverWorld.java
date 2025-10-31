import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
     private GreenfootSound gameOverSound = new GreenfootSound("Gameover.mp3");
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 576, 1);
        showText("GAME OVER", getWidth()/2, getHeight()/2);
        showText("Press 'R' to Restart", getWidth()/2, getHeight()/2 + 50);
    }

    public void act() {
        if (Greenfoot.isKeyDown("r")) {
            gameOverSound.stop();
            Greenfoot.setWorld(new MyWorld());
        }
    }
}

