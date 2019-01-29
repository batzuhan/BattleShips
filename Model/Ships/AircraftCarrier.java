package Model.Ships;

import Model.Field;

public class AircraftCarrier extends Ship {


    public AircraftCarrier(int length, int points, String letter, Field field, int[] start, ShipDirection direction) {
        super(length, points, letter, field, start, direction, 0);
    }

    @Override
    public String getSinkMessage() {
        return "An AircraftCarrier is sank by " + this.getField().getPlayer().getName() + "!";
    }

    @Override
    public void threaten() {
        //it does not move.
    }
}
