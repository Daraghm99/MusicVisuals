package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import example.CubeVisual1;
import c18427384.Circular;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Circular());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}