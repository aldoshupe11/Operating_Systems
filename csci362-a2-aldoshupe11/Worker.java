import java.util.*;

public class Worker {
    
    public static void main(String args[]) throws Exception {
        new Worker().go();
    }
    
    private void go() throws Exception {
        Scanner scan = new Scanner(System.in);
        List<Point> pointList = new ArrayList<Point>();
        while(scan.hasNext()) {
            tempPoint = scan.nextLine().split(",");
            pointList.add(new Point(Integer.parseInt(tempPoint[0]), Integer.parseInt(tempPoint[1])));
        }
        
        for(Point p : pointList) {
            if((Math.abs(p.getLatVal() - refPoint.getLatVal()) + Math.abs(p.getLongVal() - refPoint.getLongVal()) < pointScore)) {
                pointScore = Math.abs(p.getLatVal() - refPoint.getLatVal()) + Math.abs(p.getLongVal() - refPoint.getLongVal());
            } else {
                continue;
            }
        }
        
    }
    
    String[] tempPoint;
    Point refPoint = new Point(10, 10);
    int pointScore = Integer.MAX_VALUE;
}
