public class Point {
    
    //value driven constructor
    public Point (int latV, int longV){
        this.latVal = latV;
        this.longVal = longV;
    }
    
    public Point(){} //empty constructor
    
    public int getLongVal(){ return longVal; }
    
    public int getLatVal(){ return latVal; }
    
    public void setLongVal (int longV){ this.longVal = longV; }
    
    public void setLatVal (int latV){ this.latVal = latV; } 
    
    private int latVal;
    private int longVal;
    
}
