package model;


import model.cell.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Cell {
    protected static Plant model;
    protected List<Dash> dashes = new ArrayList<>();

    public static Cell newInstance(char type) {
        switch (type){
            case 'P':
                return new SourceCell(1);
            case 'H':
                return new HomeCell(1);
            case '.':
                return new SpaceCell(0);
            case '-':
                return new LineCell(2);
            case 'c':
                return new CurveCell(2);
            case 'T':
                return new BranchCell(3);
            default:
                return new SpaceCell(0);
        }
    }

    public List<Dash> getDashes() {
        return dashes;
    }

    public void rotateCell(){
        Dir currentDir;
        for (Dash d : dashes) {
            currentDir = d.getDir();
            d.setDir(currentDir.nextPos());
        }
    }
}
