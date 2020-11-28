package ticTacToe;

public class Player {
    private char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return mark == player.mark;
    }

    @Override
    public int hashCode() {
        return mark;
    }
}
