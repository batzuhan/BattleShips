package Model;

import Model.Exceptions.InvalidLocationException;
import Model.Player.Player;
import Model.Ships.Ship;

import java.util.Random;

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

        for (int row = 0; row < locations.length; row++) {
            for (int col = 0; col < locations[row].length; col++) {
                Location tempLocation = new Location(row, col, null, false);
                locations[row][col] = tempLocation;
            }
        }
    }

    public Location getLocation(int r, int c) {
        return locations[r][c];
    }


    public Location getLocation(String locString) throws InvalidLocationException {
        Location location = null;
        for (int row = 0; row < locations.length; row++) {
            for (int col = 0; col < locations[row].length; col++) {
                if (locString.equals(locations[row][col])) {
                    location = locations[row][col];
                    return locations[row][col];
                }
            }
        }

        if (location == null) {
            throw new InvalidLocationException("Invalid String");
        }
        return null;
    }



    public boolean placeShip(Ship s) {
        boolean isSuccessful=false;
        int length = s.getLength();
        String direction = s.getDirection();

        if (direction.equals("HORIZONTAL")) {
            boolean check = false;
            for (int i = s.start[1]; i < s.start[1] + length; i++) {
                if (locations[i][s.start[1]].isEmpty()) {

                } else {
                    check = true;
                }
            }
            if (check) {

            } else {
                for (int i = s.start[1]; i < s.start[1] + length; i++) {
                    isSuccessful=true;
                    locations[s.start[0]][i].setOccupyingShip(s);
                }
            }
        } else if (direction.equals("VERTICAL")) {
            boolean check = false;
            for (int i = s.start[0]; i < s.start[0] + length; i++) {
                if (locations[i][s.start[1]].isEmpty()) {

                } else {
                    check = true;
                }
            }
            if (check) {

            } else {
                for (int i = s.start[0]; i < s.start[0] + length; i++) {
                    isSuccessful=true;
                    locations[i][s.start[1]].setOccupyingShip(s);
                }
            }
        }
        return isSuccessful;
    }

    public void removeShip(Ship s) {
        int length = s.getLength();
        String direction = s.getDirection();

        if (direction.equals("HORIZONTAL")) {
            {
                for (int i = s.start[1]; i < s.start[1] + length; i++) {
                    locations[s.start[0]][i].setOccupyingShip(null);
                }
            }
        } else if (direction.equals("VERTICAL")) {
            {
                for (int i = s.start[0]; i < s.start[0] + length; i++) {
                    locations[i][s.start[1]].setOccupyingShip(null);
                }
            }
        }
    }


    public void placeShipRandomly(Ship s, int maxTries) {
        int tries=0;
        do {
            tries++;
            int length = s.getLength();
            String [] directions = {"HORIZONTAL", "VERTICAL"};
            Random random = new Random();
            int select = random.nextInt(directions.length);
            String direction = directions[select];
            s.setDirection(direction);

            int row = random.nextInt(rows);
            int col = random.nextInt(columns);
            int start[] = {row,col};
            s.setStart(start);

            if (direction.equals("HORIZONTAL")) {
                boolean check = false;
                for (int i = s.start[1]; i < s.start[1] + length; i++) {
                    if (locations[i][s.start[1]].isEmpty()) {

                    } else {
                        check = true;
                    }
                }
                if (check) {

                } else {
                    for (int i = s.start[1]; i < s.start[1] + length; i++) {
                        locations[s.start[0]][i].setOccupyingShip(s);
                    }
                }
            } else if (direction.equals("VERTICAL")) {
                boolean check = false;
                for (int i = s.start[0]; i < s.start[0] + length; i++) {
                    if (locations[i][s.start[1]].isEmpty()) {

                    } else {
                        check = true;
                    }
                }
                if (check) {

                } else {
                    for (int i = s.start[0]; i < s.start[0] + length; i++) {
                        locations[i][s.start[1]].setOccupyingShip(s);
                    }
                }
            }
        }while (maxTries!=tries);

    }

    public void processValidMove(Location moveLoc) {

    }

    public String toString() {
        // Returns a string for the whole f􏰀ield which can be used to print it as described at the beginning
        // of the section “Main game”.
        return null;
    }

    public void toStringWithShips() {

    }

    public Location[][] getLocations() {
        return locations;
    }
}
