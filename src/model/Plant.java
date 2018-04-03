package model;

public class Plant {
    private int width, height;
    private Cell[][] map;
    private int moves;
    private boolean completed;
    private Listener listener;


    public Plant(int height, int width) {
        this.width=width;
        this.height=height;
    }

    public void init() {

    }

    public void putCell(int l, int i, Cell cell) {
        //TODO
    }

    public Cell getCell(int l, int c) {
        //TODO
        return null;
    }

    public int getMoves() {
        return moves;
    }

    public boolean isCompleted() {
        return completed;
    }


    public boolean touch(int line, int col) {
        return false;
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
