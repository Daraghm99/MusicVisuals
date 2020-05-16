package c18427384;
import processing.core.*;

public class rectBands {

    Rectangular mv;
    float ypos = 1000;

    public rectBands(Rectangular mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        mv.noFill();
        mv.strokeWeight(2);
        mv.lights();
        float gap = mv.width / (float) mv.getBands().length;
        for(int i = 0 ; i < mv.getBands().length; i ++)
        {
            mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 200, 255);
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255); 
            mv.pushMatrix();
            mv.translate(gap * i, ypos, -400);
            mv.box(-mv.getSmoothedBands()[i] * 0.3f);
            mv.popMatrix();
        }
    }
}