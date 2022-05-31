import javax.swing.JFrame;

//App class main function driver.
public class App {
    //Main function.
    public static void main(String [] args){
        //Create new window and set default close operation.
        JFrame window = new JFrame("Random Shots");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create new canvas with orriden MyCanvas class.
        MyCanvas canvas = new MyCanvas();

        //Add canvas elemenets to window and set functionality.
        window.add(canvas);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
