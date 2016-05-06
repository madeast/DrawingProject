package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	
	public ShapePanel()
	{
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
	}
	
	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 700);
		int yPosition = (int)(Math.random() * 700);
		int width = (int)(Math.random() * 700);
		int height = (int)(Math.random() * 700);
		
		Rectangle rectangle = new Rectangle(xPosition, yPosition, width, height);
		rectangleList.add(rectangle);
	}
	
	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 700);
		int yPosition = (int)(Math.random() * 700);
		int width =(int)(Math.random() * 700);
		int height = width;
		
		Rectangle square = new Rectangle(xPosition, yPosition, width, height);
		squareList.add(square);
	}
	
	public void addEllipse()
	{
		int xPoint = (int)(Math.random() * 700);
		int yPoint = (int)(Math.random() * 700);
		int rectWidth = (int)(Math.random() * 700);
		int rectHeight = (int)(Math.random() * 700);
		
		Ellipse2D ellipse = new Ellipse2D.Double(xPoint, yPoint, rectWidth, rectHeight);
		ellipseList.add(ellipse);
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 700);
		int yPoint = (int)(Math.random() * 700);
		int diameter = (int)(Math.random() * 700);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter);
		circleList.add(circle);
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int [3];
		int [] yPoints = new int[3];
		xPoints = new int []{(int)(Math.random() * 700), (int)(Math.random() * 700), (int)(Math.random() * 700)};
		yPoints = new int []{(int)(Math.random() * 700), (int)(Math.random() * 700), (int)(Math.random() * 700)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 10) + 3;
		int [] xPoints = new int[numberOfSides];
		int [] yPoints = new int[numberOfSides];
		for (int sides = 0; sides < numberOfSides; sides++)
		{
			xPoints[sides] = (int)(Math.random() * 700);
			yPoints[sides] = (int)(Math.random() * 700);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		//Loops to do List.
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 20);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			mainGraphics.draw(current);
		}
		
		for(Polygon current : triangleList)
		{
			int randomStroke = (int)(Math.random() * 20);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			mainGraphics.draw(current);
		}
		
		for(Polygon current : polygonList)
		{
			int randomStroke = (int)(Math.random() * 20);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			mainGraphics.draw(current);
		}
		
		for(Ellipse2D current : circleList)
		{
			int randomStroke = (int)(Math.random() * 20);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			mainGraphics.draw(current);
		}
	}
	
	public void clear()
	{
		polygonList.clear();
		rectangleList.clear();
		triangleList.clear();
		circleList.clear();
		squareList.clear();
		ellipseList.clear();
	}
}
