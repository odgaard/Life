package com.odgaard;

public class Main {

    public static void main(String[] args) {
        var board = new GameBoard(10, 10);
        board.randomFill();

        var game = new Game(board);
        game.run(5, true);
    }
}
