import java.util.Scanner;

public class ClosestPair {
    public void findClosestPair() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();
        double[][] points = new double[n][2];
        System.out.println("Enter the coordinates of the points (x y):");
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        double minDistance = Double.MAX_VALUE;
        int p1 = 0, p2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    p1 = i;
                    p2 = j;
                }
            }
        }

        System.out.println("The closest pair of points is: (" + points[p1][0] + ", " + points[p1][1] + ") and (" + points[p2][0] + ", " + points[p2][1] + ")");
        System.out.println("The distance between them is: " + minDistance);
        
    }
}