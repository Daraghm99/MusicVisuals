# Music Visualiser Project

Name: Daragh Murnane

Student Number: C18427384

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
Our goal for this assignment was to create "Something beautiful to enjoy while listening to music".
We could create something that responded to a singular piece of music or the music that was playing at the
time. We were given some starter code with examples that I forked and created my own package that is named my 
Student Number. To complete this assignment and create my audio visualizer I looked over the examples we did 
in class and did some self directed learning aswell to get the most out of this assignment.

I created an audio visualizer that would respond to any piece of music and each object on screen will respond whether 
by changing shape or colour based on what is playing at the time. 

# Instructions
I wanted this to be a simple audio visualizer without many controls, when the user presses the spacebar the music will
start playing and two cubes will start to rise, The final instruction to get the most out of this visualizer is to press
the '1' on your keyboard to get all the effects on the screen. These are done by using the KeyPressed method in the Rectangular
class

# How it works
- To start this assignment I laid out a goal I was trying to reach and would reach by the end, 
I wanted to delve into 3D objects and in particular how they move and respond to movement.
- Rectangular is my main class in the program and controls how the 3D shapes move. Once the spacebar is pushed by the user, start
will equate to true and the music will start playing and the two cubes will rise to the top of the screen they will be changing size based on the amplitude 
during this.
- The user can push '1' at any time which gives the user a certain freedom over how and when they want the visualastions to display
to the screen. 
- When '1' is pushed across will evaluate to True and two spheres will start at either side of the screen. I wanted there to be a certain anticipation by the user so they are drawn
in and want to see what happens when the two spheres meet in the middle.
- When the two spheres meet a box is created that encapsulates the two of them inside. Each shapes size is responding to the amplitude of the 
audio that is playing 
- I looked over the examples for WaveForm and AudioBandsVisual to see how to call methods from other classes that were not subclasses of PApplet.
- Once the spheres collide there are 3 methods called, a render method in boxBands which displays the frequency bands to the screen in an aesthethic way using boxes.
The boxes grow and shrink based on the frequency bands while the stroke changes colour based on the amplitude. The fill for these boxes is set based on the length of the 
bands.
- The spiral render method creates two spirals each in the middle left and middle right. This is done by panning 100 ellipses in a circular motion. these miniture ellipses change colour
based on the amplitude and when everything is running together look very nice as the user can see the colour of each individual ellipse.
- I wanted to bring in the theme of space to this assignment and to do this I created the Star class. When the render method in Star gets called it uses a for loop and an array list to output
the 'stars' which are miniture ellipses to the screen. This is a very relaxing method and is very easy to watch ai It feels like you are travelling through space on the screen as everything is taking place. These ellipses also change colour based 
on the amplitude of the song
- As the amplitude increases and decreases in the song the spheres and double cube at the top of the screen will pop in and out of the screen. I really enjoyed creating this as I feel it adds a lot to the visualizer 
as there is always something new happening on screen
- The user can then sit back and enjoy the visualisations on screen and sit back and enjoy their favourite music.   

# What I am most proud of in the assignment

1.3D shapes: It was my goal during this assignment to learn more about 3D shapes in
processing. At the end of the assignment I wanted to be able to make 3D objects move and respond to music, 
I feel I have reached that goal and am proud because of that and enjoyed the process of learning about boxes and spheres in processing.

2.Colour: I enjoyed the colour of this assignment and creating it was very visually pleasing. By the end of the assignment i enjoyed the Sychronisity of having
most of the shapes in the visualizer grow and shrink together while maintaining the same colour as eachother.
I also enjoyed making a distinct difference in colour between some objects and others as I feel it brings a deal of contrast to the visualizer

3.Animations: My favourite part of creating this assignment was when I was creating the animations such as the collision between the two sphere objects, I feel that it was interesting creating
this animation as most of the onscreen methods are not called until this takes place. This places a great deal of importance on this animation as there has to be enough 
visually pleasing elements on screen after which I think I managed to do which I am proud of. It also brought me back to the fun of creating animations. I enjoy the way it looks as it goes from
a busy audio visualizer when the music is playing and the contrast of that when the music stops.

#YoutubeVideo

Link to Youtube Video =  https://youtu.be/JiXVR3jE7tE

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

