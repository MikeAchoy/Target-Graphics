//Imported packages.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

//MyCanvas canvas (JPanel) class definition.
public class MyCanvas extends JPanel{
    //MyCanvas default constructor.
    public MyCanvas(){
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.white);
    }
    //PaintComponent override class constructor.
    @Override
    protected void paintComponent(Graphics g){
        //Allows proper painting of graphics without issues. 
        super.paintComponent(g);
        //Created instance of myBrush in order to draw to canvas object.
        PaintBrush myBrush = new PaintBrush(g, true);
        //myBrush Draw function calls for drawing onto canvas:
        //Draws target onto canvas.
        myBrush.drawTarget();
        //Draws axis marks onto canvas.
        myBrush.drawAxisMarks();

        //Draws 20 random with analyzer shots onto the canvas.
        myBrush.shootRandomShotsWAnalizer(20);

        //Prints labeled list of coordinates for the random shots drawn onto the canvas.
        myBrush.printCordinatesStacked();
    }
}
