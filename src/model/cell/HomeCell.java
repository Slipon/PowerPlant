package model.cell;

import model.Cell;
import model.Dash;
import model.Dir;

public class HomeCell extends Cell {
    private int dashes_number;

    public HomeCell(int dashes_number){
        this.dashes_number=dashes_number;
        dashes.add(new Dash(Dir.randomDir()));
    }
}
