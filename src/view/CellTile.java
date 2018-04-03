package view;


import console.tile.Tile;
import model.Cell;
import model.cell.HomeCell;
import model.cell.SourceCell;
import view.cellTile.HomeTile;
import view.cellTile.SourceTile;
import view.cellTile.SpaceTile;


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
        return new SpaceTile(cell);
    }

    //TODO:
}
