package com.odgaard;

import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
    private Point[][] board;
    int min = 0;
    int max = 1;
    public GameBoard(int x, int y) {
        board = new Point[x][y];
    }

    public void fillTest1() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new Point(x, y, false);
            }
        }
        board[2][3].setLife(true);
        board[3][4].setLife(true);
        board[4][2].setLife(true);
        board[4][3].setLife(true);
        board[4][4].setLife(true);
        print();
    }

    public void fillTest2() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new Point(x, y, false);
            }
        }
        board[2][2].setLife(true);
        board[2][3].setLife(true);
        board[2][4].setLife(true);

    }

    public void fillTest3() {
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

    public void fill(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                boolean value = ThreadLocalRandom.current().nextBoolean();
                if(x == 0 || x == board.length-1 || y == 0 || y == board[x].length-1)
                    value = false;
                board[x][y] = new Point(x, y, value);
            }
        }
    }

    public void print() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Point[][] getBoard() {
        return this.board;
    }

}
