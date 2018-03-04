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
                sendParameters(process, p);
            }
            
            list.add(p);
        }
    }

    private void sendParameters(Process p, List<Point> ptList) throws Exception {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
        
        for(Point p : ptList) {
            pw.println(p.getLatVal() + "," + p.getLongVal()); //println to x,y pts
        }
        
        pw.flush();
    }

    // private void idkYet(Process p) throws Exception {
        
    //     p.waitFor();
    //     BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    //     String line = br.readLine();
        
    //     while (line != null) {
    //       System.out.println(line);
    //       line = br.readLine();
    //     }
    // }
    
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
