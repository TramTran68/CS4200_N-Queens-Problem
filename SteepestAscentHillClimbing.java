public class SteepestAscentHillClimbing {
    private static int cost;
    public static boolean solve(int[] board) {
        int n = board.length;
        cost = 0;

        while (true) {
            int currentConflicts = BoardUtils.countConflicts(board);
            if (currentConflicts == 0) {
                System.out.println("Solution found!");
                System.out.println("Final board:");
                BoardUtils.printBoard(board);
                System.out.println("Total Cost (Moves): " + cost);
                return true;
            }

            int[] bestMove = board.clone();
            int minConflicts = currentConflicts;

            for (int col = 0; col < n; col++) {
                int originalRow = board[col];
                for (int row = 0; row < n; row++) {
                    if (row == originalRow) continue;

                    board[col] = row;
                    int newConflicts = BoardUtils.countConflicts(board);
                    if (newConflicts < minConflicts) {
                        minConflicts = newConflicts;
                        bestMove = board.clone();
                    }
                }
                board[col] = originalRow; // Reset the column
            }

            if (minConflicts >= currentConflicts) {
                System.out.println("Stuck at local optimum. No solution found.");
                System.out.println("Final board:");
                BoardUtils.printBoard(board);
                return false;
            }

            board = bestMove;
            cost++;
        }
    }

    public static int getCost() {
        return cost;
    }
}
