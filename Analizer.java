//TODO: finish getNumberOfPoints() function.
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

                //Tests to determine where within the circle they land for points. 
                //Center of circle (500, 400) -> shifted xy-coordinates, and using euqation of a circle (x - 500)^2 + (y - 400)^2 = r^2
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
                                //Testa for 1 point block.
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
