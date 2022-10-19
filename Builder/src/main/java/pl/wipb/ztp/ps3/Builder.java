package pl.wipb.ztp.ps3;

import java.util.List;

import javax.swing.JPanel;

abstract class Builder extends JPanel
{
    private List<Segment> plansza;
    void addSegmentBlock(int x,int y){}
    void addSegmentBlockV(int x,int y){}
    void addSegment(int x,int y){}
    void addSegmentAmin(int x,int y){}
    List<Segment> build(){ return plansza;}
}