package Model;

import Model.Player.Player;
import Model.Ships.Ship;

public class Field {
    private int rows;
    private int columns;
    private Location[][] locations;
    private Player player;

    public Field(int rows, int columns, Player player) {
        this.rows = rows;
        this.columns = columns;
        this.player = player;

        this.locations = new Location[rows][columns];

        for (int row = 0; row < locations.length; row++)
        {
            for (int col = 0; col < locations[row].length; col++)
            {
                Location tempLocation = new Location(row,col,null,false);
                locations[row][col] = tempLocation;
            }
        }
    }

    public Location getLocation(int r, int c){
        return locations[r][c];
    }


    public Location getLocation(String locString){
        for (int row = 0; row < locations.length; row++)
        {
            for (int col = 0; col < locations[row].length; col++)
            {
                if(locString.equals(locations[row][col])){
                    return locations[row][col];
                }
            }
        }
        return null;
        // If the string is not of the correct form or the row and/or column are out of bounds for this 􏰀field,
        // this method throws an InvalidLocationException, with a suitable informative message (eg. “Invalid row”).
    }

    public void placeShipRandomly(Ship s, int maxTries, boolean checkMarked){

    }

    public void placeShip(Ship s, boolean checkMarked){

    }


    public void removeShip(Ship s){
        for (int row = 0; row < locations.length; row++)
        {
            for (int col = 0; col < locations[row].length; col++)
            {
                if(locations[row][col].equals(s.getLetter())){
                    //locations[row][col];
                }
            }
        }    }

    public void   processValidMove(Location moveLoc){

    }

    public String toString() {
       // Returns a string for the whole f􏰀ield which can be used to print it as described at the beginning
        // of the section “Main game”.
        return null;
    }
    public void toStringWithShips(){
        //Returns a string for thw whole 􏰀ield that can be used to print it as described at the section “End of the game”.
        //Apart from the above methods, it is expected that the Field class will contain other methods to implement speci􏰀ic functionalities, such as the threats to ships.
    }
}
