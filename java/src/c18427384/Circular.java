package c18427384;

import ie.tudublin.Visual;

public class Circular extends Visual {
    
    boolean dub = false;
    boolean triple = false;
    boolean quad = false;
    boolean complete = false;


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
            triple = ! triple;
        }
        if(key == '3'){
            quad = ! quad;
        }
        if(key == '4'){
            complete = ! complete;
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
            render_dub();
        }
        if(triple){
            render_triple();
        }
        if(quad){
            render_quad();     
        }
        if(complete){
            render_complete();
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

            //extra sphere will populate the left edge of the cube
            pushMatrix();
            translate(-325, 0, -700);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;

            //extra sphere will populate the top of the cube
            pushMatrix();
            translate(0, -325, -700);
            rotateX(angle);
            rotateY(angle);
            rotateY(angle);             
            sphere(sphereSize);
            popMatrix();
            angle += 0.01f;

            //extra sphere will populate the bottom
            pushMatrix();
            translate(0, 325, -700);
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

    private void render_dub() {
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

    private void render_triple(){

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

        //extra sphere will populate the left edge of the cube
        pushMatrix();
        translate(-325, 0, -700);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;
    }

    private void render_quad(){
  
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

        //extra sphere will populate the left edge of the cube
        pushMatrix();
        translate(-325, 0, -700);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;

        //extra sphere will populate the bottom of the cube
        pushMatrix();
        translate(0, -325, -700);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;          

    }

    private void render_complete(){
    
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

        //extra sphere will populate the left edge of the cube
        pushMatrix();
        translate(-325, 0, -700);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;

        //extra sphere will populate the top of the cube
        pushMatrix();
        translate(0, -325, -700);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;

        //extra sphere will populate the bottom
        pushMatrix();
        translate(0, 325, -700);
        rotateX(angle);
        rotateY(angle);
        rotateY(angle);             
        sphere(sphereSize);
        popMatrix();
        angle += 0.01f;      


    }

}