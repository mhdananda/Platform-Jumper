import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinWorld extends World
{
    private GreenfootSound victorySound = new GreenfootSound("Victory.mp3");
    /**
     * Constructor for objects of class WinWorld.
     * 
     */
    public WinWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 576, 1); 
        showText("YOU WIN!", getWidth()/2, getHeight()/2);
        showText("Press 'R' to Restart", getWidth()/2, getHeight()/2 + 50);
        victorySound.play();
    }
    public void act() {
        if (Greenfoot.isKeyDown("r")) {
            victorySound.stop();
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
