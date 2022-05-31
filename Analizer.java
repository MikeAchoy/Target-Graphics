import java.util.Vector;

public class Analizer{

    private int xCordinate;
    private int yCordinate;

    private Vector <Integer> xCordinateLog;
    private Vector <Integer> yCordinateLog;

    //Sets x-cordiante data vector.
    public void setXCordinateLog(Vector <Integer> xCordinateLogToSet){
        this.xCordinateLog = xCordinateLogToSet;
    }

    //Sets y-cordiante data vector.
    public void setYCordinateLog(Vector <Integer> yCordinateLogToSet){
        this.yCordinateLog = yCordinateLogToSet;
    }

    //Sets single x-cordinate.
    public void setXCordinate(int xCordinateToSet){
        this.xCordinate = xCordinateToSet;
    }

    //Sets single y-cordinate.
    public void setYCordinate(int yCordinateToSet){
        this.yCordinate = yCordinateToSet;
    }

    //Returns single x-cordinate.
    public int getXCordinate(){
        return this.xCordinate;
    }

     //Returns single y-cordinate.
    public int getYCordinate(){
        return this.yCordinate;
    }

    //Prints average cordinate position in rectangular cordinate format.
    public void printAverageCordinateValue(){
        float averageXCordinate;
        float averageYCordinate;
        int sumOfXValues = 0;
        int sumOfYValues = 0;
        int numberOfCordinates = this.xCordinateLog.size();
        if(this.xCordinateLog.size() != this.yCordinateLog.size()){
            System.out.println("ERROR: Data vector size not equal.");
        } else{
            //Iterate through data vectors and get sum.
            for(int i = 0; i < numberOfCordinates; i++){
                sumOfXValues += this.xCordinateLog.get(i);
                sumOfYValues += this.yCordinateLog.get(i);
            }
        }
        averageXCordinate = sumOfXValues / numberOfCordinates;
        averageYCordinate = sumOfYValues / numberOfCordinates;
        System.out.println("Average cordinate: (" + averageXCordinate + ", " + averageYCordinate + ")");
    }

    //Returns number of points hit based on location of shot cordinates.
    public int getNumberOfPoints(){
        //Declare data variables.
        int pointsHit = 0;
        int xCordinateSelected;
        int yCordinateSelected;
        //Check if both data vector sizes match.
        if(this.xCordinateLog.size() != this.yCordinateLog.size()){
            System.out.println("ERROR: data vector sizes do not match.");
        }
        //If data vector sizes match do this.
        else{
            for(int i = 0; i < this.xCordinateLog.size(); i++){
                //Get current index cordinate pair.
                xCordinateSelected = this.xCordinateLog.get(i);
                yCordinateSelected = this.yCordinateLog.get(i);
                //Tests to determine where within the circle they land for points. 
                //Center of circle (500, 400)
                //using euqation of a circle (x - 500)^2 + (y - 400)^2 = r^2
                //Test 10 point block.
                if(((Math.pow(xCordinateSelected - 500, 2))+(Math.pow(yCordinateSelected - 400, 2))) <= (Math.pow(25, 2))){
                    pointsHit += 10;
                } else{
                    //Test for 5 point block.
                    if((((Math.pow(xCordinateSelected - 500, 2))+(Math.pow(yCordinateSelected - 400, 2))) <= (Math.pow(90, 2))) && (((Math.pow(xCordinateSelected - 500, 2))+(Math.pow(yCordinateSelected - 400, 2))) > (Math.pow(25, 2)))){
                        pointsHit += 5;
                    } else{
                        //Test for 4 point block.
                        if(() && ()){

                        } else{
                            //Test for 2 point block.
                            if(){

                            } else{
                                //Test for 1 point block.
                                if(){

                                } else{
                                    // Add no points to pointsHit for shots out of all point bounds.
                                    pointsHit += 0;
                                }
                            }
                        }
                    }
                }
            }   
        }
    }
}
