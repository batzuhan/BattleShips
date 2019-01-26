package Model.Player;

import Model.Field;

public class PlayerHuman extends Player{


    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public void placeShips(Field otherField) {

    }

    @Override
    void selectMove(String move) {
        String row = move.substring(0,1).toLowerCase();
        String col = move.substring(1,3).toLowerCase();
    }

}
