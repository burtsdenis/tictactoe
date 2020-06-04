package TicTacToe;

import static TicTacToe.Main.scan;
import static TicTacToe.UI.initGameBoard;
import static TicTacToe.UI.printGameBoard;


public class TicTacToe {
    private static int turnNumber = 0;
    public static char EMPTY = ' ';
    public static int BOARD_SIZE = 3;
    public static String GAME_MODE;
    public static char[][] gameBoard = new char[BOARD_SIZE][BOARD_SIZE];

    public static void initializeGame() {
        System.out.println("Choose game mode:\n1. Player vs Player\n2. Player vs Computer (will be in next versions)\n");
        System.out.print("Game mode (1/2): ");
        GAME_MODE = scan.next();

        switch (GAME_MODE) {
            case "1":
                System.out.print("Enter name for player №" + Player.playersCount + ": ");
                Player player1 = new Player(scan.next(), 'X');
                System.out.print("Enter name for player №" + Player.playersCount + ": ");
                Player player2 = new Player(scan.next(), 'O');
                initGameBoard();
                pvpGame(player1, player2);
                break;
            case "2":
                break;
//            System.out.print("Enter your name: " + Player.playersCount + ": ");
//            Player player = new Player(scan.next(), 'X');
//            initGameBoard();
//            pvcGame(player);
        }


    }

    static void pvpGame(Player player1, Player player2) {
        while (true) {
            System.out.println("Turn number is: " + (turnNumber + 1) + "\nIt's " + (turnNumber % 2 == 0 ? player1.name : player2.name) + "'s turn!");
            printGameBoard();
            System.out.print("Enter the x and y divided by space: ");
            int x;
            int y;
            try {

                x = Integer.parseInt(scan.next());
                y = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.println("Your input is incorrect, both values must be integer!");
                continue;
            }
            if (checkInput(x, y) && turnAllowed(x, y)) {
                if (turnNumber % 2 == 0) {
                    makeTurn(x, y, player1);
                } else {
                    makeTurn(x, y, player2);
                }
                turnNumber++;
            }
        }
    }

    static void pvcGame(Player player) {

    }

    static void makeTurn(int x, int y, Player player) {
        gameBoard[x][y] = player.playingMark;

        if (turnNumber > BOARD_SIZE) {
            if (checkWinner(x, y, player)) {
                printGameBoard();
                System.out.println("Player " + player.name + " wins!");
                System.exit(0);
            }
        }

        if (turnNumber > (BOARD_SIZE * BOARD_SIZE - 1)) {
            if (checkDraw()) {
                System.out.println("Draw!");
                System.exit(0);
            }
        }
    }

    static boolean turnAllowed(int x, int y) {
        if (gameBoard[x][y] != EMPTY) {
            System.out.println("This field is already taken.\nChoose another field!");
            return false;
        } else {
            return true;
        }
    }

    static boolean checkInput(int x, int y) {
        if (x <= BOARD_SIZE - 1 && y <= BOARD_SIZE - 1) {
            return true;
        } else {
            System.out.println("Your input is incorrect, values must be between 0 and " + (BOARD_SIZE - 1));
            return false;
        }
    }

    static boolean checkWinner(int x, int y, Player player) {

        boolean horizontal = true;
        boolean vertical = true;
        boolean mainDiagonal = true;
        boolean secondaryDiagonal = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (gameBoard[x][i] != player.playingMark) {
                vertical = false;
            }

            if (gameBoard[i][y] != player.playingMark) {
                horizontal = false;
            }

            if (gameBoard[i][i] != player.playingMark) {
                mainDiagonal = false;
            }

            if (gameBoard[i][(BOARD_SIZE - 1) - i] != player.playingMark) {
                secondaryDiagonal = false;
            }
        }
        return horizontal || vertical || mainDiagonal || secondaryDiagonal;
    }



    static boolean checkDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (gameBoard[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

}
