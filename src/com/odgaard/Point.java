package com.odgaard;

public class Point {
    private int x, y;
    private boolean life;

    Point(int x, int y, boolean life) {
        this.x = x;
        this.y = y;
        this.life = life;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    @Override
    public String toString() {
        if(life) return "O";
        else return ".";
    }
}
