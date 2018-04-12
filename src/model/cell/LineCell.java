package model.cell;

import model.Cell;
import model.Dash;
import model.Dir;

public class LineCell extends Cell {
    private int dashes_number;

    public LineCell(int dashes_number){
        this.dashes_number=dashes_number;
        Dash dash;
        dashes.add( dash = new Dash(Dir.randomDir()));
        dashes.add(dash.withOppositeDirection());
    }
}
