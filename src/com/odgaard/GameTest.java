package com.odgaard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class GameTest {

    private GameBoard gameBoard;

    @BeforeEach
    void init() {
        var gameBoard = new GameBoard(10, 10);
        gameBoard.emptyFill();
        this.gameBoard = gameBoard;
    }

    @Test
    void fillTest1() {
        var board = gameBoard.getBoard();

        board[3][2].setLife(true);
        board[3][3].setLife(true);
        board[3][4].setLife(true);

        var testGame = new Game(gameBoard);
        testGame.run(1, false);

        var alivePoints = new HashSet<Point>();
        alivePoints.add(board[2][3]);
        alivePoints.add(board[3][3]);
        alivePoints.add(board[4][3]);

        boolean bool;
        for (Point[] array : board) {
            for (Point point : array) {
                bool = alivePoints.contains(point);
                if (point.getLife())
                    Assertions.assertTrue(bool);
                else
                    Assertions.assertFalse(bool);
            }
        }
    }

    // TODO
    @Test
    void fillTest2() {
        var board = gameBoard.getBoard();

        board[2][3].setLife(true);
        board[3][4].setLife(true);
        board[4][2].setLife(true);
        board[4][3].setLife(true);
        board[4][4].setLife(true);
    }

    // TODO
    @Test
    void fillTest3() {
        var board = gameBoard.getBoard();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new Point(x, y, false);
            }
        }
        board[4][2].setLife(true);
        board[4][3].setLife(true);
        board[4][4].setLife(true);

        board[3][3].setLife(true);
        board[3][4].setLife(true);
        board[3][5].setLife(true);
    }
}