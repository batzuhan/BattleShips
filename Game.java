import Model.Player.Player;
import Model.Player.PlayerComputer;
import Model.Player.PlayerHuman;

public class Game {
    private int rows;
    private int columns;
    private int amountOfMoves;
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new PlayerHuman();
        player2 = new PlayerComputer();
    }

    public void init(){
        player1.initField(rows,columns);
        player2.initField(rows,columns);

    }
    public void placeShips(){
        player1.placeShips(player2.getOpponentField());
        player2.placeShips(player1.getOpponentField());
    }
    public void play(){

    }
    public void showResult(){

    }
}
