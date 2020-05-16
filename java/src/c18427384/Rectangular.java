package c18427384;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;


public class Rectangular extends Visual {

    boolean up = true;
    boolean across = false;
    boolean complete = false;
    float xpos;
    float upos = 700;
    float dpos = 0;
    float left = width * 0.1f;
    float right = width * 20f;
    float sright = width * 20f;
    float sleft = width * 0.1f;
    float top = height * 0.1f;
    float bottom = height * 20f;

    rectBands abv;

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

        abv = new rectBands(this);
    }

    public void keyPressed(){
        if(key == '1'){
           across = ! across;
        }if(key == '2'){
            complete = ! complete;
        }      
    }
    
    float angle = 0;
    public void draw(){

        calculateFrequencyBands();
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
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255, 245);
        float boxSize = 200 + (200 * getAmplitude());
        float sphereSize = 50 + (100 * getAmplitude());
        if(up){
            
            //Box that will gradually move up the screen 
            pushMatrix();
            translate(left, upos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            //2nd box
            pushMatrix();
            translate(right, upos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            if(upos >= top){
                upos -= 1;
            }

            if(across){
                
                pushMatrix();
                translate(sleft, height/2, -300);
                rotateX(angle);
                rotateY(angle);           
                sphere(sphereSize);
                popMatrix();
                angle += 0.01f;
    
                pushMatrix();
                translate(sright, height/2, -300);
                rotateX(angle);
                rotateY(angle);           
                sphere(sphereSize);
                popMatrix();
                angle += 0.01f;
                
                if(sright >= 1000 && sleft <= 1000){
                    sleft += 2;
                    sright -= 2;
                }
                if(sleft == 1002 && sright == 1008){
                    pushMatrix();
                    translate(sright, height/2, -25);
                    rotateX(angle);
                    rotateY(angle);           
                    box(boxSize);
                    popMatrix();
                    angle += 0.01f;
                    
                    abv.render();
                }
            }
        }else{
            //Drawing an initial Box
            pushMatrix();
            translate(left, 700, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            pushMatrix();
            translate(right, 700, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            //Drawing the two spheres at the sides
            pushMatrix();
            translate(left, height/2, -300);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;

            pushMatrix();
            translate(right, height/2, -300);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;
            
        }
        abv.render();

    }


    
}