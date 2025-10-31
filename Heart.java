import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    public Heart() {
        GreenfootImage img = getImage(); // ambil gambar yang sudah dipilih di Greenfoot
        img.scale(32, 32); // ubah ukuran (bisa disesuaikan)
        setImage(img);     // pasang kembali gambar yang sudah di-scale
    }
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
