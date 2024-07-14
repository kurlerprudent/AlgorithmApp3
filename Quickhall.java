import java.util.ArrayList;
import java.util.Scanner;

class Point {
int x, y;

Point(int x, int y) {
    this.x = x;
    this.y = y;
}
}

class Quickhull {
private ArrayList<Point> points;
private ArrayList<Point> convexHull;

public Quickhull() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of points: ");
    int n = scanner.nextInt();
    points = new ArrayList<>();
    System.out.println("Enter the points (x y):");
    for (int i = 0; i < n; i++) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        points.add(new Point(x, y));
    }
    convexHull = new ArrayList<>();
}

public void findConvexHull() {
    if (points.size() < 3) {
        convexHull = points;
        return;
    }

    Point leftmost = points.get(0);
    Point rightmost = points.get(0);
    for (Point p : points) {
        if (p.x < leftmost.x) {
            leftmost = p;
        }
        if (p.x > rightmost.x) {
            rightmost = p;
        }
    }

    convexHull.add(leftmost);
    quickHull(points, leftmost, rightmost, true);
    convexHull.add(rightmost);
    quickHull(points, rightmost, leftmost, false);

    System.out.println("The convex hull is:");
    for (Point p : convexHull) {
        System.out.println("(" + p.x + ", " + p.y + ")");
    }
}

private void quickHull(ArrayList<Point> points, Point a, Point b, boolean leftSide) {
    int index = -1;
    int maxDistance = 0;

    for (int i = 0; i < points.size(); i++) {
        Point p = points.get(i);
        int orient = orientation(a, b, p);
        if ((orient == 1 && leftSide) || (orient == -1 && !leftSide)) {
            int distance = distance(a, b, p);
            if (distance > maxDistance) {
                maxDistance = distance;
                index = i;
            }
        }
    }

    if (index == -1) {
        convexHull.add(a);
        return;
    }

    Point p = points.get(index);
    convexHull.add(p);
    quickHull(points, a, p, true);
    quickHull(points, p, b, false);
}

private int orientation(Point a, Point b, Point c) {
    int val = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
    if (val == 0) {
        return 0;
    }
    return (val > 0) ? 1 : -1;
}

private int distance(Point a, Point b, Point c) {
    return Math.abs((b.y - a.y) * c.x - (b.x - a.x) * c.y + b.x * a.y - b.y * a.x);
}
}