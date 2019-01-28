package Model.Player;

import Model.Exceptions.Command;
import Model.Exceptions.InvalidLocationException;
import Model.Exceptions.MoveIsCommandException;
import Model.Field;
import Model.Location;
import Model.Ships.*;

import java.util.Scanner;

public class PlayerHuman extends Player {
    private int type;


    public PlayerHuman(String name,int type) {
        super(name,type);

    }

    @Override
    public void placeShips(Field otherField) {
        Scanner scanner = new Scanner(System.in);

        for (Ship var : ships) {
            while (true) {
                System.out.println("Trying to place " + var.getLetter());
                System.out.println("Type in row: ");
                String inputRow = scanner.next();
                inputRow = inputRow.toUpperCase();
                int row = letterToInt(inputRow);

                System.out.println("Type in column: ");
                int col = scanner.nextInt();

                System.out.println("Type in direction: Horizontal or Vertical");
                ShipDirection direction = ShipDirection.fromString(scanner.next());

                if (col >= 0 && col <= otherField.getColumns() && row != -1 && direction != null) {
                    if (isAvailable(row, col, direction, var, otherField)) {
                        var.setDirection(direction);
                        int start[] = {row, col};
                        var.setStart(start);
                        var.setField(otherField);
                        otherField.placeShip(var);
                        break;
                    }
                }

            }
            otherField.placeShip(var);
        }
    }

    @Override
    public Location selectMove(String move) throws InvalidLocationException {
        if (move.equals("help")
                || move.equals("save")
                || move.equals("load")
                || move.equals("exit")) {

            switch (move) {
                case "help":
                    throw new MoveIsCommandException(Command.HELP);

                case "exit":
                    throw new MoveIsCommandException(Command.EXIT);

                case "save":
                    throw new MoveIsCommandException(Command.SAVE);

                case "load":
                    throw new MoveIsCommandException(Command.LOAD);

            }
            return null;

        } else {
            int row = letterToInt(move.substring(0, 1).toUpperCase());
            int col = Integer.parseInt(move.substring(1));

            if (row >= 0 && row < getOpponentField().getRows() && col >= 0 && col < getOpponentField().getColumns() && !(getOpponentField().getLocation(row, col).isMarked())) {
                return getOpponentField().getLocation(row, col);

            } else {
                throw new InvalidLocationException("Invalid move.");
            }

        }
    }

    private boolean isAvailable(int row, int col, ShipDirection direction, Ship s, Field otherField) {

        if (direction.equals(ShipDirection.HORIZONTAL)) {
            int check = s.getLength() + col;
            if (check > otherField.getColumns()) {
                System.out.println("It doesn't fit!");
                return false;
            }
            for (int i = col; i < col + s.getLength(); i++) {
                if (otherField.getLocation(row, i).getOccupyingShip() != null) {
                    System.out.println("Location is not empty!");
                    return false;
                }
            }
        } else if (direction.equals(ShipDirection.VERTICAL)) {
            int check = s.getLength() + row;
            if (check > otherField.getRows()) {
                System.out.println("It doesn't fit!");
                return false;
            }
            for (int i = row; i < row + s.getLength(); i++) {
                if (otherField.getLocation(i, col).getOccupyingShip() != null) {
                    System.out.println("Location is not empty!");
                    return false;
                }
            }
        }
        return true;
    }

    private int letterToInt(String value) {
        switch (value) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            default:
                return -1;
        }
    }

}
