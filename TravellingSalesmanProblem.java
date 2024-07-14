import java.util.ArrayList;
import java.util.Scanner;

class City {
int x, y;

City(int x, int y) {
    this.x = x;
    this.y = y;
}
}

class TravellingSalesman {
private ArrayList<City> cities;
private int numCities;

public TravellingSalesman() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of cities: ");
    numCities = scanner.nextInt();
    cities = new ArrayList<>();

    System.out.println("Enter the coordinates of the cities (x y):");
    for (int i = 0; i < numCities; i++) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        cities.add(new City(x, y));
    }
}

public void findApproximateTour() {
    ArrayList<City> tour = new ArrayList<>();
    boolean[] visited = new boolean[numCities];

    // Start from the first city
    tour.add(cities.get(0));
    visited[0] = true;

    // Find the nearest unvisited city and add it to the tour
    for (int i = 0; i < numCities - 1; i++) {
        int nearestCity = -1;
        double minDistance = Double.MAX_VALUE;
        for (int j = 0; j < numCities; j++) {
            if (!visited[j]) {
                double distance = calculateDistance(tour.get(i), cities.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestCity = j;
                }
            }
        }
        tour.add(cities.get(nearestCity));
        visited[nearestCity] = true;
    }

    // Add the first city to complete the tour
    tour.add(cities.get(0));

    System.out.println("The approximate tour is:");
    for (City city : tour) {
        System.out.println("(" + city.x + ", " + city.y + ")");
    }
}

private double calculateDistance(City a, City b) {
    return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
}
}