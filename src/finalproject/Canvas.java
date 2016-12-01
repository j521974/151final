import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
	
	public void paintComponent(Graphics g){
		for(DShape shape: shapeList){
			if(shape instanceof DRect){
				DRect rectangle = new DRect(shape.model);
			}
			else if(shape instanceof DOval){
				DOval oval = new DOval(shape.model);
			}
		}
	}
	
	public void addShape(DShape model){
		shapeList.add(model);
	}


}
