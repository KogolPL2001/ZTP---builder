package pl.wipb.ztp.ps3;

import java.awt.Graphics;

/**
 * Segment animowany
 */
class SegmentAnim extends Segment {
    private final int[] anim;

    public SegmentAnim(int x, int y, String file, int[] sequence) {
        super(x, y, file);
        anim = sequence;
    }
    public int frame = 0;

    @Override
    public void tick() {
        frame++;
        while (frame >= anim.length) {
            frame -= anim.length;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, x + W, y + H / 4, 0, anim[frame] * H / 4, W, anim[frame] * H / 4 + H / 4, null);
    }
    
}
//************************* postac gracza
