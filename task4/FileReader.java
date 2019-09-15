import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<Event> readFile(String fileName) {
        File f = new File(fileName);

        ArrayList<Event> result = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                // a StringBuilder to form the time
                StringBuilder timeString = new StringBuilder();

                boolean isEntryTimeEmpty = true;
                boolean isExitTimeEmpty = true;
                boolean isMinute=false;
                int entryTime = 0;
                int exitTime = 0;

                //parse each line and create an event for the entry and the exit time at the end
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    boolean isNumber = (symbol >= '0' && symbol <= '9');
                    boolean isDivider = (symbol == ':');

                    if (isNumber) {
                        timeString.append(symbol) ;
                    } else if (isDivider) {
                        if (isEntryTimeEmpty) {
                            entryTime = Integer.parseInt(timeString.toString())*60;
                        } else if (isExitTimeEmpty) {
                            exitTime = Integer.parseInt(timeString.toString())*60;
                        }
                        timeString = new StringBuilder();
                    } else {
                        if (isEntryTimeEmpty) {
                            entryTime += Integer.parseInt(timeString.toString());
                            isEntryTimeEmpty = false;
                        } else if (isExitTimeEmpty){
                            exitTime += Integer.parseInt(timeString.toString());
                            isExitTimeEmpty = false;
                        }
                        timeString = new StringBuilder();
                        if (!isExitTimeEmpty) break;
                    }
                }

                result.add(new Event(entryTime, 1));
                result.add(new Event(exitTime, -1));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
