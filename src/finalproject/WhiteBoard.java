
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WhiteBoard extends JFrame implements ModelListener{

	WhiteBoard whiteboard;
	static String fontAction;
	public static JTextField text;
	static JPanel panel;

	public WhiteBoard() {
		whiteboard= this;
		whiteboard.setBackground(Color.BLUE);
		whiteboard.setLayout(new BoxLayout(whiteboard.getContentPane(), BoxLayout.X_AXIS));
		
		
		Box shapeBox = Box.createHorizontalBox();
		Canvas c = new Canvas();
		JButton rectangleButton = new JButton("Rect");
		JButton ovalButton = new JButton("Oval");
		JButton lineButton = new JButton("Line");
		JButton textButton = new JButton("Text");
				
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.addShape(new DRectModel());
				modelChanged(new DShapeModel());
			}
		});

		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.addShape(new DOvalModel());
				modelChanged(new DShapeModel());

			}
		});
		
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.addShape(new DLineModel());
				modelChanged(new DShapeModel());

			}
		});
		
		textButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.addShape(new DTextModel());
				modelChanged(new DShapeModel());
			}
		});
	
		shapeBox.add(Box.createRigidArea(new Dimension(10, 75)));

		shapeBox.add(Box.createRigidArea(new Dimension(5, 0)));
		shapeBox.add(rectangleButton);
		shapeBox.add(Box.createRigidArea(new Dimension(10, 0)));
		shapeBox.add(ovalButton);
		shapeBox.add(Box.createRigidArea(new Dimension(10, 0)));
		shapeBox.add(lineButton);
		shapeBox.add(Box.createRigidArea(new Dimension(10, 0)));
		shapeBox.add(textButton);

		Box setColorBox = Box.createHorizontalBox();
		setColorBox.add(Box.createRigidArea(new Dimension(15, 0)));
		JButton setColorButton = new JButton("Set Color");
		setColorBox.add(setColorButton);
		

		setColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a Color", Color.GRAY);
                if(color != null && c.selectedShape != null) {
                    c.selectedShape.getModel().setColor(color);
                    modelChanged(c.selectedShape.getModel());
                }
            }
        });
		
		Box fontBox = Box.createHorizontalBox();
		JTextField textField = new JTextField();
		textField.setMaximumSize(new Dimension(100, 25));
		JButton fontButton = new JButton("font");
		fontButton.setSize(new Dimension(100, 100));
		fontBox.add(Box.createRigidArea(new Dimension(10, 0)));
		fontBox.add(textField);
		fontBox.add(Box.createRigidArea(new Dimension(10, 75)));
		fontBox.add(fontButton);
		
		fontButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				}
			
		});

		

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
		
		Box serverClientBox = Box.createHorizontalBox();
		serverClientBox.add(Box.createRigidArea(new Dimension(10,0)));
		JButton server = new JButton("Start Server");
		JButton client = new JButton("Start Client");
		serverClientBox.add(server);
		serverClientBox.add(Box.createRigidArea(new Dimension(10,0)));
		serverClientBox.add(client);
		
		
		/**
		 * The server should prompt for a port­number to use, but provide a default, 
		 * so the user can just hit return to take the default.
		 * @param b
		 */
		server.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String p = JOptionPane.showInputDialog("Enter number");
				try{
					int number = Integer.parseInt(p);
				}
				catch(IllegalArgumentException eo){
			}
			}
		});
		
		Box saveBox = Box.createHorizontalBox();
		saveBox.add(Box.createRigidArea(new Dimension(10,0)));
		JButton save = new JButton("Save");
		JButton open = new JButton("Open");
		saveBox.add(save);
		saveBox.add(Box.createRigidArea(new Dimension(10,0)));
		saveBox.add(open);
		
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = createFileChooser();
				File file = chooser.getSelectedFile();
				
			}
			
		});
	
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentY(TOP_ALIGNMENT);
		verticalBox.add(shapeBox);
		verticalBox.add(setColorBox);
		verticalBox.add(fontBox);
		verticalBox.add(moveBox);
		verticalBox.add(serverClientBox);
		for (Component x : verticalBox.getComponents()) {
			((JComponent) x).setAlignmentX(Box.LEFT_ALIGNMENT);
		}

		whiteboard.add(verticalBox, BorderLayout.PAGE_START);
		whiteboard.add(c, BorderLayout.CENTER);
		whiteboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		whiteboard.pack();
		whiteboard.setVisible(true);

	}
	
	/**
	 * this method gets all the font style
	 * @param panel
	 */
	public static void getAllFonts(JPanel panel){
		//from http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/
		//Togetallavailablefontsinyoursystem.htm
		  GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		  Font[] fonts = e.getAllFonts(); 
		  String[] list = new String[fonts.length];
		  for(int i=0; i<list.length;i++){
			  list[i] = fonts[i].getName();//get every single font name
		  }
		  JComboBox fontList = new JComboBox(list);
		  fontList.setSelectedIndex(0);
		  fontListListener(fontList);
	}
	/**
	 * this method set the default font to dialog size 10
	 * and will change to the font user selects
	 * @param b
	 */
	public static void fontListListener(JComboBox b){
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox s = (JComboBox) e.getSource();
				fontAction = (String) s.getSelectedItem();
				text.setFont(new Font("Dialog",Font.PLAIN,10));

			}
			
		});
	}
	public void saveImageFile(File file){
		 BufferedImage image = (BufferedImage) createImage(getWidth(), getHeight());
		 Graphics g = image.getGraphics();
		 paintAll(g);
		 g.dispose();
		 try{
			 javax.imageio.ImageIO.write(image, "PNG", file);
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	}
    protected JFileChooser createFileChooser() {
    	JFileChooser c = new JFileChooser();
    	try {
    	    File file = new File(new File(".").getCanonicalPath());
    	    c.setCurrentDirectory(file);
    	}
    	catch (Exception ex) {
    	    ex.printStackTrace();
    	}
    	return c;
    }
	public static void main(String[] args) {
			  new WhiteBoard();
	}

	@Override
	public void modelChanged(DShapeModel model) {
		whiteboard.repaint();
	}
}
