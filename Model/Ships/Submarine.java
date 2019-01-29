package Model.Ships;

import Model.Field;

public class Submarine extends Ship {


    public Submarine(int length, int points, String letter, Field field, int[] start, ShipDirection direction) {
        super(length, points, letter, field, start, direction, 0);
    }

    @Override
    public String getSinkMessage() {
        return "A Submarine is sank by " + this.getField().getPlayer().getName() + "!";
    }

    @Override
    public void threaten() {

    }
}
