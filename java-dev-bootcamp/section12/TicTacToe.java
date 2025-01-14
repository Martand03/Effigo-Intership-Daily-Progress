package section12;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

        System.out.println("Let's play Tic-Tac-Toe...");
        printBoard(board);
        System.out.println("You need to enter row and column numbers (0, 1, or 2) to place your mark.");
        takeInputs(board);
    }

    static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("\t" + cell);
            }
            System.out.println();
        }
    }

    static void takeInputs(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        boolean isXTurn = true;

        for (int turn = 0; turn < 9; turn++) {
            char currentPlayer = isXTurn ? 'X' : 'O';
            System.out.println("Turn " + currentPlayer + ": ");

            int row, col;
            while (true) {
                System.out.print("Enter row and column (0-2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '_') {
                    break;
                } else {
                    System.out.println("Invalid input! Try again.");
                }
            }

            board[row][col] = currentPlayer;
            printBoard(board);

            if (checkResult(board, currentPlayer)) {
                System.out.println(currentPlayer + " wins!!");
                return; // End the game
            }

            isXTurn = !isXTurn; // Switch turns
        }

        System.out.println("It's a draw!");
    }

    static boolean checkResult(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
