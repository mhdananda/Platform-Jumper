import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootSound bgMusic = new GreenfootSound("Platform_Jumper_Theme.mp3");
    private ScoreBoard scoreboard;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 576, 1);
        prepare();
    }
    public void act() {
        //
    }
    @Override
    public void stopped() {
        bgMusic.pause();  
    }
    @Override
    public void started() {
        bgMusic.playLoop();  
    }
    
    private void prepare(){
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 120, 30);

        // Tambahkan awan dekoratif

        addObject(new Cloud(), 200, 100);
        addObject(new Cloud(), 600, 150);
        addObject(new Cloud(), 900, 80);
        addObject(new Cloud(), 50, 200);

        // Player
        Player player = new Player(scoreboard);
        addObject(player, 120, 500);

        // Platform dasar (ground)
        for (int i = 0; i < 11; i++) {
            addObject(new Platform(), 50 + i * 100, 550);
        }

        // Platform bertingkat
        addObject(new Platform(), 200, 450);
        addObject(new Platform(), 400, 400);
        addObject(new Platform(), 650, 350);
        addObject(new Platform(), 850, 300);
        addObject(new Platform(), 950, 250);
        addObject(new Platform(), 500, 200);
        addObject(new Platform(), 300, 150);

        // Coin
        addObject(new Coin(scoreboard), 200, 400);
        addObject(new Coin(scoreboard), 400, 350);
        addObject(new Coin(scoreboard), 650, 300);
        addObject(new Coin(scoreboard), 850, 250);
        addObject(new Coin(scoreboard), 500, 150);

        // Enemy
        addObject(new Enemy(), 400, 370);
        addObject(new Enemy(), 850, 270);

        // Goal
        addObject(new Goal(), 300, 100);
        Platform platform19 = new Platform();
        addObject(platform19,525,377);
        Platform platform20 = new Platform();
        addObject(platform20,764,214);
        Platform platform21 = new Platform();
        addObject(platform21,624,219);
        platform21.setLocation(653,193);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,648,319);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,935,504);
        platform21.setLocation(621,139);
        Heart heart = new Heart();
        addObject(heart,43,87);
    }
}

