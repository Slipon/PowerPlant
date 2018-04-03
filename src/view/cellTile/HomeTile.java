package view.cellTile;

import isel.leic.pg.Console;
import model.Cell;
import view.CellTile;

import static isel.leic.pg.Console.*;

public class HomeTile extends CellTile {
    public HomeTile(Cell cell) {
        super(cell);
    }

    @Override
    public void paint() {
        cursor(1,1);
        Console.setBackground(RED);
        setForeground(WHITE);
        Console.print("H");
        Console.setBackground(BLACK);
        setForeground(WHITE);
        Console.print("-");
    }
}
