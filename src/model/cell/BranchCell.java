package model.cell;

import model.Cell;
import model.Dash;
import model.Dir;

public class BranchCell extends Cell {
    private int dashes_number;

    public BranchCell(int dashes_number){
        this.dashes_number=dashes_number;
        Dash dash;
        dashes.add(dash = new Dash(Dir.randomDir()));
        dashes.add(dash = dash.withNextDirection());
        dashes.add(dash.withNextDirection());
    }
}
