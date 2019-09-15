import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        FileReader fl = new FileReader();

        //get file contents
        ArrayList<Integer> fileArray = fl.readFile(args[0]);

        //create new calc instance
        ArrayCalculator arrayCalculator = new ArrayCalculator(fileArray);

        System.out.println(String.format(Locale.ROOT, "%.2f", arrayCalculator.calculatePercentile(90)));
        System.out.println(String.format(Locale.ROOT, "%.2f", arrayCalculator.calculatePercentile(50)));
        System.out.println(String.format(Locale.ROOT, "%.2f", arrayCalculator.calculatePercentile(100)));
        System.out.println(String.format(Locale.ROOT, "%.2f", arrayCalculator.calculatePercentile(0)));
        System.out.println(String.format(Locale.ROOT, "%.2f", arrayCalculator.calculateAvg()));

    }




}
