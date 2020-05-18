package c18427384;

import processing.core.*;

public class Stars {

    Rectangular r;
    //Creating an array list for our stars
    Stars[] stars = new Stars[5];

    //Stars Constructor
    public Stars(Rectangular r){
        this.r = r; 
    }


    //This method gets called from the Recatagular Class
    //It fills the sky with ellipses that change colour based on the amplitude 
    void render_stars(){
        for(int i = 1; i < stars.length; i++) {
            r.fill(255);
            //Setting the stroke to change based on the amplitude to have consistency with our other shapes
            r.stroke(PApplet.map(r.getAmplitude(), 0, 1, 0, 255), 255, 255);
            //Drawing our small stars using the random function based on height and width
            r.ellipse(r.random(r.width), r.random(r.height), 2, 2);
        }


    }
    
}