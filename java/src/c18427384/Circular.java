package c18427384;

import ie.tudublin.Visual;

public class Circular extends Visual {
    
    boolean dub = false;
    boolean quad = false;


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
            dub = ! dub;
        }
        if(key == '2'){
            quad = ! quad;
        }
    }



    float angle = 0;
    public void draw(){
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);


        //Sphere and cube will double
        if(dub){
            float sphereSize = 50 + (100 * getAmplitude());
            pushMatrix();
            translate(0, 0, -300);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;

            //drawing a cube to hold the sphere in
            float boxSize = 100 + (200 * getAmplitude());
            pushMatrix();
            translate(0, 0, -100);
            box(boxSize);
            popMatrix();

           //extra sphere will populate the right edge of the cube
            pushMatrix();
            translate(325, 0, -700);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;


        }
        else{
            //A rotating Sphere
            float sphereSize = 50 + (100 * getAmplitude());
            pushMatrix();
            translate(0, 0, -300);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;

            //drawing a cube to hold the sphere in
            float boxSize = 100 + (200 * getAmplitude());
            pushMatrix();
            translate(0, 0, -100);
            box(boxSize);
            popMatrix();

        }
    }     

}