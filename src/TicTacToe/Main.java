package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = -1;
        int y = -1;

        System.out.print("Enter name for player №" + Player.playersCount + ": ");
        Player player1 = new Player(reader.readLine(), "X");
        System.out.print("Enter name for player №" + Player.playersCount + ": ");
        Player player2 = new Player(reader.readLine(), "O");

        TicTacToe game1 = new TicTacToe(3);
        game1.initializeGame(player1, player2);

        while (true) {
            try {
                if (x < 0) {
                    System.out.print("Enter x: ");
                    x = Integer.parseInt(reader.readLine());
                }
                if (y < 0) {
                    System.out.print("Enter y: ");
                    y = Integer.parseInt(reader.readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Your input is incorrect, value must Integer!");
                continue;
            }

            if (!game1.checkInput(x, y)) continue;
            if (!game1.turnAllowed(x, y))  { x = -1; y = -1; continue; }

            TicTacToe.turnNumber++;
            if (TicTacToe.turnNumber % 2 != 0) {
                if (game1.makeATurn(x, y, player1)) {
                    System.out.println(player1.name + " wins!");
                    break;
                }
            } else if (TicTacToe.turnNumber % 2 == 0) {
                if (game1.makeATurn(x, y, player2)) {
                    System.out.println(player2.name + " wins!");
                    break;
                }
            }
            x = -1;
            y = -1;
        }
    }

}

