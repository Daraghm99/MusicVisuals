package c18427384;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;


public class Rectangular extends Visual {

    boolean up = false;
    boolean down = false;
    float xpos;
    float ypos = 700;
    float left = width * 0.1f;
    float right = width * 20f;
    float top = height * 0.1f;

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
        if(key == '2'){
            down = ! down;
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
        //camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        float boxSize = 200 + (200 * getAmplitude());

        if(up){
            
            //Box that will gradually move up the screen 
            pushMatrix();
            translate(left, ypos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            //2nd box
            pushMatrix();
            translate(right, ypos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            if(ypos >= top){
                ypos -= 1;
            }

        if(down){
            ypos = 0;
            pushMatrix();
            translate(left, ypos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            pushMatrix();
            translate(right, ypos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            if(ypos <= 800){
                ypos += 1;
            }

        }      
        }
        else{
            //Drawing an initial Box
            pushMatrix();
            translate(left, 800, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            pushMatrix();
            translate(right, 800, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;
            
        }

    }


    
}