package view;


import console.tile.Tile;
import isel.leic.pg.Console;
import model.Cell;
import model.Dash;
import model.Dir;
import model.cell.*;
import view.cellTile.*;

import java.util.List;

import static isel.leic.pg.Console.setForeground;


public abstract class CellTile extends Tile {
    public static final int SIDE = 3;
    protected Cell cell;

    protected CellTile(Cell cell) {
        this.cell=cell;
        setSize(SIDE, SIDE);
    }

    @Override
    public void paint() {

    }

    public static Tile newInstance(Cell cell) {
        if(cell instanceof HomeCell) return new HomeTile(cell);
        if(cell instanceof SourceCell) return new SourceTile(cell);
        if(cell instanceof LineCell)return new LineTile(cell);
        if(cell instanceof CurveCell)return new CurveTile(cell);
        if(cell instanceof BranchCell)return new BranchTile(cell);
        return new SpaceTile(cell);
    }

    protected void paintDash(int background, int foreground) {
        List<Dash> dash = cell.getDashes();
        for(Dash d : dash){
            cursor(1 +d.getDir().deltaLine, 1 +d.getDir().deltaCol);
            Console.setBackground(background);
            setForeground(foreground);
            Console.print( (d.getDir() == Dir.UP || d.getDir() == Dir.DOWN) ? "|" : "-");
        }
    }

    //TODO:
}
