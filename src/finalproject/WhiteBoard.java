package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WhiteBoard extends JFrame {

	WhiteBoard whiteboard;

	public WhiteBoard() {

		whiteboard.setLayout(new BoxLayout(whiteboard.getContentPane(), BoxLayout.X_AXIS));
		Box shapeBox = Box.createHorizontalBox();
		Canvas c = new Canvas();
		JButton rectangleButton = new JButton("Rect");
		JButton ovalButton = new JButton("Oval");
		JButton lineButton = new JButton("Line");
		JButton textButton = new JButton("Text");

		shapeBox.add(Box.createRigidArea(new Dimension(10, 75)));
		shapeBox.add(new JLabel(" Add "));
		shapeBox.add(Box.createRigidArea(new Dimension(5, 0)));
		shapeBox.add(rectangleButton);
		shapeBox.add(Box.createRigidArea(new Dimension(10, 0)));
		shapeBox.add(ovalButton);
		shapeBox.add(Box.createRigidArea(new Dimension(10, 0)));
		shapeBox.add(lineButton);
		shapeBox.add(Box.createRigidArea(new Dimension(10, 0)));
		shapeBox.add(textButton);

		Box setColorBox = Box.createHorizontalBox();
		setColorBox.add(Box.createRigidArea(new Dimension(43, 0)));
		JButton setColorButton = new JButton("Set Color");
		setColorBox.add(setColorButton);

		Box fontBox = Box.createHorizontalBox();
		JTextField textField = new JTextField();
		textField.setMaximumSize(new Dimension(100, 25));
		JButton fontButton = new JButton("font");
		fontButton.setSize(new Dimension(100, 100));
		fontBox.add(Box.createRigidArea(new Dimension(10, 0)));
		fontBox.add(textField);
		fontBox.add(Box.createRigidArea(new Dimension(10, 75)));
		fontBox.add(fontButton);

		Box moveBox = Box.createHorizontalBox();
		moveBox.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton frontButton = new JButton("Move to front");
		JButton backButton = new JButton("Move to back");
		JButton removeButton = new JButton("Remove shape");
		moveBox.add(frontButton);
		moveBox.add(Box.createRigidArea(new Dimension(10, 0)));
		moveBox.add(backButton);
		moveBox.add(Box.createRigidArea(new Dimension(10, 0)));
		moveBox.add(removeButton);

		Box verticalBox = Box.createVerticalBox();
		// verticalBox.setBorder(BorderFactory.createTitledBorder("Vertical
		// Box"));
		verticalBox.setAlignmentY(TOP_ALIGNMENT);
		verticalBox.add(shapeBox);
		verticalBox.add(setColorBox);
		verticalBox.add(fontBox);
		verticalBox.add(moveBox);
		for (Component x : verticalBox.getComponents()) {
			((JComponent) x).setAlignmentX(Box.LEFT_ALIGNMENT);
		}

		whiteboard.add(verticalBox, BorderLayout.PAGE_START);
		whiteboard.add(c, BorderLayout.CENTER);
		whiteboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		whiteboard.pack();
		whiteboard.setVisible(true);

	}

	public static void main(String[] args) {
		new WhiteBoard();
	}
}
