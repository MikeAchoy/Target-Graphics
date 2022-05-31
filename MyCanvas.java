import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

//MyCanvas class definition.
public class MyCanvas extends JPanel{
    public MyCanvas(){
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.white);
    }
    //PaintComponent override class constructor.
    @Override
    protected void paintComponent(Graphics g){
        //Initializers.
        super.paintComponent(g);
        PaintBrush myBrush = new PaintBrush(g, true);
        //Brush Draw functions for drawing onto canvas.
        //Center of target is (500, 400).
        myBrush.drawTarget();
        myBrush.drawAxisMarks();
        myBrush.shootRandomShots(20);
        myBrush.printCordinatesStacked();
    }
}
