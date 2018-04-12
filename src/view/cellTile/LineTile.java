package view.cellTile;

import isel.leic.pg.Console;
import model.Cell;
import view.CellTile;

import static isel.leic.pg.Console.*;
import static isel.leic.pg.Console.WHITE;

public class LineTile extends CellTile {
    public LineTile(Cell cell){
        super(cell);
    }
    @Override
    public void paint() {
        cursor(1,1);
        Console.setBackground(BLACK);
        setForeground(WHITE);
        Console.print("o");
        paintDash(BLACK,WHITE);
    }
}
