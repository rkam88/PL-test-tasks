import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<Integer> readFile(String fileName) {
        File f = new File(fileName);
        ArrayList<Integer> inputArray = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream);

            while (sc.hasNextLine()) {
                inputArray.add(Integer.parseInt(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputArray;
    }
}
