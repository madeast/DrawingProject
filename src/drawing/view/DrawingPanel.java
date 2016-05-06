package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import drawing.controller.DrawController;

public class DrawingPanel extends JPanel
{

	private DrawController baseController;
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private JButton addRectangleButton;
	private JButton addTriangleButton;
	private JButton addPolygonButton;
	private JButton addCircleButton;
	private JButton changeGraphButton;
	private JButton addEllipseButton;
	private JButton addSquareButton;
	private JButton changeShapeButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	
	public DrawingPanel(DrawController baseController)
	{
		this.baseController = baseController;
		addRectangleButton = new JButton("Rectangle");
		addTriangleButton = new JButton("Triangle");
		addPolygonButton = new JButton("Polygon");
		addCircleButton = new JButton("Circle");
		addSquareButton = new JButton("Square");
		addEllipseButton = new JButton("Ellipse");
		changeShapeButton = new JButton("Shape");
		changeGraphButton = new JButton("Graph");
		shapePanel = new ShapePanel();
		graphPanel = new GraphPanel();
		baseLayout = new SpringLayout();
		
		setupLayout();
		setupListeners();
		setupPanel();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(addRectangleButton);
		this.add(addTriangleButton);
		this.add(addPolygonButton);
		this.add(addCircleButton);
		this.add(addEllipseButton);
		this.add(changeShapeButton);
		this.add(shapePanel);
		this.add(graphPanel);
		this.add(addSquareButton);
		this.add(changeGraphButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, changeGraphButton, 0, SpringLayout.NORTH, changeShapeButton);
		baseLayout.putConstraint(SpringLayout.EAST, changeGraphButton, -89, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addPolygonButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addPolygonButton, 6, SpringLayout.EAST, addTriangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addTriangleButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addTriangleButton, 6, SpringLayout.EAST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addCircleButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addCircleButton, 6, SpringLayout.EAST, addPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 0, SpringLayout.NORTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 6, SpringLayout.EAST, shapePanel);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, changeShapeButton, 4, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -7, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -339, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 511, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 6, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, changeShapeButton, 0, SpringLayout.EAST, addTriangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 39, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -7, SpringLayout.NORTH, addSquareButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addSquareButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addSquareButton, 6, SpringLayout.EAST, addCircleButton);
	}

	private void setupListeners()
	{
		changeGraphButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.setVisible(false);
				repaint();
				graphPanel.setVisible(true);
				repaint();
			}
		});
		
		changeShapeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				graphPanel.setVisible(false);
				repaint();
				shapePanel.setVisible(true);
				repaint();
			}
		});
			
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		addTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		addPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
		
		addCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
		
		addSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});
		
		addEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
	}
	
	

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.MAGENTA);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(90,10,20,40));
	}

	public DrawController getBaseController()
	{
		return baseController;
	}

	public void setBaseController(DrawController baseController)
	{
		this.baseController = baseController;
	}

	public ShapePanel getShapePanel()
	{
		return shapePanel;
	}

	public void setShapePanel(ShapePanel shapePanel)
	{
		this.shapePanel = shapePanel;
	}

	public JButton getAddRectangleButton()
	{
		return addRectangleButton;
	}

	public void setAddRectangleButton(JButton addRectangleButton)
	{
		this.addRectangleButton = addRectangleButton;
	}

	public SpringLayout getBaseLayout()
	{
		return baseLayout;
	}

	public void setBaseLayout(SpringLayout baseLayout)
	{
		this.baseLayout = baseLayout;
	}

	public ArrayList<Rectangle> getRectangleList()
	{
		return rectangleList;
	}

	public void setRectangleList(ArrayList<Rectangle> rectangleList)
	{
		this.rectangleList = rectangleList;
	}
	
	
}

