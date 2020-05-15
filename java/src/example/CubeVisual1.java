package example;

import ie.tudublin.Visual;

public class CubeVisual1 extends Visual
{
    public void settings()
    {
        size(800, 600, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
        //startListening();
        loadAudio("heroplanet.mp3");
        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    float angle = 0;

    public void draw()
    {
        background(0);
        calculateAverageAmplitude();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        strokeWeight(5);
        noFill();
        lights();
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        pushMatrix();
        translate(0, 0, -200);
        rotateX(angle);
        rotateZ(angle);       
        float boxSize = 50 + (200 * getAmplitude()); 
        box(boxSize);   
        popMatrix();
        

    }


}