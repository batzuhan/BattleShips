package Model.Player;

import Model.Field;
import Model.Location;
import Model.Ships.AircraftCarrier;
import Model.Ships.Destroyer;
import Model.Ships.Submarine;

import java.util.Random;

public class PlayerComputer extends Player {

    public PlayerComputer(String name) {
        super(name);
    }

    @Override
    public void placeShips(Field otherField) {
        AircraftCarrier a1 = new AircraftCarrier(5, 5, "A", otherField, null, null);
        AircraftCarrier a2 = new AircraftCarrier(5, 5, "A", otherField, null, null);
        Destroyer d1 = new Destroyer(3, 2, "D", otherField, null, null);
        Destroyer d2 = new Destroyer(3, 2, "D", otherField, null, null);
        Destroyer d3 = new Destroyer(3, 2, "D", otherField, null, null);
        Submarine s1 = new Submarine(1, 3, "S", otherField, null, null);
        Submarine s2 = new Submarine(1, 3, "S", otherField, null, null);
        otherField.placeShipRandomly(a1, 3);
        otherField.placeShipRandomly(a2, 3);
        otherField.placeShipRandomly(d1, 3);
        otherField.placeShipRandomly(d2, 3);
        otherField.placeShipRandomly(d3, 3);
        otherField.placeShipRandomly(s1, 3);
        otherField.placeShipRandomly(s2, 3);
    }

    @Override
    public Location selectMove(String move) {
        Random generator = new Random(System.currentTimeMillis());
        int row, col;
        do {
            row = generator.nextInt(getOpponentField().getRows() - 1);
            col = generator.nextInt(getOpponentField().getColumns() - 1);

        } while ((row > 0 && row < getOpponentField().getRows())
                && (col > 0 && col < getOpponentField().getColumns())
                && !(getOpponentField().getLocation(row, col - 1).isEmpty())
                && getOpponentField().getLocation(row, col - 1).isMarked());

        return getOpponentField().getLocation(row, col);
    }

}
