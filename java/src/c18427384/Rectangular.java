package c18427384;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;


public class Rectangular extends Visual {

    boolean up = false;
    float xpos;
    float ypos = 100;

    public void settings()
    {
        size(800, 800, P3D);
    }

    public void setup()
    {
        colorMode(HSB);

        startMinim();
        frameRate(60);
        loadAudio("heroplanet.mp3");
        getAudioPlayer().play();
    }

    public void keyPressed(){
        if(key == '1'){
            up = ! up;
        }
    }
    
    float angle = 0;
    public void draw(){

        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        background(0);
        noFill();
        lights();
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        float boxSize = 100 + (200 * getAmplitude());
        float sphereSize = 50 + (100 * getAmplitude());

        if(up){
            
            pushMatrix();
            translate(-100, ypos, -400);
            box(boxSize);
            popMatrix();
            
            if(ypos > -200){
                ypos -= 1;
            }      
        }
        else{
            //Drawing an initial Box
        pushMatrix();
        translate(-100, 100, -400);
        rotateY(angle);
        rotateX(angle);
        box(boxSize);
        popMatrix();

        //Drawing an initial sphere
        pushMatrix();
        translate(-150, 150, -600);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;
        }

    }


    
}