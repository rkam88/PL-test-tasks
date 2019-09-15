import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        FileReader fl = new FileReader();

        ArrayList<Event> events = fl.readFile(args[0]);

        events.sort(Event::compareTo);

        //create a table with the times and
        ArrayList<Integer> time = new ArrayList<>();
        ArrayList<Integer> customers = new ArrayList<>();

        time.add(events.get(0).getTime());
        customers.add(1);
        int currentIndex = 0;

        for (int i = 1; i < events.size(); i++) {
            Event currentEvent = events.get(i);
            int currentTime = currentEvent.getTime();
            int currentChange = currentEvent.getChange();



            if (currentTime == time.get(currentIndex)) {
                customers.set(currentIndex, customers.get(currentIndex) + currentChange);
            } else {
                time.add(currentTime);
                customers.add(customers.get(currentIndex) + currentChange);
                currentIndex++;
            }

        }

        //find max customers
        int maxCustomers = 0;
        for (Integer i: customers) {
            if (i > maxCustomers) {
                maxCustomers = i;
            }
        }


        ArrayList<Integer> maxCustomerTimes = new ArrayList<>();
        boolean lookingForIntervalStart = true;

        for (int i = 0; i < time.size(); i++) {
            if ((lookingForIntervalStart) && (customers.get(i) == maxCustomers)) {
                maxCustomerTimes.add(time.get(i));
                lookingForIntervalStart = false;
            } else if ((!lookingForIntervalStart) && (customers.get(i) < maxCustomers)) {
                maxCustomerTimes.add(time.get(i));
                lookingForIntervalStart = true;
            }
        }


        for (int i = 0; i < maxCustomerTimes.size(); i +=2) {
            String startTime = formatTime(maxCustomerTimes.get(i));
            String endTime = formatTime(maxCustomerTimes.get(i+1));
            System.out.println(startTime + " " + endTime);
        }

    }

    private static String formatTime(int i) {
        String hourStart = String.valueOf(i/60);
        String minuteStart = String.valueOf(i%60);
        if (minuteStart.equals("0")) {
            minuteStart = "00";
        }
        return hourStart + ":" + minuteStart;
    }

}
