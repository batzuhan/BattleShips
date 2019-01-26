package Model;

import Model.Ships.Ship;

public class Location {
    private int row;
    private int col;
    private Ship occupyingShip;
    private boolean isMarked = false;

    public void mark(){
        if(getOccupyingShip()!=null)
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

    //gözden geçir
    public boolean isEmpty(){
        if(getOccupyingShip() == null)
            return true;
        else
            return false;
    }

    public boolean isHit(){
        if(getOccupyingShip()!=null&&isMarked())
            return true;
        else
            return false;
    }

}
