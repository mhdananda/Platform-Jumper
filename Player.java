import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int lives = 3;
    private int invincibleTimer = 0;
    private int ySpeed = 0;
    private int jumpStrength = -15;
    private int gravity = 1;
    private ScoreBoard scoreboard;

    // Animasi Mario
    private GreenfootImage standImage = new GreenfootImage("Mario_Stand.png");
    private GreenfootImage jumpImage = new GreenfootImage("Mario_Jump.png");
    private GreenfootImage[] runImages = {
        new GreenfootImage("Mario_Run1.png"),
        new GreenfootImage("Mario_Run2.png"),
        new GreenfootImage("Mario_Run3.png")
    };

    private int animationCounter = 0;
    private int animationIndex = 0;
    private boolean facingRight = true;

    public Player(ScoreBoard scoreboard) {
        this.scoreboard = scoreboard;
        setImage(standImage);
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeys();
        applyGravity();
        checkPlatformCollision();
        checkGoal();
        checkEnemy();
        updateAnimation();
    }
    

    private void checkKeys() {
        boolean moving = false;

        if (Greenfoot.isKeyDown("left")) {
            movePlayer(-5);
            facingRight = false;
            moving = true;
        }
        if (Greenfoot.isKeyDown("right")) {
            movePlayer(5);
            facingRight = true;
            moving = true;
        }
        if (Greenfoot.isKeyDown("space") && onGround()) {
            ySpeed = jumpStrength;
            Greenfoot.playSound("Jump_Sound.mp3");
            setImage(jumpImage);
            if (!facingRight) getImage().mirrorHorizontally();
        }

        // Ganti ke gambar diam kalau tidak bergerak
        if (!moving && onGround()) {
            setImage(standImage);
            if (!facingRight) getImage().mirrorHorizontally();
        }
    }

    private void movePlayer(int dx) {
        setLocation(getX() + dx, getY());
        animateRun();
    }

    private void applyGravity() {
        setLocation(getX(), getY() + ySpeed);
        if (ySpeed < 10) ySpeed += gravity;

        // Jika jatuh ke bawah layar
        if (getY() > getWorld().getHeight() - 5) {
            Greenfoot.setWorld(new GameOverWorld());
        }
    }

    private boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 1, Platform.class);
        return under != null;
    }

    private void checkPlatformCollision() {
        if (onGround() && ySpeed >= 0) {
            ySpeed = 0;
        }
    }

    private void checkGoal() {
        if (isTouching(Goal.class)) {
            Greenfoot.setWorld(new WinWorld());
        }
    }

    private void checkEnemy() {
        if (isTouching(Enemy.class)) {
            scoreboard.decreaseLife();
            removeTouching(Enemy.class);
            if (scoreboard.getLives() <= 0) {
                Greenfoot.setWorld(new GameOverWorld());
            }
        }
    }

    private void animateRun() {
        animationCounter++;
        if (animationCounter % 7 == 0) {
            animationIndex = (animationIndex + 1) % runImages.length;
            setImage(runImages[animationIndex]);
            if (!facingRight) getImage().mirrorHorizontally();
        }
    }

    private void updateAnimation() {
        if (!onGround()) {
            setImage(jumpImage);
            if (!facingRight) getImage().mirrorHorizontally();
        }
    }
}
