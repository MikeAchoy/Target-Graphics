//Imported packages.
import javax.swing.JFrame;

//App class main function driver class.
public class App {
    //Main function.
    public static void main(String [] args){
        startWindow();
    }
    
    public static void startWindow(){
        //Create new JFrame and set default close operation.
        JFrame window = new JFrame("Random Shots");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        //Create new canvas with orriden MyCanvas class.
        MyCanvas canvas = new MyCanvas();
    
        //Add MyCanvas element to window and set various functions.
        window.add(canvas);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
