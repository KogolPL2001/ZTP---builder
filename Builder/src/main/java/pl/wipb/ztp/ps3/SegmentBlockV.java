package pl.wipb.ztp.ps3;

/**
 * Segment, na ktory mozna wskoczyc
 */
class SegmentBlockV extends Segment {

    public SegmentBlockV(int x, int y, String file) {
        super(x, y, file);
    }

    @Override
    public void collisionV(Sprite sprite) {
        if (sprite.jumpingDown() && sprite.getBottomY() == y) {
            sprite.stopJump();
        }
    }
    
}
