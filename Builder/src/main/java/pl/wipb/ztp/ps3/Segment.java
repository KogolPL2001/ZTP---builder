package pl.wipb.ztp.ps3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Klasa bazowa dla segmentow
 */
class Segment {
    protected Image img;
    protected int x;
    protected int y;
    protected int W;
    protected int H;

    public Segment(int x, int y, String file) {
        this.x = x;
        this.y = y;
        img = ImgUtils.getImage(file);
        W = img.getWidth(null);
        H = img.getHeight(null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, W, H);
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void tick() {
    }

    public void collisionV(Sprite sprite) {
    }

    public void collisionH(Sprite sprite) {
    }
    
}
