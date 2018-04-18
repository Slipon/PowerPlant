package model;

import model.cell.SourceCell;
import model.cell.SpaceCell;

public class Plant {
    private int width, height;
    private Cell[][] map;
    private int moves;
    private Listener listener;


    public Plant(int height, int width) {
        this.width=width;
        this.height=height;
        map = new Cell[height][width];
    }

    public void init() {
        boardRefactor();
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

    /**
     * Method to check if all the connections are "true", with the exception of SpaceCell
     */
    public boolean isCompleted() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(!(map[i][j] instanceof SpaceCell) && !map[i][j].isConnected())return false;
            }
        }
        return true;
    }


    /**
     * Method to check when a cell is touched/clicked.
     * Verifies if it's not a SpaceCell.
     * Case not, increments moves, rotates the cell and re-paint the board.
     */
    public boolean touch(int line, int col) {
        if(map[line][col] instanceof SpaceCell) return false;
        ++moves;
        map[line][col].rotateCell();
        boardRefactor();
        rePaintBoard();
        return true;
    }

    /**
     * Method to re-paint the board by "checking" all the board cells.
     */
    private void rePaintBoard() {
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                listener.cellChanged(i,j,map[i][j]);
            }
        }
    }

    /**
     * Method to check every SourceCell to assign the connection between cells.
     */
    private void boardRefactor() {
        clearBoard();
        for (int i = 0; i <height; i++) {
            for (int j = 0; j <width; j++) {
                if(map[i][j] instanceof SourceCell){
                    fillConnections(map[i][j], i, j);
                }
            }
        }
    }

    /**
     * Method to assign every cells connection.
     * For the current cell, if there's a neighbor, checks his connection.
     * If there's no connection, set 'True'.
     * The method uses recursivity to check every cell's neighbor
     */
    private void fillConnections(Cell cell, int line, int col) {
        for(Dir d : cell.getDirections()){
            Cell neighbor = getNeighborIfPossible(line,col,d);
            if (neighbor==null)continue;
            if(!neighbor.isConnected() && checkConnection(neighbor,d)){
                neighbor.setConnection(true);
                fillConnections(neighbor,line+d.deltaLine,col+d.deltaCol);
            }
        }
    }

    /**
     * Method to check if the current cell's neighbor has the opposite dash orientation
     */
    private boolean checkConnection(Cell neighbor, Dir currDir) {
        return neighbor.getDirections().contains(currDir.opposite());
    }

    /**
     * Method to check the available directions for each cell's neighbor
     */
    private Cell getNeighborIfPossible(int line, int col, Dir d) {
        line=line+d.deltaLine;
        col=col+d.deltaCol;
        if(line<0 || line>=height || col<0 || col>=width) return null;
        return map[line][col];
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

    /**
     * Method to clear all the connections between cells.
     */
    private void clearBoard(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                    map[i][j].setConnection(false);
            }
        }
    }
 }
