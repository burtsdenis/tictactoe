package TicTacToe;
import org.jetbrains.annotations.NotNull;

public class TicTacToe {
    static int turnNumber = 0;
    String[][] gamingBoard;

    public TicTacToe(int n) {
        gamingBoard = new String[n][n];
    }

    public void initializeGame(Player player1, Player player2) {
        for (int i = 0; i < gamingBoard.length; i++) {
            for (int j = 0; j < gamingBoard.length; j++) {
                gamingBoard[i][j] = "-";
            }
        }
        printGameBoard();
    }

    public void printGameBoard() {
        for (int i = 0; i < gamingBoard.length; i++) {
            for (int j = 0; j < gamingBoard.length; j++) {
                System.out.print(gamingBoard[i][j]);
            }
            System.out.println();
        }
    }

    public boolean turnAllowed(int x, int y) {
        if (gamingBoard[x][y].equals("-")) {
            return true;
        } else {
            System.out.println("Choose another field!");
            return false;
        }
    }

    public boolean checkInput(int x, int y) {
        try {
            if (x <= gamingBoard.length - 1 && y <= gamingBoard.length - 1) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Error: " + e);

        }
        System.out.println("Your input is incorrect, values must be between 0 and 2");
        return false;
    }

    public boolean makeATurn(int x, int y, @NotNull Player player) {
        gamingBoard[x][y] = player.playingMark;
        printGameBoard();
        boolean winner = false;

        for (int i = 0; i < gamingBoard.length; i++) {
            if (!gamingBoard[x][i].equals(player.playingMark))
                break;
            if (i == gamingBoard.length - 1) {
                winner = true;
            }
        }

        for (int i = 0; i < gamingBoard.length; i++) {
            if (!gamingBoard[i][y].equals(player.playingMark))
                break;
            if (i == gamingBoard.length - 1) {
                winner = true;
            }
        }

        if (x == y) {
            for (int i = 0; i < gamingBoard.length; i++) {
                if (!gamingBoard[i][i].equals(player.playingMark))
                    break;
                if (i == gamingBoard.length - 1) {
                    winner = true;
                }
            }
        }

        if (x + y == gamingBoard.length - 1) {
            for (int i = 0; i < gamingBoard.length; i++) {
                if (!gamingBoard[i][(gamingBoard.length - 1) - i].equals(player.playingMark))
                    break;
                if (i == gamingBoard.length - 1) {
                    winner = true;
                }
            }
        }
        return winner;
    }
}