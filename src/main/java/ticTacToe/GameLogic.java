package ticTacToe;

import java.util.ArrayList;

public class GameLogic {
    private Player playerX;
    private Player playerO;
    private ArrayList<Square> board;
    private boolean gameOver;
    private Player currentPlayer;

    public GameLogic() {
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.board = new ArrayList<>();
        this.createBoard();
        this.gameOver = false;
        this.currentPlayer = this.playerX;
    }

    private void createBoard() {
        for (int i = 0; i < 9; i++) {
            board.add(new Square());
        }
    }

    private boolean areThereAnyFreeSquares() {
        int countOfUnmarkedSquares = 0;
        for (Square square : board) {
            if (square.getSquareState() == SquareState.UNMARKED) {
                countOfUnmarkedSquares += 1;
            }
        }
        return countOfUnmarkedSquares > 0;
    }

    private boolean checkSameLineSymbol(Square s1, Square s2, Square s3) {
        if (s1.getSquareState() == SquareState.UNMARKED) {
            return false;
        }
        if (s2.getSquareState() == SquareState.UNMARKED) {
            return false;
        }
        if (s3.getSquareState() == SquareState.UNMARKED) {
            return false;
        }
        if (s1.getSquareState() == s2.getSquareState() && s1.getSquareState() == s3.getSquareState()) {
            return true;
        }
        return false;
    }

    private boolean checkRows() {
        if (checkSameLineSymbol(board.get(0), board.get(1), board.get(2))) {
            return true;
        }
        if (checkSameLineSymbol(board.get(3), board.get(4), board.get(5))) {
            return true;
        }
        if (checkSameLineSymbol(board.get(6), board.get(7), board.get(8))) {
            return true;
        }
        return false;
    }

    private boolean checkColumns() {
        if (checkSameLineSymbol(board.get(0), board.get(3), board.get(6))) {
            return true;
        }
        if (checkSameLineSymbol(board.get(1), board.get(4), board.get(7))) {
            return true;
        }
        if (checkSameLineSymbol(board.get(2), board.get(5), board.get(8))) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (checkSameLineSymbol(board.get(0), board.get(4), board.get(8))) {
            return true;
        }
        if (checkSameLineSymbol(board.get(2), board.get(4), board.get(6))) {
            return true;
        }
        return false;
    }

    private boolean anyPlayerWon() {
        if (checkRows()) {
            return true;
        }
        if (checkColumns()) {
            return true;
        }
        if (checkDiagonals()) {
            return true;
        }
        return false;
    }

    private boolean markSquare(Player player, int square) {
        if (board.get(square).getSquareState() == SquareState.O || board.get(square).getSquareState() == SquareState.X) {
            return false;
        }
        if (gameOver) {
            return false;
        }
        switch (player.getMark()) {
            case 'X':
                board.get(square).setSquareState(SquareState.X);
                break;
            case 'O':
                board.get(square).setSquareState(SquareState.O);
                break;
        }
        return true;
    }

    public Player getPlayerTurn() {
        return currentPlayer;
    }

    public boolean play(int square) {
        if (markSquare(currentPlayer, square)) {
            if (currentPlayer.equals(playerX)) {
                currentPlayer = playerO;
            } else {
                currentPlayer = playerX;
            }
            if (anyPlayerWon() || !areThereAnyFreeSquares()) {
                gameOver = true;
            }
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String gameInfo() {
        return isGameOver() ? "The end!" : "Turn: " + currentPlayer.getMark();
    }

}


