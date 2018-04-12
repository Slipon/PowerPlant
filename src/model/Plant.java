package model;

import model.cell.SpaceCell;

public class Plant {
    private int width, height;
    private Cell[][] map;
    private int moves;
    private boolean completed;
    private Listener listener;


    public Plant(int height, int width) {
        this.width=width;
        this.height=height;
        map = new Cell[height][width];
    }

    public void init() {

    }

    public void putCell(int l, int c, Cell cell) {
        map[l][c]=cell;
    }

    public Cell getCell(int l, int c) {
        return (l<0 || l>height || c<0 || c>width) ? null : map[l][c];
    }

    public int getMoves() {
        return moves;
    }

    public boolean isCompleted() {
        return completed;
    }


    public boolean touch(int line, int col) {
        if(map[line][col] instanceof SpaceCell) return false;
        ++moves;
        map[line][col].rotateCell();
        listener.cellChanged(line,col,map[line][col]);
        return true;
    }


    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void cellChanged(int lin, int col, Cell cell);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
 }
