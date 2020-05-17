/*
    Program Description : This program has been created for the OOP 2nd year module
    final assignment. I will be using processing to create a scene relating to a piece
    of audio.

    Author : Daragh Murnane
    Student Number : C18427384  

*/


package c18427384;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;


public class Rectangular extends Visual {

    //Used to signify the start of the program
    boolean start = false;
    //User control when the spheres start moving
    boolean across = false;
    //Controls the boxes as they gradually move upward
    float upos = 700;
    //left side of the screen 
    float left = width * 0.1f;
    //right side of the screen
    float right = width * 20f;
    //Used to manage the spheres
    float sright = width * 20f;
    float sleft = width * 0.1f;
    //Top of the screen
    float top = height * 0.1f;
    //Bottom of the screen
    float bottom = height * 20f;

    //Used so we can call our render methods from other classes
    rectBands bands;
    Stars stars;
    Spiral spiral;

    public void settings()
    {
        //P3D is used as we are working with 3d shapes
        size(800, 800, P3D);
    }

    public void setup()
    {
        colorMode(HSB);

        startMinim();
        frameRate(60);
        //Loading audio
        loadAudio("heroplanet.mp3");

        //Initialising our class objects
        bands = new rectBands(this);
        stars = new Stars(this);
        spiral = new Spiral(this);
    }

    public void keyPressed(){
        //When the user presses the spacebar the boxes will start moving and the
        //music will play 
        if(key == ' '){
            start = ! start;
            getAudioPlayer().play();
            //When 1 is pressed the spheres will move gradually closer 
        }if(key == '1'){
            across = ! across;
        }      
    }
    
    //Used to control our rotations
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
        //Black Background
        background(0);
        noFill();
        lights();
        //Stroke on the objects will depend on the smoothed audio of the song
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255, 245);
        //Initialising boxSize so we can have consistency 
        float boxSize = 200 + (200 * getAmplitude());
        //Initialising sphereSize so we can have consistency 
        float sphereSize = 50 + (100 * getAmplitude());
        //When the user presses spacebar start will become true
        if(start){
            
            //Box that will gradually move up the screen 
            pushMatrix();
            translate(left, upos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            //2nd box that will gradually move up the screen at the beginning
            pushMatrix();
            translate(right, upos, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            //Will keep moving up until it reaches the top
            if(upos >= top){
                upos -= 1;
            }

            //Once the user presses 1 across will evaluate to true
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
                
                //The two spheres will gradually get closer together
                if(sright >= 1000 && sleft <= 1000){
                    sleft += 2;
                    sright -= 2;
                }
                //Once they meet in the middle
                if(sleft == 1002 && sright == 1008){
                    //A new box will be created to hold these spheres
                    pushMatrix();
                    translate(sright, height/2, -25);
                    rotateX(angle);
                    rotateY(angle);           
                    box(boxSize);
                    popMatrix();
                    angle += 0.01f;

                    if(getSmoothedAmplitude() > 0.1){
                        println(getSmoothedAmplitude());
                        pushMatrix();
                        translate(right, top, -400);        
                        sphere(sphereSize);
                        popMatrix();
                    }
    
                    
                    //Calling our render method from the boxBands Class
                    bands.render();
                    //Calling our render method from the Stars Class
                    stars.render_stars();
                    //calling our render method from the Spiral Class
                    spiral.renderSpiral();

                }

            }
        //If nothing is pressed this will be displayed to the screen until the user presses the spacebar      
        }else{
            //Drawing an initial Box
            pushMatrix();
            translate(left, 700, -400);
            rotateY(angle);
            rotateX(angle);
            box(boxSize);
            popMatrix();
            angle += 0.01f;

            //Second box
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

    }


    
}