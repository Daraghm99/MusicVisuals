package c18427384;
import processing.core.*;

public class boxBands {

    Rectangular r;
    float ypos = 1000;

    public boxBands(Rectangular r)
    {
        this.r = r; 
    }

    //This method gets called in the Rectangular Class
    public void render()
    {
        r.noFill();
        r.strokeWeight(2);
        r.lights();
        float gap = r.width / (float) r.getBands().length;
        for(int i = 0 ; i < r.getBands().length; i ++)
        {
            r.stroke(PApplet.map(r.getSmoothedAmplitude(), 0, 1, 0, 255), 200, 255);
            r.fill(PApplet.map(i, 0, r.getBands().length, 255, 0), 255, 255); 
            r.pushMatrix();
            r.translate(gap * i, ypos, -400);
            r.box(-r.getSmoothedBands()[i] * 0.3f);
            r.popMatrix();
        }
    }
}