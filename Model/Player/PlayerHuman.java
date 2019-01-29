package Model.Player;

import Model.Exceptions.Command;
import Model.Exceptions.InvalidLocationException;
import Model.Field;
import Model.FileOperations;
import Model.Game;
import Model.Location;
import Model.Ships.Ship;
import Model.Ships.ShipDirection;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Scanner;

public class PlayerHuman extends Player {


    public PlayerHuman(String name, int type) {
        super(name, type);

    }

    @Override
    public void placeShips(Field otherField) {
        Scanner scanner = new Scanner(System.in);

        for (Ship var : ships) {
            while (true) {
                System.out.println("Trying to place " + var.getLetter());
                System.out.println("Type in row: ");
                int row;
                String inputRow = scanner.next();
                inputRow = inputRow.toUpperCase();
                row = letterToInt(inputRow);
                while (row == -1) {
                    System.out.println("Wrong row! Please enter again: ");
                    inputRow = scanner.next();
                    inputRow = inputRow.toUpperCase();
                    row = letterToInt(inputRow);
                }


                System.out.println("Type in column: ");
                int col;
                try {
                    col = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    col = -1;
                }
                if (col == -1) {
                    System.out.println("Wrong column! Please enter again: ");

                    col = Integer.parseInt(scanner.next());
                }
                System.out.println("Type in direction: Horizontal or Vertical");
                ShipDirection direction = ShipDirection.fromString(scanner.next());
                while (direction == null) {
                    System.out.println("Wrong direction! Please enter again: ");
                    direction = ShipDirection.fromString(scanner.next());
                }

                if (col >= 0 && col <= otherField.getColumns()) {
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
                    System.out.println(Command.HELP);

                case "exit":
                    System.exit(0);

                case "save":
                    File desktop = new File(System.getProperty("user.home"), "/Desktop");
                    FileOperations.writeToFile(desktop, this.getGame());

                case "load":
                    fileBrowser();

            }
            return null;

        } else {
            Scanner scanner = new Scanner(System.in);
            String inputRow;
            int row = letterToInt(move.substring(0, 1).toUpperCase());
            while (row == -1) {
                System.out.println("Wrong row! Please enter the row again: ");
                inputRow = scanner.next();
                inputRow = inputRow.toUpperCase();
                row = letterToInt(inputRow);
            }
            int col = -1;
            try {
                col = Integer.parseInt(move.substring(1));
            } catch (Exception e) {
                while (col < 0 || col >= getOpponentField().getColumns()) {
                    System.out.println("Wrong column! Please enter again: ");
                    col = Integer.parseInt(scanner.next());
                }
            }

            if (row >= 0 && row < getOpponentField().getRows() && col >= 0 && col < getOpponentField().getColumns() && !(getOpponentField().getLocation(row, col).isMarked())) {
                return getOpponentField().getLocation(row, col);

            } else {
                //didn't know what to do
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

    public void fileBrowser() {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) return;
        Game game = (Game) FileOperations.readFromFile(new File(chooser.getSelectedFile().getPath()));
        try {
            game.play();
        } catch (InvalidLocationException e1) {
            e1.printStackTrace();
        }
    }

}
