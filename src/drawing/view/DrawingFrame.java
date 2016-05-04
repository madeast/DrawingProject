package drawing.view;

import javax.swing.JFrame;

import drawing.controller.DrawController;

public class DrawingFrame extends JFrame
{
	private DrawingPanel basePanel;
	private DrawController baseController;
	
	public DrawingFrame(DrawController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(800, 800);
		this.setTitle("Let's Draw");
		this.setResizable(false);
		this.setVisible(true);
	}
}
