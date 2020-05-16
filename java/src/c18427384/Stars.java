package c18427384;

import processing.core.*;

public class Stars {

    Rectangular r;
    Stars[] stars = new Stars[5];

    public Stars(Rectangular r){
        this.r = r; 
    }


    void render_stars(){
        
        for(int i = 1; i < stars.length; i++) {
            r.fill(255);
            r.stroke(PApplet.map(r.getAmplitude(), 0, 1, 0, 255), 255, 255);
            r.ellipse(r.random(r.width), r.random(r.height), 2, 2);
        }


    }
    
}