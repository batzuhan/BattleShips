package Model;

import Model.Player.Player;
import Model.Ships.Ship;

public class Location {
    private int row;
    private int col;
    private Ship occupyingShip;
    private boolean isMarked;
    private Player markedBy;

    public Location(int row, int col, Ship occupyingShip, boolean isMarked) {
        this.row = row;
        this.col = col;
        this.occupyingShip = occupyingShip;
        this.isMarked = isMarked;
    }

    public void mark() {
        if (getOccupyingShip() != null)
            occupyingShip.hit();

        this.setMarked(true);
    }

    public Ship getOccupyingShip() {
        return occupyingShip;
    }

    public void setOccupyingShip(Ship occupyingShip) {
        this.occupyingShip = occupyingShip;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isEmpty() {
        if (getOccupyingShip() == null)
            return true;
        else
            return false;
    }

    public boolean isHit() {
        if (getOccupyingShip() != null && isMarked())
            return true;
        else
            return false;
    }

    public Player getMarkedBy() {
        return markedBy;
    }

    public void setMarkedBy(Player markedBy) {
        this.markedBy = markedBy;
    }
}
