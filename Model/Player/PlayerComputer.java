package Model.Player;

import Model.Field;
import Model.Location;
import Model.Ships.AircraftCarrier;
import Model.Ships.Destroyer;
import Model.Ships.Submarine;

import java.util.Random;

public class PlayerComputer extends Player {
    private int[][] memory;

    public PlayerComputer(String name, int type) {
        super(name, type);
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
        otherField.placeShipRandomly(a1, 5);
        otherField.placeShipRandomly(a2, 5);
        otherField.placeShipRandomly(d1, 5);
        otherField.placeShipRandomly(d2, 5);
        otherField.placeShipRandomly(d3, 5);
        otherField.placeShipRandomly(s1, 5);
        otherField.placeShipRandomly(s2, 5);
        this.memory = new int[getOpponentField().getRows()][getOpponentField().getColumns()];
        for (int i = 0; i < getOpponentField().getRows(); i++) {
            for (int j = 0; j < getOpponentField().getColumns(); j++) {
                memory[i][j] = 0;
            }
        }
    }

    @Override
    public Location selectMove(String move) {
        Random generator = new Random(System.currentTimeMillis());
        int row, col;

        row = generator.nextInt(getOpponentField().getRows());
        col = generator.nextInt(getOpponentField().getColumns());
        /*while (memory[row][col] == 1) {
            row = generator.nextInt(getOpponentField().getRows());
            col = generator.nextInt(getOpponentField().getColumns());
            tried going full random, memory errors occured.
        }*/
        if (memory[row][col] == 1) {
            for (int i = 0; i < getOpponentField().getRows(); i++) {
                for (int j = 0; j < getOpponentField().getColumns(); j++) {
                    if (memory[i][j] == 0) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
        }
        memory[row][col] = 1;
        return getOpponentField().getLocation(row, col);
    }

}
