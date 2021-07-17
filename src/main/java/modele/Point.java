package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point implements Comparable<Point> {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        Point zero = new Point(0, 0);
        double thisDist = this.dist(zero);
        double oDist = o.dist(zero);
        if (thisDist > oDist) return 1;
        if (thisDist < oDist) return -1;
        return 0;
    }

    public static double dist(Point p1, Point p2) {
        return sqrt(pow((p2.x - p1.x), 2) + pow((p2.y - p1.y), 2));
    }

    public double dist(Point p1) {
        return sqrt(pow((this.x - p1.x), 2) + pow((this.y - p1.y), 2));
    }


    public static Point maxDistPoint(Point[] arr) {
        double max = 0;
        int maxDistPointIndex = 0;
        Point O = new Point(0, 0);
        for (int i = 0; i < arr.length; i++) {
            double dist = dist(O, arr[i]);
            if (dist > max) maxDistPointIndex = i;
        }
        return arr[maxDistPointIndex];
    }

    public static ArrayList<Point> maxDistPoints(Point[] arr) {
        double max = 0;
        Point O = new Point(0, 0);
        ArrayList<Point> maxDistPoints = new ArrayList<>();
        Point maxDistPoint = maxDistPoint(arr);
        double dist = dist(O, maxDistPoint);

        for (int i = 0; i < arr.length; i++) {
            if (dist(O, arr[i]) == dist) {
                maxDistPoints.add(arr[i]);
            }

        }
        return maxDistPoints;
    }

    public static Point centerMass(Point[] arr) {
        if (arr.length == 0) return null;
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < arr.length; i++) {
            sumX += arr[i].getX();
            sumY += arr[i].getY();
        }
        int x = (int) (sumX / arr.length);
        int y = (int) (sumY / arr.length);

        return new Point(x, y);
    }

    public static double setDiam(Point[] arr) {
        double max = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double dist = arr[i].dist(arr[j]);
                if (dist > max)
                    max = dist;
            }
        }
        return max;
    }

    public static void sort(Point[] arr) {
        Arrays.sort(arr);
    }

    public static double perimeter(Point other1, Point other2, Point other3) {
        double perimeter = 0;
        perimeter += dist(other1, other2) + dist(other2, other3) + dist(other3, other1);
        return perimeter;
    }

    public static double maxPerimeter(Point[] arr) {
        double max = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    double perimeter = perimeter(arr[i], arr[j], arr[k]);
                    if (perimeter > max)
                        max = perimeter;
                }
            }


        }

        return max;
    }

    public double Area(Point other1, Point other2){

        return Math.abs((this.getX()-other2.getX())*(other1.getY()-this.getY())-
                (this.getX()-other1.getX())*(other2.getY()-this.getY()))*0.5;
    }

    public static double maxArea(Point[] arr) {
        double max = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    double area = arr[i].Area(arr[j],arr[k]);
                    if (area > max)
                        max = area;
                }
            }


        }

        return max;
    }


}
