import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private int score = 0;
    private int lives = 3;

    public ScoreBoard() {
        updateImage();
    }

    public void addScore(int points) {
        score += points;
        updateImage();
    }

    public void decreaseLife() {
        lives--;
        updateImage();
    }

    public int getLives() {
        return lives;
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(200, 50);
        img.setColor(new Color(0, 0, 0, 150)); // transparan hitam
        img.fillRect(0, 0, 200, 50);
        img.setColor(Color.WHITE);
        img.drawString("Score: " + score, 10, 20);
        img.drawString("Lives: " + lives, 10, 40);
        setImage(img);
    }
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
