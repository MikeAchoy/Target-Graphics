
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class PaintBrush {
    //Paint Brush Data members.
    private Graphics g;
    private boolean logCordinateElements;

    //Paint Brush shot cordinate analytics vectors.
    private Vector <Integer> xCordinateLog;
    private Vector <Integer> yCordinateLog;

    //Paint Brush class constructor.
    public PaintBrush(Graphics graphics, boolean logCordinateElementsToSet){
        g = graphics;
        logCordinateElements = logCordinateElementsToSet;
        xCordinateLog = new Vector<>();
        yCordinateLog = new Vector<>();
    }

    //Log cordinate boolean setter.
    public void setLogCordinateStatus(boolean boolInput){
        this.logCordinateElements = boolInput;
    }

    //Log cordinate boolean setter.
    public boolean getLogCordinateStatus(){
        return this.logCordinateElements;
    }

    //Target and draw shot functions:
    //Render target onto canvas.
    public void drawTarget(){
        //Draw target with different oval fills.
        g.setColor(Color.BLACK);
        drawOvalCenterCords(500, 400, 690, 690);
        g.setColor(Color.RED);
        fillOvalCenterCords(500, 400, 550,550);
        g.setColor(Color.WHITE);
        fillOvalCenterCords(500, 400, 350, 350);
        g.setColor(Color.RED);
        fillOvalCenterCords(500, 400, 180, 180);
        g.setColor(Color.WHITE);
        fillOvalCenterCords(500, 400, 50, 50);

        //Draw point indicators on target.
        g.setColor(Color.BLACK);
        g.drawString("10", 507, 405);
        g.drawString("5", 575, 405);
        g.drawString("4", 660, 405);
        g.drawString("2", 755, 405);
        g.drawString("1", 830, 405);
    }
    
    //Render target 100px marks for cordinate analysis./
    public void drawAxisMarks(){
        g.setColor(Color.BLACK);
        int width = 2;
        int height = 20;
        int xCordinate = 100;
        //Loop for drawing x-axis marks.
        for(int i = 0; i < 10; i++){
            fillRectCenterCords(xCordinate, 0, width, height);
            xCordinate += 100;
        }
        //Resize rect dimensions for y-axis marks.
        width = 20;
        height = 2;
        //Lopp for drawing y-axis marks.
        int yCordinate = 100;
        for(int i = 0; i < 8; i++){
            fillRectCenterCords(0, yCordinate, width, height);
            yCordinate += 100;
        }
    }

    //Draws shots based on numberOFShots.
    public void shootRandomShots(int numberOfShots){
        for(int i = 0; i < numberOfShots; i++){
            drawShot();
        }
    }
    
    //Draws shot based on random cordinates.
    public void drawShot(){
        int randomXCordinate = randomPointXCord();
        int randomYCordinate = randomPointYCord();
        g.setColor(Color.GREEN);
        fillRectCenterCords(randomXCordinate, randomYCordinate, 2, 10);
        fillRectCenterCords(randomXCordinate, randomYCordinate, 10, 2);
        //If analytic logs are enables push xy-cordinates to data vector.
        if(this.logCordinateElements == true){
            this.addXCordinateLog(randomXCordinate);
            this.addYCordinateLog(randomYCordinate);
        }
    }
    
    //Draws shot with specific cordinate points.
    public void drawShotWithCords(int x, int y){
        g.setColor(Color.BLACK);
        fillRectCenterCords(x, y, 3, 10);
        fillRectCenterCords(x, y, 10, 3);
    }

    //Prints midpoint based on two cordinate points.
    public void printMidpoint(int x1, int x2, int y1, int y2){
        float xMidpoint = (x1 + x2) / 2;
        float yMidpoint = (y1 + y2) / 2;
        System.out.print("Midpoint: ");
        System.out.println("(" + xMidpoint + ", " + yMidpoint + ")");
    }

    //Draw bounds test for cordinate analysis
    public void drawBoundTest(){
        //Bound Cordinates: x{423<->575}, y{313<->465}
        //Bound Center: xy(499, 389)
        int horizontalX = 499;
        int verticalY = 389;
        //Set vertical bar bound tester.
        g.setColor(Color.CYAN);
        fillRectCenterCords(horizontalX, 0, 1, 600);
        //Set horizontal bar bound tester.
        fillRectCenterCords(0, verticalY, 1, 600);
    }
    
    //Returns random x-cordinate based on canvas range.
    public int randomPointXCord(){
        int maxVal = 900;
        int minVal = 20;
        return (int)Math.floor(Math.random()*(maxVal-minVal+1)+minVal);
    }

    //Returns random y-cordinate based on canvas range.
    public int randomPointYCord(){
        int maxVal = 750;
        int minVal = 15;
        return (int)Math.floor(Math.random()*(maxVal-minVal+1)+minVal);
    }

    //Paint Brush Analizer function defintitions:
    //Adds x-cordinate integer to xCordinateLog data vector.
    public void addXCordinateLog(int xCordinateValue){
        this.xCordinateLog.addElement(xCordinateValue);
    }

    //Adds y-cordinate integer to yCordinateLog data vector.
    public void addYCordinateLog(int yCordinateValue){
        this.yCordinateLog.addElement(yCordinateValue);
    }

    //Returns cordinate value stored at indexValue in xCordinateLog.
    public int getXCordinateAtIndex(int indexValue){
        int cordinateAtIndex = this.xCordinateLog.get(indexValue);
        return cordinateAtIndex;
    }   

    //Returns cordinate value stored at indexValue in yCordinateLog.
    public int getYCordinateAtIndex(int indexValue){
        int cordinateAtIndex = this.yCordinateLog.get(indexValue);
        return cordinateAtIndex;
    }

    //Prints all x-cordinate values in the xCordinateLog data vector.
    public void printXCordinates(){
        for (Integer xCordinate : xCordinateLog) {
            System.out.println(xCordinate);
        }
    }

    //Prints all y-cordinate values in the xCordinateLog data vector.
    public void printYCordinates(){
        for (Integer yCordinate : yCordinateLog) {
            System.out.println(yCordinate);
        }
    }

    //Prints all xy-cordinate values side by side in console.
    public void printCordinates(){
        for(int i = 0; i < this.xCordinateLog.size(); i++){
            System.out.print(i+1 + ": (" + this.xCordinateLog.get(i) + ", "
            + this.yCordinateLog.get(i) + ") ");
        }
        System.out.println("\n");
    }

    //Prints all xy-cordinate values stacked vertically in console.
    public void printCordinatesStacked(){
        for(int i = 0; i < this.xCordinateLog.size(); i++){
            System.out.println((i + 1) + ": (" + this.xCordinateLog.get(i) + ", " + this.yCordinateLog.get(i) + ")");
        } 
        System.out.println("\n");
    }

    //Returns average x-cordinate value.
    public float getAverageXCordinate(){
        float averageXCordinate;
        int sumOfAllElements = 0;
        int numberOfElements = 0;
        for(int i = 0; i < this.xCordinateLog.size(); i++){
            sumOfAllElements += this.xCordinateLog.elementAt(i);
            numberOfElements ++;
        }
        averageXCordinate = sumOfAllElements / numberOfElements;
        return averageXCordinate;
    }

    //Returns average y-cordainte value.
    public float getAverageYCordinate(){
        float averageYCordinate;
        int sumOfAllElements = 0;
        int numberOfElements = 0;
        for(int i = 0; i < this.yCordinateLog.size(); i++){
            sumOfAllElements += this.yCordinateLog.elementAt(i);
            numberOfElements ++;
        }
        averageYCordinate = sumOfAllElements / numberOfElements;
        return averageYCordinate;
    }

    //Drawing centered corrected shapes functions:
    //Draws filled oval based on center cordinates instead of corner.
    public void fillOvalCenterCords(int x, int y, int width, int height){
        int adjustedXCordinate = x - (width / 2);
        int adjustedYCordinate = y - (height / 2);
        g.fillOval(adjustedXCordinate, adjustedYCordinate, width, height);
    }

    //Draws oval based on center ocrdinates, instead of corner.
    public void drawOvalCenterCords(int x, int y, int width, int height){
        int adjustedXCordinate = x - (width / 2);
        int adjustedYCordinate = y - (height / 2);
        g.drawOval(adjustedXCordinate, adjustedYCordinate, width, height);
    }

    public void fillRectCenterCords(int x, int y, int width, int height){
        int adjustedXCordinate = x - (width / 2);
        int adjustedYCordinate = y - (height / 2);
        g.fillRect(adjustedXCordinate, adjustedYCordinate, width, height);
    }
}
