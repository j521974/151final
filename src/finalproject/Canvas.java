package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	private ArrayList<DShape> shapeList = new ArrayList<>();
	
	public Canvas(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400,400));
        this.setBackground(Color.PINK);
	}
	
	public void paintComponent(){
		for(DShape shape: shapeList){
			shape.draw();
		}
	}
	
	public void addShape(DShapeModel model){

	}


}
