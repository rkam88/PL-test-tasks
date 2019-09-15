import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<Double> readFile(String fileName) {
        File f = new File(fileName);

        ArrayList<Double> result = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                StringBuilder number = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if ((symbol >= '0' && symbol <= '9') || symbol == '.' || symbol == '-') {
                        number.append(symbol);
                    }
                }
                //add a new point to the resulting array
                result.add(Double.parseDouble(number.toString()));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
