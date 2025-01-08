import java.util.ArrayList;
import java.util.Random;

public class BoardUtils {
    private static final Random random = new Random();

    public static Random getRandom() {
        return random;
    }

    // Generate a random initial board
    public static int[] generateRandomBoard(int n) {
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = random.nextInt(n);
        }
        return board;
    }

    // Print the board
    public static void printBoard(int[] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[col] == row) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    // Count total number of conflicts on the board
    public static int countConflicts(int[] board) {
        int conflicts = 0;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (board[i] == board[j] || Math.abs(board[i] - board[j]) == Math.abs(i - j)) {
                    conflicts++;
                }
            }
        }
        return conflicts;
    }

    // Get columns with conflicting queens
    public static ArrayList<Integer> getConflictedColumns(int[] board) {
        ArrayList<Integer> conflictedColumns = new ArrayList<>();
        int n = board.length;

        for (int col = 0; col < n; col++) {
            int originalRow = board[col];
            board[col] = -1; // Temporarily remove the queen
            if (countConflicts(board) > 0) {
                conflictedColumns.add(col);
            }
            board[col] = originalRow; // Restore the queen
        }

        return conflictedColumns;
    }
}
