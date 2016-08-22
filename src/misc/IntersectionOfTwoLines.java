package misc;

/**
 * Created by nikhandelwal on 8/22/2016.
 */
public class IntersectionOfTwoLines {

    public static class Point {

        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;

        }
    }

    public static class Line {

        Point start, end;

        double yIntercept;
        double slope;


        public Line(int x1, int y1, int x2, int y2) {
            start = new Point(x1, y1);
            end = new Point(x2, y2);
            slope = getSlope(start, end);
            yIntercept = getYIntecept(start);
        }

        public Line(Point p1, Point p2) {
            start = p1;
            end = p2;
            slope = getSlope(start, end);
            yIntercept = getYIntecept(start);
        }

        private double getSlope(Point start, Point end) {
            double slope = (start.x - end.x) / (start.y - end.y);
            return slope;
        }

        private double getYIntecept(Point start) {
            double yIntercept = this.slope * start.x + start.y;
            return yIntercept;
        }
    }

    public static Point intersection(Line l1, Line l2) {

        if (l1.slope == l2.slope) {

            if (inBetween(l1.start, l2.start, l1.end))
                return l2.start;
            else
                return null;
        } else {

            double x = (l1.yIntercept - l2.yIntercept) / (l2.slope - l1.slope);
            double y = l1.slope * x + l1.yIntercept;
            Point intersection = new Point(x, y);
            if (inBetween(l1.start, intersection, l1.end) && inBetween(l2.start, intersection, l2.end))
                return intersection;
            else
                return null;
        }

    }

    private static boolean inBetween(Point start, Point middle, Point end) {


        if ((start.x < middle.x && end.x > middle.x))
            return true;

        return false;
    }

    public static void main(String[] args) {

        Point start1 = new Point(-5, -5);
        Point end1 = new Point(0, 0);
        Point start2 = new Point(-1, -1);
        Point end2 = new Point(10, 10);

        Line l1 = new Line(start1, end1);
        Line l2 = new Line(start2, end2);

        Point intersection = intersection(l1, l2);

        if (intersection != null) {
            System.out.println("intersection is  x: " + intersection.x + " y: " + intersection.y);
        } else
            System.out.println("Do not intersect");

    }


}
