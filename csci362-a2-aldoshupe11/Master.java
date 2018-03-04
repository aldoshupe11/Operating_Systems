import java.io.*;
import java.util.*;

public class Master {
    
    public static void main(String args[]) throws Exception {
        new Master().go();
    }

    private void go() throws Exception {
        System.out.println();
        List<Point> list = getPoints(count);
        int pnts = Math.sqrt(list.size());
        
        //find out how many process to create using Math.sqrt and % on the amount of random items
        if(list.size() % pnts != 0) {
            pnts += 1;
        } 
        
        
        //creating processes
        for (int i = 0; i < pnts; i++) {
            
            System.out.printf("Starting process %d ...%n",i);
            Process process = new ProcessBuilder("java", "Worker").start();
            
            for(Point p : list) {
                sendParameters(process, list);
                list.add(p);
            }
        }
    }

    private void sendParameters(Process p, List<Point> ptList) throws Exception {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
        
        for(Point pt : ptList) {
            pw.println(pt.getLatVal() + "," + pt.getLongVal()); //println to x,y pts
        }
        
        pw.flush();
    }

    private Point reduce(List<Point> pointList) {
        
        int pointScore = Integer.MAX_VALUE;
        
        for(Point p : pointList) {
            if((Math.abs(p.getLatVal() - refPoint.getLatVal()) + Math.abs(p.getLongVal() - refPoint.getLongVal()) < pointScore)) {
                return p;
            } else {
                continue;
            }
        }
    }
    
    private List<Point> getPoints(int count) {
        List<Point> pntList = new ArrayList();
        Random rand = new Random();
        int numberOfPoints = rand.nextInt(2000) + 1;
        //System.out.println(numberOfPoints);
        for(int i = 0; i < numberOfPoints; i++) {
            pntList.add(new Point(rand.nextInt(20), rand.nextInt(20)));
            count += 1;
        }
        
        return pntList;
    }
    
    public Point refPoint = new Point(10, 10);
    public int count = 0;
}
