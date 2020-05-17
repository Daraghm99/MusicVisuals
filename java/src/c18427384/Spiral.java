package c18427384;

import processing.core.*;


public class Spiral {
    
    Rectangular r;

    public Spiral(Rectangular r){
        this.r = r;
    }

    void renderSpiral(){
        
        r.translate(r.left + 150, r.height/2);
        float radius = 100;
        float theta = 0;
        float thetaInc = PApplet.TWO_PI/100;

        for(int i = 0;i < 100;i++){
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            r.ellipse(x, y, 4, r.getSmoothedAmplitude());
            theta += thetaInc; 
        }

        r.translate(r.sright + 600, 0);
        
        for(int i = 0;i < 100;i++){
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            r.ellipse(x, y, 4, r.getSmoothedAmplitude());
            theta += thetaInc; 
        }
    }
}