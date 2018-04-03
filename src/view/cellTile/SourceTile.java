package view.cellTile;

import isel.leic.pg.Console;
import model.Cell;
import view.CellTile;

import static isel.leic.pg.Console.*;

public class SourceTile extends CellTile {
    public SourceTile(Cell cell) {
        super(cell);
    }

    @Override
    public void paint() {
        cursor(1,1);
        Console.setBackground(YELLOW);
        setForeground(BROWN);
        Console.print("P");
        setForeground(BLACK);
        Console.print("-");
    }
}
