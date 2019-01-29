package Model;

import Model.Exceptions.InvalidLocationException;
import Model.Player.Player;
import Model.Ships.Ship;
import Model.Ships.ShipDirection;

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
        boolean isSuccessful = false;
        int length = s.getLength();
        ShipDirection direction = s.getDirection();

        if (direction.equals(ShipDirection.HORIZONTAL)) {
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
                    isSuccessful = true;
                    locations[s.start[0]][i].setOccupyingShip(s);
                }
                player.setScoreToBeCollected(s.getPoints());
            }
        } else if (direction.equals(ShipDirection.VERTICAL)) {
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
                    isSuccessful = true;
                    locations[i][s.start[1]].setOccupyingShip(s);
                }
                player.setScoreToBeCollected(s.getPoints());
            }
        }
        return isSuccessful;
    }

    public void removeShip(Ship s) {
        int length = s.getLength();
        ShipDirection direction = s.getDirection();

        if (direction.equals(ShipDirection.HORIZONTAL)) {
            {
                for (int i = s.start[1]; i < s.start[1] + length; i++) {
                    locations[s.start[0]][i].setOccupyingShip(null);
                }
            }
        } else if (direction.equals(ShipDirection.VERTICAL)) {
            {
                for (int i = s.start[0]; i < s.start[0] + length; i++) {
                    locations[i][s.start[1]].setOccupyingShip(null);
                }
            }
        }
    }


    public void placeShipRandomly(Ship s, int maxTries) {
        int tries = 0;
        boolean isPlaced = false;
        do {
            tries++;
            int length = s.getLength();
            String[] directions = {"HORIZONTAL", "VERTICAL"};
            Random random = new Random();
            int select = random.nextInt(directions.length);
            ShipDirection direction = ShipDirection.fromString(directions[select]);
            s.setDirection(direction);

            int row = random.nextInt(rows);
            int col = random.nextInt(columns);
            int start[] = {row, col};
            s.setStart(start);
            if (direction.equals(ShipDirection.HORIZONTAL)) {
                boolean check = false;
                if ((s.start[1] + length) >= getColumns() || (s.start[0] + length) >= getRows()) {
                    check = true;
                } else {
                    for (int i = s.start[1]; i < s.start[1] + length; i++) {
                        if (locations[s.start[0]][i] == null) {
                            check = true;
                            break;

                        } else if (locations[s.start[1]][i].isEmpty()) {

                        } else {
                            check = true;
                        }
                    }
                }
                if (check) {

                } else {
                    for (int i = s.start[1]; i < s.start[1] + length; i++) {
                        locations[s.start[0]][i].setOccupyingShip(s);
                    }
                    isPlaced = true;
                    player.setScoreToBeCollected(s.getPoints());
                }
            } else if (direction.equals(ShipDirection.VERTICAL)) {
                boolean check = false;
                if ((s.start[0] + length >= getRows()) || (s.start[1] + length) >= getColumns()) {
                    check = true;
                } else {
                    for (int i = s.start[0]; i < s.start[0] + length; i++) {
                        if (locations[i][s.start[1]] == null) {
                            check = true;
                            break;
                        } else if (locations[i][s.start[1]].isEmpty()) {

                        } else {
                            check = true;
                        }
                    }
                    if (check) {

                    } else {
                        for (int i = s.start[0]; i < s.start[0] + length; i++) {
                            locations[i][s.start[1]].setOccupyingShip(s);
                        }
                        isPlaced = true;
                        player.setScoreToBeCollected(s.getPoints());
                    }
                }
            }
        } while (maxTries != tries && !isPlaced);

    }

    public void processValidMove(Location moveLoc) {
        if (moveLoc == null) {

        } else {
            locations[moveLoc.getRow()][moveLoc.getCol()].mark();
        }

    }

    public void toStringWithShips() {
        System.out.println();
        System.out.println("Player "+this.player.getName()+"'s field:");
        System.out.println();
        for (int i = 0; i < columns; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < columns; i++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (locations[i][j].getOccupyingShip() != null) {
                    if (locations[i][j].isMarked()) {
                        System.out.print(" x" + locations[i][j].getOccupyingShip().getLetter() + " ");
                    } else {
                        System.out.print("  " + locations[i][j].getOccupyingShip().getLetter() + " ");
                    }
                } else if (!locations[i][j].isMarked()) {
                    System.out.print("  O ");
                } else if (locations[i][j].isMarked()) {
                    System.out.print("  X ");
                }
            }
            System.out.println();
        }
    }

    public Location[][] getLocations() {
        return locations;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Player getPlayer() {
        return player;
    }
}
