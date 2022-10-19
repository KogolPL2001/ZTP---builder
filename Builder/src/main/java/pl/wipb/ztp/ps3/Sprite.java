package pl.wipb.ztp.ps3;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

/**
 * Postac gracza
 */
class Sprite {
    private final Image img;// = new ImageIcon("Mario.png").getImage();
    private int[] anim = {0, 1, 2, 1};
    private int frame = 2; // klatka animacji
    private boolean mirror = false; // postac patrzy w lewo/ prawo
    private int moving = 0; // ruch w poziomie
    private int jumping = 0; // ruch w pionie
    private final List<Segment> plansza;
    private int x = 150;
    private int y = 0; // pozycja na ekranie
    private final int W = 16;
    private final int H = 27; // wysokosc i szerokosc sprite'a

    public Sprite(List<Segment> pl, String imageName) {
        plansza = pl;
        img = ImgUtils.getImage(imageName);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBottomY() {
        return y + H;
    }

    public void jump() {
        // poruszanie postacia
        if (jumping == 0) {
            jumping = 10;
        }
    }

    public boolean isJumping() {
        return jumping > 0;
    }

    public boolean jumpingDown() {
        return jumping < 0;
    }

    public void stopJump() {
        jumping = 0;
    }

    public void stopMove() {
        moving = 0;
    }

    public void left() {
        moving = -3;
        mirror = false;
    }

    public void right() {
        moving = 3;
        mirror = true;
    }

    public void stop() {
        moving = 0;
        frame = 2;
    }

    private boolean canGo(int dx, int dy) {
        for (Segment s : plansza) {
            if (s.getBounds().intersects(x + dx, y + dy, W, H)) {
                return false;
            }
        }
        return true;
    }

    private void collide(int dx, int dy) {
        for (Segment s : plansza) {
            if (s.getBounds().intersects(x + dx, y + dy, W, H)) {
                if (dx != 0) {
                    s.collisionH(this);
                }
                if (dy != 0) {
                    s.collisionV(this);
                }
            }
        }
    }

    public void tick() {
        if (moving != 0) {
            // animacja ruchu
            frame++;
            while (frame >= anim.length) {
                frame -= anim.length;
            }
        }
        // przesuniecie w poziomie
        for (int i = 0; i < Math.abs(moving); ++i) {
            collide((int) Math.signum(moving), 0);
            x += (int) Math.signum(moving);
        }
        // przesuniecie w pionie
        for (int i = 0; i < Math.abs(jumping); ++i) {
            collide(0, -(int) Math.signum(jumping));
            y -= (int) Math.signum(jumping);
        }
        // czy mamy grunt pod nogami?
        jumping--;
        collide(0, 1);
        if (jumping != 0) {
            frame = 0;
        }
        if (jumping == 0 && moving == 0) {
            frame = 2;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(img, x + (mirror ? W : 0), y, x + (mirror ? 0 : W), y + H, anim[frame] * W, 0, anim[frame] * W + W, H, null);
    }
    
}
