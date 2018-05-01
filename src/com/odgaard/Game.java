package com.odgaard;

import java.util.HashSet;

public class Game {
    private GameBoard gameBoard;

    public Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void run(int generations) {
        var changedPoints = new HashSet<Point>();

        var points = gameBoard.getBoard();
        for (int g = 0; g < generations; g++) {
            for (int x = 1; x < points.length-1; x++) {
                for (int y = 1; y < points[x].length-1; y++) {
                    var point = points[x][y];
                    if(point.getLife() != checkLife(point)) changedPoints.add(point);
                }
            }

            for(Point point : changedPoints) {
                point.setLife(!point.getLife());
            }
            changedPoints.clear();

            gameBoard.print();
        }
    }

    public boolean checkLife (Point point) {
        int x = point.getX();
        int y = point.getY();
        boolean alive = point.getLife();
        Point[][] points = gameBoard.getBoard();

        int neighbours = 0;
        if (points[x - 1][y - 1].getLife()) neighbours++;
        if (points[x - 1][y].getLife()) neighbours++;
        if (points[x - 1][y + 1].getLife()) neighbours++;
        if (points[x][y - 1].getLife()) neighbours++;
        if (points[x][y + 1].getLife()) neighbours++;
        if (points[x + 1][y - 1].getLife()) neighbours++;
        if (points[x + 1][y].getLife()) neighbours++;
        if (points[x + 1][y + 1].getLife()) neighbours++;

        if (alive) {
            if ((neighbours == 2) || (neighbours == 3)) {
                return true;
            }
        }
        
        return neighbours == 3;
    }
}
