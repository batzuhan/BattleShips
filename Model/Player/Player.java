package Model.Player;

import Model.Field;

public abstract class Player {
    private String name;
    private int score;
    private Field opponentField;

    public Player (String name){
        this.name = name;
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
        this.score = score;
    }

    public Field getOpponentField() {
        return opponentField;
    }

    private void setOpponentField(Field opponentField) {
        this.opponentField = opponentField;
    }

    public void initField(int r, int c){
        Field boardField = new Field(r,c);
        this.setOpponentField(boardField);
    }

    public abstract void placeShips(Field otherField);

    abstract void hasWon();

    abstract void selectMove();

}
