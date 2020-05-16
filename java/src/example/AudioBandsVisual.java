package example;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual
{
    MyVisual r;

    public AudioBandsVisual(MyVisual mv)
    {
        this.r = r; 
    }

    public void render()
    {
        float gap = r.width / (float) r.getBands().length;
        r.noStroke();
        for(int i = 0 ; i < r.getBands().length ; i ++)
        {
            r.fill(PApplet.map(i, 0, r.getBands().length, 255, 0), 255, 255);
            r.rect(i * gap * 5, r.height, gap,-r.getSmoothedBands()[i] * 0.5f); 
        }
    }
}