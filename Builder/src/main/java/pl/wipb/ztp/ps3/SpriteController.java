package pl.wipb.ztp.ps3;

import java.util.List;

import javax.swing.JPanel;


class SpriteController implements Runnable {
    private final Sprite sprite;
    private final List<Segment> plansza;
    private final JPanel panel;

    public SpriteController(Sprite sp, List<Segment> pl, JPanel pan) {
        sprite = sp;
        plansza = pl;
        panel = pan;
    }

    @Override
    public void run() {
        while (true) {
            sprite.tick();
            for (Segment s : plansza) {
                s.tick();
            }
            panel.repaint();
			Thread.yield();
            try {
				Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
