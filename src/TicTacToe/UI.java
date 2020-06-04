package TicTacToe;

public class UI extends TicTacToe {

    public static void initGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
        printGameBoard();
    }

    static void printGameBoard() {
        System.out.print("  ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print("|" + gameBoard[i][j] + "|");
            }
            System.out.println();
        }
    }
}
