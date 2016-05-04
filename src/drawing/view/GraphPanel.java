package drawing.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		//initialize graphSource here
		graphSource = new int[] {2, 5, 7, 323, 23,24,37};
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		for(int index = 0; index < graphSource.length; index++)
		{
			//Draw a rectangle for each value in the array.
			int height = this.getHeight()/graphSource.length;
			int width = (int)((graphSource[index] / 200.00) * this.getWidth());
			int xPosition = 0;
			int yPosition = height * index;
			
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(new Rectangle(xPosition, yPosition, width, height));
		}
	}
	
	
}
