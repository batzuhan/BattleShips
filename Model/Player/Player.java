package Model.Player;

import Model.Field;

public abstract class Player {
    private String name;
    private int score;
    private Field opponentField;


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

    public void placeShips(Field otherField){

    }
    //Places the player’s ships on the given 􏰀ield (which will be the opponent’s 􏰀field).

    public void hasWon(){

    }
    //Checks if the player has sunk all the ships on his 􏰀field.

    abstract void selectMove();
/*
Implements the selection of position for the player’s move. If the selected position is valid, it returns a Location reference corresponding to the position selected by the player; other- wise it throws an exception of type InvalidLocationException (see below) and does not return anything. In this method only the validity of the position is checked, and not whether it constitutes a valid move (i.e., if it has alredy been selected in a previous move, in which case it cannot be selected again).
For a human player, a line of text is read from the keyboard and, 􏰀irst, is checked if it corre- sponds to a command (eg. save); in this case an exception of type MoveIsCommandException (see below) is thrown and the method is terminated.2 If the line read was not a command, the method tries to analyse it as a move, in the form “A11” as mentioned above; in this case, the corresponding location of the 􏰀ield is returned, and if not, an exception of type InvalidLocationException is thrown.
For a computer player you may improvise for selecting a move. The simplest way would be to select it randomly (random row and column).
It is expected that these class will contain additional 􏰀ields and methods to better organize some functions such as the ship placement.

*/
}
