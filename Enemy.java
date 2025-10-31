import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed = 2;
    private GreenfootImage[] frames;
    private GreenfootImage[] framesFlipped;
    private int frameIndex = 0;
    private int animationDelay = 5; // semakin kecil => lebih cepat animasi
    private int delayCount = 0;

    public Enemy() {
        int frameCount = 7;
        frames = new GreenfootImage[frameCount];
        framesFlipped = new GreenfootImage[frameCount];

        for (int i = 0; i < frameCount; i++) {
            String fileName = (i + 1) + ".png";
            try {
                GreenfootImage img = new GreenfootImage(fileName);
                // optional: scale agar pas di world
                img.scale(48, 32);
                frames[i] = img;

                // buat versi terbalik (mirror) untuk arah kiri
                GreenfootImage flipped = new GreenfootImage(img);
                flipped.mirrorHorizontally();
                framesFlipped[i] = flipped;
            } catch (Exception e) {
                System.out.println("ERROR: gagal memuat image '" + fileName + "'. Pastikan file ada di folder images dan nama persis sama.");
                // jaga agar tidak null -> buat placeholder kecil
                GreenfootImage placeholder = new GreenfootImage(48, 32);
                placeholder.setColor(Color.MAGENTA);
                placeholder.fill();
                frames[i] = placeholder;
                GreenfootImage placeholderFlipped = new GreenfootImage(placeholder);
                placeholderFlipped.mirrorHorizontally();
                framesFlipped[i] = placeholderFlipped;
            }
        }

        // set image awal
        if (frames.length > 0 && frames[0] != null) {
            setImage(frames[0]);
        }
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animateFly();

        // gerak horizontal
        setLocation(getX() + speed, getY());

        // bila menyentuh tepi, balik arah
        if (isAtEdge()) {
            speed = -speed;
            // langsung set frame sesuai arah baru agar tidak sempat mirror dua kali
            updateFrameForDirection();
        }
    }
    private void animateFly() {
        if (frames == null || frames.length == 0) return; // aman jika frame kosong

        delayCount++;
        if (delayCount >= animationDelay) {
            frameIndex = (frameIndex + 1) % frames.length;
            // pilih frame sesuai arah (speed > 0 => kanan, speed < 0 => kiri)
            if (speed >= 0) {
                setImage(frames[frameIndex]);
            } else {
                setImage(framesFlipped[frameIndex]);
            }
            delayCount = 0;
        }
    }

    private void updateFrameForDirection() {
        // set frame langsung sesuai arah supaya konsisten
        if (frames == null || frames.length == 0) return;
        if (speed >= 0) {
            setImage(frames[frameIndex]);
        } else {
            setImage(framesFlipped[frameIndex]);
        }
    }
}
