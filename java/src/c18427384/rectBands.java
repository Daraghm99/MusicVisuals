package c18427384;
import ddf.minim.analysis.FFT;
import processing.core.*;

public class rectBands {
    
    Rectangular mv;

    public rectBands(Rectangular mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        mv.noFill();
        mv.strokeWeight(2);
        float gap = mv.width / 30;
        float boxSize = 200 + (200 * mv.getAmplitude());
        for(int i = 0 ; i < 30; i ++)
        {
            mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255, -245);
            mv.pushMatrix();
            mv.translate(gap * i, 0, -300);
            mv.box(boxSize);
            mv.popMatrix();
        }
    }
}