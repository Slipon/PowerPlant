package model.cell;

import model.Cell;
import model.Dash;
import model.Dir;

public class CurveCell extends Cell {
    private int dashes_number;

    public CurveCell(int dashes_number){
        this.dashes_number=dashes_number;
        Dash dash;
        dashes.add(dash = new Dash(Dir.randomDir()));
        dashes.add(dash.withNextDirection());
    }
}