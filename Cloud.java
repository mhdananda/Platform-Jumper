import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends Actor
{
     private int speed;

    public Cloud() {
        GreenfootImage img = new GreenfootImage(100, 50);
        img.setColor(new Color(255, 255, 255, 220));
        img.fillOval(0, 0, 100, 50);
        setImage(img);
        speed = Greenfoot.getRandomNumber(2) + 1; // kecepatan acak
    }
    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // Add your action code here.
 move(speed);
        if (getX() > getWorld().getWidth() + getImage().getWidth()/2) {
            respawnOnLeft();
        }
    }

    private void respawnOnLeft() {
        // Ambil referensi world
        World world = getWorld();
        if (world == null) return; // safety check

        // Pindahkan awan yang sama ke sisi kiri, bukan hapus-buat baru
        int newX = -getImage().getWidth()/2;
        int newY = Greenfoot.getRandomNumber(200) + 50; 
        setLocation(newX, newY);

        speed = Greenfoot.getRandomNumber(2) + 1;
    }
}
