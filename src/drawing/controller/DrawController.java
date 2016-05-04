package drawing.controller;

import drawing.view.DrawingFrame;
import drawing.view.DrawingPanel;

public class DrawController
{
	
	private DrawingPanel myDisplay;
	private DrawingFrame baseFrame;

	public DrawController()
	{
		baseFrame = new DrawingFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public DrawingPanel getMyDisplay()
	{
		return myDisplay;
	}

	public void setMyDisplay(DrawingPanel myDisplay)
	{
		this.myDisplay = myDisplay;
	}

	public DrawingFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(DrawingFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}
}
