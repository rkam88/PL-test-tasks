import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileReader fl = new FileReader();

        ArrayList<Point> coords1 = fl.readFile(args[0]);
        ArrayList<Point> coords2 = fl.readFile(args[1]);

        Rectangle rectangle = new Rectangle(coords1);

        for (Point pt: coords2) {
            System.out.println(rectangle.checkPoint(pt));
        }



    }
}
