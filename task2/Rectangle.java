import java.util.ArrayList;

public class Rectangle {
    Point[] rectangleCoord = new Point[4];

    double minX, maxX, minY, maxY;

    public Rectangle(ArrayList<Point> coords) {
        for (int i = 0; i < 4; i++) {
            rectangleCoord[i] = new Point(coords.get(i).getX(), coords.get(i).getY());
        }

        minX = coords.get(0).getX();
        maxX = coords.get(0).getX();
        minY = coords.get(0).getY();
        maxX = coords.get(0).getY();

        for (int i = 1; i < coords.size(); i++) {
            if (coords.get(i).getX() < minX) minX = coords.get(i).getX();
            if (coords.get(i).getX() > maxX) maxX = coords.get(i).getX();
            if (coords.get(i).getY() < minY) minY = coords.get(i).getY();
            if (coords.get(i).getY() > maxY) maxY = coords.get(i).getY();
        }

    }

    public int checkPoint(Point pointToCheck) {
        for (Point currentPoint: rectangleCoord) {
            double p1x = pointToCheck.getX();
            double p1y = pointToCheck.getY();
            double p2x = currentPoint.getX();
            double p2y = currentPoint.getY();

            if ((p1x == p2x) && (p1y == p2y)) return 0;
            if ((((p1x == minX) || (p1x == maxX)) && (p1y > minY && p1y < maxY)) ||
                (((p1y == minY) || (p1y == maxY)) && (p1x > minX && p1x < maxX))) return 1;

            if ((p1x > minX) && (p1x < maxX) && (p1y > minY) && (p1y < maxY)) return 2;

        }

        return 3;
    }


}
