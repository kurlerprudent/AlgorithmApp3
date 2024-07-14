import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class City {
int id;
int x, y;

City(int id, int x, int y) {
    this.id = id;
    this.x = x;
    this.y = y;
}
}

class TravellingSalesmanProblem {
private ArrayList<City> cities;
private int numCities;

public TravellingSalesmanProblem() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of cities: ");
    numCities = scanner.nextInt();
    cities = new ArrayList<>();

    System.out.println("Enter the coordinates of the cities (id x y):");
    for (int i = 0; i < numCities; i++) {
        int id = i;
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        cities.add(new City(id, x, y));
    }
}

public void findApproximateTour() {
    // Sort the cities by distance from the first city
    Collections.sort(cities, Comparator.comparingDouble(city -> calculateDistance(cities.get(0), city)));

    ArrayList<City> tour = new ArrayList<>();
    boolean[] visited = new boolean[numCities];

    // Add the first city to the tour
    tour.add(cities.get(0));
    visited[0] = true;

    // Add the remaining cities to the tour
    for (int i = 1; i < numCities; i++) {
        int nearestCity = -1;
        double minDistance = Double.MAX_VALUE;
        for (City city : cities) {
            if (!visited[city.id]) {
                double distance = calculateDistance(tour.get(tour.size() - 1), city);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestCity = city.id;
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