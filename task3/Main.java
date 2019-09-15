import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileReader fl = new FileReader();

        //read the file data
        ArrayList<Double>[] visitors = new ArrayList[5];
        for (int i = 1; i <= visitors.length; i++) {
            visitors[i-1] = fl.readFile(args[0]+"Cash"+i+".txt");
        }

        //an array to calculate the total across all queues
        double[] totalVisitors = new double[visitors[0].size()];

        //calculate the total amount of people in the queue for each interval
        for (int i = 0; i < totalVisitors.length; i++) {
            totalVisitors[i] = 0;
            for (ArrayList<Double> v: visitors) {
                totalVisitors[i] += v.get(i);
            }
        }

        Double maxVisitors = 0.0;
        int maxVisitorsIndex = 0;

        //find the max amount of visitors
        for (int i = 0; i < totalVisitors.length; i++) {
            if (totalVisitors[i] > maxVisitors) {
                maxVisitors = totalVisitors[i];
                maxVisitorsIndex = i;
            }
        }

        System.out.println(maxVisitorsIndex + 1);
    }
}
