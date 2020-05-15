package c18427384;

import ie.tudublin.Visual;

public class Circular extends Visual {
    
    public void settings()
    {
        size(800, 800, P3D);
    }

    public void setup()
    {
        //colorMode(HSB);

        startMinim();
        loadAudio("heroplanet.mp3");
        getAudioPlayer().play();
    }

    public void draw(){
        
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        strokeWeight(5);
        pushMatrix();
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -200);
        float sphereSize = 50 + (200 * getAmplitude());               
        sphere(sphereSize);
        popMatrix();

    }

}