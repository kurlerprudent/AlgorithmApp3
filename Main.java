import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueLooping = true;

        while (continueLooping) {
            System.out.println("Please choose an option(1 - 3)");
            System.out.print("1.Divide & Conquer Algorithm     2.Greedy Algorithm     3.Quit :");
            String choice = scanner.nextLine().toLowerCase();
            
            if (choice.equals("3") || choice.equals("quit")) {
                boolean isCorrect = true;
                while (isCorrect) {
                    System.out.print("Are you sure you want to quit?        1.Yes       2.No");
                String quitOption = scanner.nextLine();
                if (quitOption.equals("1") || quitOption.equals("yes")) {
                    System.out.println("Exiting program.....");
                    isCorrect = false;
                    continueLooping = false;
                }else if (quitOption.equals("2") || quitOption.equals("no")) {
                    break;
                }else {System.out.println("Invalid choice: ");}
                }
                

                
                
            }

            else if (choice.equals("1") || choice.equals("Divide & Conquer Algorithm")) {
                System.out.print("Select a Divide & Conquer Algorithm: ");
                System.out.println("1.Quick Sorting   2.Merge Sort   3.Closest-Pair Problem   4.Strassen’s Matrix Multiplication     5.Quickhull:");
                String divideandConquerOption = scanner.nextLine();

                switch (divideandConquerOption) {
                    case "1":
                        System.out.println("Quick Sorting");
                        QuickSort quickSort = new QuickSort();
                        quickSort.quickSort();
                        break;
                    case "2":
                        System.out.println("Merge Sorting");
                        MergeSort taka = new MergeSort();
                        taka.run();
                        break; 
                    case "3":
                        System.out.println("Closest Pair Problem");
                        ClosestPair closestPair = new ClosestPair();
                        closestPair.findClosestPair();
                        break;
                    case "4":
                        System.out.println("Strassen’s Matrix Multiplication");
                        StrassenMatrixMultiplication sm = new StrassenMatrixMultiplication();
                        sm.multiply();
                        break;
                    case "5":
                        System.out.println("Quickhull");
                        Quickhull quickhull = new Quickhull();
                        quickhull.findConvexHull();
                        break;   
                
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }

            else if (choice.equals("2") || choice.equals("Greedy Algorithm")) {
                System.out.println("Select A Greedy Algorithm Option");
                System.out.print("1.Prim’s Minimum Spanning Tree       2.Traveling Salesman Problem      3.Kruskal’s MST     4.Dijkstra’s Shortest Path     5.Huffman Codes: ");
                String greedyOption = scanner.nextLine();
                switch (greedyOption) {
                    case "1":
                        System.out.println("You selected the Prim’s Minimum Spanning Tree option");
                        TravellingSalesmanProblem prims = new TravellingSalesmanProblem();
                        prims.findApproximateTour();
                        break;
                    case "2":
                        System.out.println("You selected the traveling salesman option");
                        TravellingSalesman travellingSalesman = new TravellingSalesman();
                        travellingSalesman.findApproximateTour();
                        break;
                    case "3":
                        System.out.println("You selected the Kruskal’s MST option");
                        KruskalsMST kruskalsMST = new KruskalsMST();
                        kruskalsMST.findMST();
                        
                        break;
                    case "4":
                        System.out.println("You selected the Dijkstra’s Shortest Path option");
                        DijkstrasShortestPath dijkstrasShortestPath = new DijkstrasShortestPath();
                        dijkstrasShortestPath.findShortestPath(0);
                        break;
                    default:
                        System.out.println("Please enter a valid option: ");
                        break;
                }
            }

            else{
                System.out.println("Please Enter a valid option(An Integer from 1 - 3):");
                continue;
            }
            continue;
        }
        
    }
}