package Model.Player;

import Model.Field;
import Model.Ships.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHuman extends Player{



    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public void placeShips(Field otherField) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ship> ships = new ArrayList<>();
        AircraftCarrier a1 = new AircraftCarrier(5,5,"A",otherField,null,null);
        AircraftCarrier a2 = new AircraftCarrier(5,5,"A",otherField,null,null);
        Destroyer d1 = new Destroyer(3,2,"D",otherField,null,null);
        Destroyer d2 = new Destroyer(3,2,"D",otherField,null,null);
        Destroyer d3 = new Destroyer(3,2,"D",otherField,null,null);
        Submarine s1 = new Submarine(1,3,"S",otherField,null,null);
        Submarine s2 = new Submarine(1,3,"S",otherField,null,null);
        ships.add(a1);
        ships.add(a2);
        ships.add(d1);
        ships.add(d2);
        ships.add(d3);
        ships.add(s1);
        ships.add(s2);
        for (Ship var : ships)
        {
            while (true){
            System.out.println("Trying to place "+var.getLetter());
            System.out.println("Type in row: ");
            String inputRow = scanner.next();
            inputRow = inputRow.toUpperCase();
            int row = letterToInt(inputRow);

            System.out.println("Type in column: ");
            int col = scanner.nextInt();

            System.out.println("Type in direction: Horizontal or Vertical");
            ShipDirection direction = ShipDirection.fromString(scanner.next());

            if (col >= 0 && col <= otherField.getColumns() && row != -1 && direction != null)
            {
                if (isAvailable(row,col,direction,var,otherField))
                {
                    var.setDirection(direction);
                    int start[] = {row,col};
                    var.setStart(start);
                    otherField.placeShip(var);
                    break;
                }
            }

        }
            otherField.placeShip(var);
        }
    }

    @Override
    public void selectMove(String move) {
        String row = move.substring(0,1).toLowerCase();
        String col = move.substring(1,3).toLowerCase();
    }
    private boolean isAvailable(int row, int col, ShipDirection direction, Ship s,Field otherField)
    {

        if (direction.equals(ShipDirection.HORIZONTAL))
        {
            int check = s.getLength() + col;
            if (check > otherField.getColumns())
            {
                System.out.println("It doesn't fit!");
                return false;
            }
            for (int i = col; i < col+s.getLength(); i++)
            {
                if(otherField.getLocation(row, i).getOccupyingShip()!=null)
                {
                    System.out.println("Location is not empty!");
                    return false;
                }
            }
        }else if (direction.equals(ShipDirection.VERTICAL))
        {
            int check = s.getLength() + row;
            if (check > otherField.getRows())
            {
                System.out.println("It doesn't fit!");
                return false;
            }
            for (int i = row; i < row+s.getLength(); i++)
            {
                if(otherField.getLocation(i,col).getOccupyingShip()!=null)
                {
                    System.out.println("Location is not empty!");
                    return false;
                }
            }
        }
        return true;
    }
    private int letterToInt(String value)
    {
        switch (value)
        {
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
