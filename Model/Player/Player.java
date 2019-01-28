package Model.Player;

import Model.Exceptions.InvalidLocationException;
import Model.Field;
import Model.Location;
import Model.Game;
import Model.Ships.AircraftCarrier;
import Model.Ships.Destroyer;
import Model.Ships.Ship;
import Model.Ships.Submarine;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int type;
    private int score=0;
    private Field opponentField;
    private Game game;
    private int scoreToBeCollected=0;
    public ArrayList<Ship> ships = new ArrayList<>();
    AircraftCarrier a1 = new AircraftCarrier(5, 5, "A", null, null, null);
    AircraftCarrier a2 = new AircraftCarrier(5, 5, "A", null, null, null);
    Destroyer d1 = new Destroyer(3, 2, "D", null, null, null);
    Destroyer d2 = new Destroyer(3, 2, "D", null, null, null);
    Destroyer d3 = new Destroyer(3, 2, "D", null, null, null);
    Submarine s1 = new Submarine(1, 3, "S", null, null, null);
    Submarine s2 = new Submarine(1, 3, "S", null, null, null);

    public Player (String name,int type){
        this.name = name;
        this.type = type;
        ships.add(a1);
        ships.add(a2);
        ships.add(d1);
        ships.add(d2);
        ships.add(d3);
        ships.add(s1);
        ships.add(s2);
    }

    public int getScoreToBeCollected() {
        return scoreToBeCollected;
    }

    public void setScoreToBeCollected(int scoreToBeCollected) {
        this.scoreToBeCollected += scoreToBeCollected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public Field getOpponentField() {
        return opponentField;
    }

    private void setOpponentField(Field opponentField) {
        this.opponentField = opponentField;
    }

    public void initField(int r, int c){
        Field boardField = new Field(r,c,this);
        this.setOpponentField(boardField);
    }

    public abstract void placeShips(Field otherField);

    public boolean hasWon(){
        if(score==scoreToBeCollected){
            return true;
        }else{
            return false;
        }


    }

    public abstract Location selectMove(String move) throws InvalidLocationException;

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
