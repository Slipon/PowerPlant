package model;


import model.cell.HomeCell;
import model.cell.SourceCell;
import model.cell.SpaceCell;

public abstract class Cell {
    protected static Plant model;

    public static Cell newInstance(char type) {
        switch (type){
            case 'P':
                return new SourceCell();
            case 'H':
                return new HomeCell();
            case '.':
                return new SpaceCell();
            default:
                return new SpaceCell();
        }
    }

    //TODO:
}
