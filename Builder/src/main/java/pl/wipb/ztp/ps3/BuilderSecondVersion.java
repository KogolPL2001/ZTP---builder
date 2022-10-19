package pl.wipb.ztp.ps3;

import java.util.ArrayList;
import java.util.List;

class BuilderSecondVersion extends Builder
{
    private final List<Segment> plansza;
    public BuilderSecondVersion()
    {
        plansza = new ArrayList<>();
    }
    void addSegmentBlock(int x, int y)
    {
        Segment s = new SegmentBlock(x, y, "block1.png");
        plansza.add(s);
    }
    void addSegmentBlockV(int x, int y)
    {
        Segment s = new SegmentBlockV(x, y, "block2.png");
        plansza.add(s);
    }
    void addSegment(int x, int y)
    {
        Segment s = new SegmentBlock(x, y, "block3.png");
        plansza.add(s);
    }
    void addSegmentAmin(int x, int y)
    {
        Segment s = new SegmentAnim(x, y, "bonus.png", new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 0, 0});
        plansza.add(s);
    }
    List<Segment> build()
    {
        return plansza;
    }
}