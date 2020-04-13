package TicTacToe;

public class Player {
    String name;
    String playingMark;
    static int playersCount = 0;

    public Player(String name, String playingMark) {
        playersCount++;
        this.name = name;
        this.playingMark = playingMark;
    }
}