package c18427384;

import processing.core.*;


public class Spiral {
    
    Rectangular r;
    //Creating an array list to hold our points
    Spiral[] spirals = new Spiral[100];

    //Spiral Constructor
    public Spiral(Rectangular r){
        this.r = r;
    }

    void renderSpiral(){
        //Translating to where it will show up based on rectangualr
        r.translate(r.left + 300, r.height/2);
        //setting the radius
        float radius = 100;
        //Initialising theta to 0
        float theta = 0;
        //Setting thetaInc to two_pi/100 which would be 6.28/100 
        float thetaInc = PApplet.TWO_PI/100;

        //this will draw two spirals to the screen
        //The colours of the points of the spiral will change based on the smoothed amplitude 
        for(int i = 0;i < spirals.length;i++){
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            //Drawing our ellipse which will change colour based on the amplitude, 
            r.ellipse(x, y, 4, r.getSmoothedAmplitude());
            theta += thetaInc; 
        }

        //Translate for the right side of the screen
        r.translate(r.sright + 300, 0);
        
        for(int i = 0;i < spirals.length;i++){
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            r.ellipse(x, y, 4, r.getSmoothedAmplitude());
            theta += thetaInc; 
        }
    }
}