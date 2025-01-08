import java.util.Scanner;

public class NQueensSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter the size of the board (N): ");
            int n = scanner.nextInt();

            System.out.println("Choose configuration option:");
            System.out.println("1. Generate a random configuration");
            System.out.println("2. Enter initial configuration manually");
            int choice = scanner.nextInt();

            int[] board;
            if (choice == 1) {
                board = BoardUtils.generateRandomBoard(n);
            } else if (choice == 2) {
                board = new int[n];
                System.out.println("Enter the initial configuration (row positions for each column, 0-indexed, separated by spaces):");
                for (int i = 0; i < n; i++) {
                    board[i] = scanner.nextInt();
                }
            } else {
                System.out.println("Invalid choice. Exiting...");
                scanner.close();
                return;
            }

            System.out.println("\nInitial Board:");
            BoardUtils.printBoard(board);

            System.out.println("\nRunning Steepest-Ascent Hill Climbing...");
            SteepestAscentHillClimbing.solve(board.clone());

            System.out.println("\nRunning Min-Conflicts Algorithm...");
            MinConflictsAlgorithm.solve(board.clone(), 100000);

            System.out.println("\nDo you want to run another instance? (Y/N): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                running = false;
            }
        }

        // Function to run 100 instances of 8x8 board and output the percentage of solved problems, average cost, run time for each algorithm
        // Uncomment these line to run analysis, change n (size of board) and numInstances if needed
        // System.out.println("\nRunning Analysis on 100 Instances...");
        runAnalysis(8, 100);

        scanner.close();
    }

    public static void runAnalysis(int n, int numInstances) {
        int hillClimbingSolved = 0;
        int minConflictsSolved = 0;

        long totalHillClimbingCost = 0;
        long totalMinConflictsCost = 0;

        long hillClimbingTime = 0;
        long minConflictsTime = 0;

        for (int i = 0; i < numInstances; i++) {
            int[] board = BoardUtils.generateRandomBoard(n);

            // Steepest-Ascent Hill Climbing
            int[] boardCopy = board.clone();
            long startTime = System.nanoTime();
            System.out.println("\nRunning Steepest-Ascent Hill Climbing...");
            boolean hillClimbingResult = SteepestAscentHillClimbing.solve(boardCopy);
            long endTime = System.nanoTime();

            if (hillClimbingResult) {
                hillClimbingSolved++;
                totalHillClimbingCost += SteepestAscentHillClimbing.getCost();
            }
            hillClimbingTime += (endTime - startTime);

            // Min-Conflicts Algorithm
            boardCopy = board.clone();
            startTime = System.nanoTime();
            System.out.println("\nRunning Min-Conflicts Algorithm...");
            boolean minConflictsResult = MinConflictsAlgorithm.solve(boardCopy, 100000);
            endTime = System.nanoTime();

            if (minConflictsResult) {
                minConflictsSolved++;
                totalMinConflictsCost += MinConflictsAlgorithm.getCost();
            }
            minConflictsTime += (endTime - startTime);
        }

        System.out.println("\nAnalysis Results:");
        System.out.printf("Hill Climbing Success Rate: %.2f%%\n", (hillClimbingSolved / (double) numInstances) * 100);
        System.out.printf("Hill Climbing Average Cost: %.2f\n", (hillClimbingSolved > 0) ? (totalHillClimbingCost / (double) hillClimbingSolved) : 0);
        System.out.printf("Hill Climbing Average Time: %.2f ms\n", hillClimbingTime / (double) numInstances / 1_000_000);

        System.out.printf("\nMin-Conflicts Success Rate: %.2f%%\n", (minConflictsSolved / (double) numInstances) * 100);
        System.out.printf("Min-Conflicts Average Cost: %.2f\n", (minConflictsSolved > 0) ? (totalMinConflictsCost / (double) minConflictsSolved) : 0);
        System.out.printf("Min-Conflicts Average Time: %.2f ms\n", minConflictsTime / (double) numInstances / 1_000_000);
    }
}
