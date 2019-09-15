import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<Point> readFile(String fileName) {
        File f = new File(fileName);

        ArrayList<Point> result = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                // an array with size two for the two coordinates in a line
                StringBuilder number[] = new StringBuilder[2];
                for (int i = 0; i < number.length; i++) {
                    number[i] = new StringBuilder("");
                }

                int currentCoordinate = 0;

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if ((symbol >= '0' && symbol <= '9') || symbol == '.' || symbol == '-') {
                        number[currentCoordinate].append(symbol);
                    } else if (symbol == ' ') {
                        currentCoordinate = 1;
                    }
                }
                //add a new point to the resulting array
                result.add(new Point(Double.parseDouble(number[0].toString()), Double.parseDouble(number[1].toString())));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
