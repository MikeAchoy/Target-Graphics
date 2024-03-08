// Imported packages.
import java.util.Vector;

// Analizer class definition.
public class Analizer{
    // Class data members.
    private int xCordinate;
    private int yCordinate;
    // Class data vector members.
    private Vector <Integer> xCordinateLog;
    private Vector <Integer> yCordinateLog;

    // Sets x-cordiante data vector.
    public void setXCordinateLog(Vector <Integer> xCordinateLogToSet){
        this.xCordinateLog = xCordinateLogToSet;
    }

    // Sets y-cordiante data vector.
    public void setYCordinateLog(Vector <Integer> yCordinateLogToSet){
        this.yCordinateLog = yCordinateLogToSet;
    }

    // Sets single x-cordinate.
    public void setXCordinate(int xCordinateToSet){
        this.xCordinate = xCordinateToSet;
    }

    // Sets single y-cordinate.
    public void setYCordinate(int yCordinateToSet){
        this.yCordinate = yCordinateToSet;
    }

    // Returns single x-cordinate.
    public int getXCordinate(){
        return this.xCordinate;
    }

    // Returns single y-cordinate.
    public int getYCordinate(){
        return this.yCordinate;
    }

    // Prints average cordinate position in rectangular cordinate format.
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

    // Prints coordinate pair closest to the center of the target.
    public void printMostAccurateCoordinateInSet(){
        int xCoordinateSelected;
        int yCoordinateSelected;
        int originX = 500;
        int originY = 400;
        int closestX = this.xCordinateLog.get(0), closestY = this.yCordinateLog.get(0);
        double  distanceFromOrigin;
        double smallestDistance = Math.sqrt((Math.pow(this.xCordinateLog.get(0) - originX, 2)) + (Math.pow(this.yCordinateLog.get(0) - originY, 2)));
        // Loop to get shortest coordinates with the shortest distance from the origin.
        for(int i = 0; i < this.xCordinateLog.size(); i++){
            xCoordinateSelected = this.xCordinateLog.get(i);
            yCoordinateSelected = this.yCordinateLog.get(i);
            distanceFromOrigin = Math.sqrt((Math.pow(xCoordinateSelected - originX, 2)) + (Math.pow(yCoordinateSelected - originY, 2)));
            if(distanceFromOrigin < smallestDistance){
                smallestDistance = distanceFromOrigin;
                closestX = xCoordinateSelected;
                closestY = yCoordinateSelected;
            }
        }  
        System.out.println("Shortest Distance: (" + closestX + ", " + closestY + ")"); 
    }

    // Returns number of points hit based on location of shot cordinates.
    public int getNumberOfPoints(){
        // Declare data variables.
        int pointsHit = 0;
        int xCordinateSelected;
        int yCordinateSelected;
        // Check if both data vector sizes match.
        if(this.xCordinateLog.size() != this.yCordinateLog.size()){
            System.out.println("ERROR: data vector sizes do not match.");
        }
        // If data vector sizes match do this.
        else{
            for (int i = 0; i < this.xCordinateLog.size(); i++) {
                // Declare variables for xy-coordinates.
                int sectorRadiusTested;
                int pointsToAdd = 0;
    
                // Get current index coordinate pair.
                xCordinateSelected = this.xCordinateLog.get(i);
                yCordinateSelected = this.yCordinateLog.get(i);

                // Determine the sector based on the condition
                if ((Math.pow(xCordinateSelected - 500, 2) + Math.pow(yCordinateSelected - 400, 2)) <= Math.pow(25, 2)) {
                    sectorRadiusTested = 25;
                    pointsToAdd = 10;
                } else if ((Math.pow(xCordinateSelected - 500, 2) + Math.pow(yCordinateSelected - 400, 2)) <= Math.pow(90, 2)) {
                    sectorRadiusTested = 90;
                    pointsToAdd = 5;
                } else if ((Math.pow(xCordinateSelected - 500, 2) + Math.pow(yCordinateSelected - 400, 2)) <= Math.pow(175, 2)) {
                    sectorRadiusTested = 175;
                    pointsToAdd = 4;
                } else if ((Math.pow(xCordinateSelected - 500, 2) + Math.pow(yCordinateSelected - 400, 2)) <= Math.pow(275, 2)) {
                    sectorRadiusTested = 275;
                    pointsToAdd = 2;
                } else if ((Math.pow(xCordinateSelected - 500, 2) + Math.pow(yCordinateSelected - 400, 2)) <= Math.pow(345, 2)) {
                    sectorRadiusTested = 345;
                    pointsToAdd = 1;
                }

                // Add points based on the sector
                pointsHit += pointsToAdd;
            } 
        }
        return pointsHit;
    }
}
