# CS4200 NQueens Problem Solver

## **Project Description**
The N-Queens Problem Solver is a Java-based implementation designed to solve the classic N-Queens problem using two local search algorithms—**Steepest-Ascent Hill Climbing** and **Min-Conflicts**. The goal is to place N queens on an N×N chessboard such that no two queens threaten each other. The solver offers users the option to input custom or random configurations and solve the problem with both algorithms, allowing for comparison of their performance.

---

## **Approach**
1. **Algorithms**:
   - **Steepest-Ascent Hill Climbing**: This algorithm iteratively minimizes conflicts by selecting the next configuration with the fewest conflicts, moving towards a solution.
   - **Min-Conflicts**: This heuristic-based algorithm applies the min-conflicts strategy to select moves that reduce the number of conflicts, aiming to resolve the problem more efficiently.

2. **Features**:
   - The program supports both custom and random initial board configurations.
   - Users can choose between the two algorithms to solve the problem and compare their results.
   - The solution is displayed step-by-step, showing the progress of the algorithm as it finds a solution.

---

## **How to Run the Code**
1. Clone or download the repository containing the project files.
2. Compile all `.java` files using your preferred Java IDE.
3. Run the main program `NQueensSolver.java`.
4. Follow the on-screen prompts.

## **How to Test**
1. Run the program with different board sizes (N = 4, 8, 16) and observe the performance of both algorithms.
2. Test with randomly generated boards to evaluate the effectiveness of each algorithm.
3. Compare the **Success Rate**, **Average Search Cost**, and **Average Time** for both algorithms.

---

## **File Structure**
- **BoardUtils.java**: Contains utility methods for board configuration and conflict calculations.
- **SteepestAscentHillClimbing.java**: Implements the Steepest-Ascent Hill Climbing algorithm.
- **MinConflictsAlgorithm.java**: Implements the Min-Conflicts algorithm.
- **NQueensSolver.java**: The main driver class for solving the N-Queens problem using either of the two algorithms.
