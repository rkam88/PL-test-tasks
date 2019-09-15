public class Point {
    private double xCoordinate, yCoordinate;
    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getX() {
        return xCoordinate;
    }

    public double getY() {
        return yCoordinate;
    }

    //TODO del this method
    public void printPoint() {
        System.out.println(xCoordinate + " " + yCoordinate);
    }
}
