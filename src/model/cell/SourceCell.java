package model.cell;

import model.Cell;
import model.Dash;
import model.Dir;

public class SourceCell extends Cell {
    private int dashes_number;

    public SourceCell(int dashes_number){
        this.dashes_number=dashes_number;
        dashes.add(new Dash(Dir.randomDir()));
    }
}
