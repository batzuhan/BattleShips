package Model;

import Model.Ships.Ship;

public class Location {
    private int row;
    private int col;
    private Ship occupyingShip;
    private boolean isMarked;

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

    public void mark(){
        //Called when the player selects this location. Apart from setting this location as marked, it also
        //hits the ship that occupies it.
    }

    public void isEmpty(){
        //getOccupyingShip == null
        //Checks whether this position is empty (no ship occupies it).
    }

    public void isHit(){
        //Checks whether the ship that occupies this position has been hit on this position.
    }

}
