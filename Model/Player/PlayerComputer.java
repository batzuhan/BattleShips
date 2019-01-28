package Model.Player;

import Model.Field;
import Model.Location;
import Model.Ships.AircraftCarrier;
import Model.Ships.Destroyer;
import Model.Ships.Submarine;

import java.util.Random;

public class PlayerComputer extends Player {
    private int type;

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
    }

    @Override
    public Location selectMove(String move) {
        Random generator = new Random(System.currentTimeMillis());
        int row, col;
        int[][] memory = new int[getOpponentField().getRows()][getOpponentField().getColumns()];
        for (int i = 0; i < getOpponentField().getRows(); i++) {
            for (int j = 0; j < getOpponentField().getColumns(); j++) {
                memory[i][j] = 0;
            }
        }
        int counter=0;
        do {
            if(counter>((getOpponentField().getRows()/2)*(getOpponentField().getColumns()))){
                for (int i = 0; i < getOpponentField().getRows(); i++) {
                    for (int j = 0; j < getOpponentField().getColumns(); j++) {
                        if(memory[i][j] == 0){
                            memory[i][j]=1;
                            return getOpponentField().getLocation(i, j);
                        }
                    }
                }
            }

            row = generator.nextInt(getOpponentField().getRows());
            col = generator.nextInt(getOpponentField().getColumns());
            memory[row][col] = 1;
        } while ((row > 0 && row < getOpponentField().getRows())
                && (col > 0 && col < getOpponentField().getColumns())
                && !(getOpponentField().getLocation(row, col).isEmpty())
                && getOpponentField().getLocation(row, col).isMarked());

        return getOpponentField().getLocation(row, col);
    }

}
