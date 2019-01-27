package Model.Player;

import Model.Field;
import Model.Ships.AircraftCarrier;
import Model.Ships.Destroyer;
import Model.Ships.Submarine;

public class PlayerHuman extends Player{
    private


    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public void placeShips(Field otherField) {
        //ask user to enter start & direction
        AircraftCarrier a1 = new AircraftCarrier(5,5,"A",otherField,null,null);
        AircraftCarrier a2 = new AircraftCarrier(5,5,"A",otherField,null,null);
        Destroyer d1 = new Destroyer(3,2,"D",otherField,null,null);
        Destroyer d2 = new Destroyer(3,2,"D",otherField,null,null);
        Destroyer d3 = new Destroyer(3,2,"D",otherField,null,null);
        Submarine s1 = new Submarine(1,3,"S",otherField,null,null);
        Submarine s2 = new Submarine(1,3,"S",otherField,null,null);
        otherField.placeShip(a1);
        otherField.placeShip(a2);
        otherField.placeShip(d1);
        otherField.placeShip(d2);
        otherField.placeShip(d3);
        otherField.placeShip(s1);
        otherField.placeShip(s2);
    }

    @Override
    public void selectMove(String move) {
        String row = move.substring(0,1).toLowerCase();
        String col = move.substring(1,3).toLowerCase();
    }

}
