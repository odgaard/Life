package com.odgaard;

import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
    private Point[][] board;
    int min = 0;
    int max = 1;
    public GameBoard(int x, int y) {
        board = new Point[x][y];
    }


    public void randomFill(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                boolean value = ThreadLocalRandom.current().nextBoolean();
                if(x == 0 || x == board.length-1 || y == 0 || y == board[x].length-1)
                    value = false;
                board[x][y] = new Point(x, y, value);
            }
        }
    }

    public void emptyFill() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new Point(x, y, false);
            }
        }
    }

    public void setPoint(Point point) {
        board[point.getX()][point.getY()].setLife(point.getLife());
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
