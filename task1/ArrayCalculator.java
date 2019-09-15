import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class ArrayCalculator {
    private final ArrayList<Integer> array;
    private int size;

    public ArrayCalculator(ArrayList<Integer> array) {
        this.array = array;
        size = array.size();
        sortArray();
    }

    private int calculateSum() {
        int sum = 0;
        for(int i: array) {
            sum +=i;
        }
        return sum;
    }

    private void sortArray() {
        array.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) return 0;
                if (o1 > o2) return 1;
                return -1;
            }
        });
    }

    public double calculatePercentile(int p) {
        double  index = ((double) p / 100) * ((double) size - 1.0) + 1.0;

        int lowNum = array.get((int) Math.floor(index)-1);
        int highNum = array.get((int) Math.ceil(index)-1);

        double ans = lowNum + (highNum-lowNum) * ((double) index % 1);

        return ans;
    }

    public double calculateAvg() {
        return (double) calculateSum() / size;
    }
}
