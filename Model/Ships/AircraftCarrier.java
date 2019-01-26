package Model.Ships;

import Model.Field;
import Model.Location;

public class AircraftCarrier extends Ship{


    public AircraftCarrier(int length, int points, String letter, Field field, Location start, String direction) {
        super(length, points, letter, field, start, direction);
    }

    @Override
    void getSinkMessage() {

    }

    @Override
    void threaten() {

    }
}
