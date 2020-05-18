package c18427384;
import processing.core.*;

public class boxBands {

    Rectangular r;
    //Initialising ypos
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
        //Getting the gap in between each box 
        float gap = r.width / (float) r.getBands().length;
        //For loop to produce boxes based on the length of getBands() (There will be 9 bands)
        for(int i = 0 ; i < r.getBands().length; i ++)
        {
            //stroke which will be the outside of the boxes will change based on the amplitude which is in line with our other shapes
            r.stroke(PApplet.map(r.getSmoothedAmplitude(), 0, 1, 0, 255), 200, 255);
            //The fill which is the inside of the shape will be based on getBands()
            r.fill(PApplet.map(i, 0, r.getBands().length, 255, 0), 255, 255); 
            r.pushMatrix();
            //Translating our boxes
            r.translate(gap * i, ypos, -400);
            //Drawing our boxes - the size will be based on getSmoothedBands and they will grow and shrink accordingly
            r.box(-r.getSmoothedBands()[i] * 0.3f);
            r.popMatrix();
        }
    }
}