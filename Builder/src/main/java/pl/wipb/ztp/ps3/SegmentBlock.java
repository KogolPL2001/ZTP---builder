package pl.wipb.ztp.ps3;

/**
 * Segment bez mozliwosci przejscia
 */
class SegmentBlock extends Segment {

    public SegmentBlock(int x, int y, String file) {
        super(x, y, file);
    }

    @Override
    public void collisionV(Sprite sprite) {
        sprite.stopJump();
    }

    @Override
    public void collisionH(Sprite sprite) {
        sprite.stopMove();
    }
    
}
