//Imported packages.
import java.util.Vector;

//Analizer class definition.
public class Analizer{
    //Class data members.
    private int xCordinate;
    private int yCordinate;
    //Class data vector members.
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

    //Prints the most accurate shots coordinates.
    public void printMostAccurateCoordinateInSet(){
        int xCoordinateSelected;
        int yCoordinateSelected;
        int originX = 500;
        int originY = 400;
        int closestX, closestY;
        int  distanceFromOrigin;
        int smallestDistance = Math.sqrt((Math.pow(xCoordinateSelected - originX, 2)) + (Math.pow(yCoordinateSelected - originY, 2)));;
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
                //Declare variables for xy-coordinates. 
                int sectorRadiusTested1;
                int sectorRadiusTested2;
                //Get current index cordinate pair.
                xCordinateSelected = this.xCordinateLog.get(i);
                yCordinateSelected = this.yCordinateLog.get(i);

                //Tests to determine where the shots landed within the target, using their coordinate logs.
                //Center of target is at (500, 400) -> so xy-coordinates are shifted, using equation of a circle with center shifted (x - 500)^2 + (y - 400)^2 = r^2
                //Test 10 point block.
                sectorRadiusTested1 = 25;
                if(((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2))) <= (Math.pow(sectorRadiusTested1, 2))){
                    pointsHit += 10;
                } else{
                    //Test for 5 point block.
                    sectorRadiusTested2 = 90;
                    if((((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2))) <= (Math.pow(sectorRadiusTested2, 2))) && (((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2))) > (Math.pow(sectorRadiusTested1, 2)))){
                        pointsHit += 5;
                    } else{
                        //Test for 4 point block.
                        sectorRadiusTested1 = 175;
                        if(((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2)) <= (Math.pow(sectorRadiusTested1, 2))) && ((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2)) > (Math.pow(sectorRadiusTested2, 2)))){
                            pointsHit += 4;
                        } else{
                            //Test for 2 point block.
                            sectorRadiusTested2 = 275;
                            if(((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2)) <= (Math.pow(sectorRadiusTested2, 2))) && ((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2)) > (Math.pow(sectorRadiusTested1, 2)))){
                                pointsHit += 2;
                            } else{
                                //Test for 1 point block.
                                sectorRadiusTested1 = 345;
                                if(((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2)) <= (Math.pow(sectorRadiusTested1, 2))) && ((Math.pow(xCordinateSelected - 500, 2)) + (Math.pow(yCordinateSelected - 400, 2)) > (Math.pow(sectorRadiusTested2, 2)))){
                                    pointsHit += 1;
                                }
                            }
                        }
                    }
                }
            }   
        }
        return pointsHit;
    }
}
