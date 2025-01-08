import java.util.ArrayList;

public class MinConflictsAlgorithm {
    private static int cost; // Number of moves
    public static boolean solve(int[] board, int maxSteps) {
        int n = board.length;
        cost = 0;

        for (int step = 0; step < maxSteps; step++) {
            int currentConflicts = BoardUtils.countConflicts(board);
            if (currentConflicts == 0) {
                System.out.println("Solution found!");
                System.out.println("Final board:");
                BoardUtils.printBoard(board);
                System.out.println("Total Cost (Moves): " + cost);
                return true;
            }

            ArrayList<Integer> conflictedColumns = BoardUtils.getConflictedColumns(board);
            int col = conflictedColumns.get(BoardUtils.getRandom().nextInt(conflictedColumns.size()));

            int bestRow = board[col];
            int minConflicts = currentConflicts;

            for (int row = 0; row < n; row++) {
                if (row == board[col]) continue;

                board[col] = row;
                int newConflicts = BoardUtils.countConflicts(board);
                if (newConflicts < minConflicts) {
                    minConflicts = newConflicts;
                    bestRow = row;
                }
            }

            board[col] = bestRow;
            cost++;
        }

        System.out.println("Failed to find a solution within the maximum number of steps.");
        System.out.println("Final board:");
        BoardUtils.printBoard(board);
        return false;
    }

    public static int getCost() {
        return cost;
    }
}
