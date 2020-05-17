package c18427384;

import processing.core.*;


public class Spiral {
    
    Rectangular r;

    public Spiral(Rectangular r){
        this.r = r;
    }

    void renderSpiral(){
        //Translating to where it will show up based on rectangualr
        r.translate(r.left + 300, r.height/2);
        //setting the radius
        float radius = 100;
        float theta = 0;
        float thetaInc = PApplet.TWO_PI/100;

        //this will draw two spirals to the screen
        //The colours of the points of the spiral will change based on the smoothed amplitude 
        for(int i = 0;i < 100;i++){
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            r.ellipse(x, y, 4, r.getSmoothedAmplitude());
            theta += thetaInc; 
        }

        r.translate(r.sright + 300, 0);
        
        for(int i = 0;i < 100;i++){
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            r.ellipse(x, y, 4, r.getSmoothedAmplitude());
            theta += thetaInc; 
        }
    }
}