package ticTacToe;

public class Square {
    private SquareState squareState;

    public Square() {
        squareState = SquareState.UNMARKED;
    }

    public SquareState getSquareState() {
        return squareState;
    }

    public void setSquareState(SquareState squareState) {
        this.squareState = squareState;
    }
}
