import Model.Player.Player;
import Model.Player.PlayerComputer;
import Model.Player.PlayerHuman;

public class Game {
    private int rows;
    private int columns;
    private int amountOfMoves;
    private Player player1;
    private Player player2;

    public Game(int rows, int columns, Player player1, Player player2) {
        this.rows = rows;
        this.columns = columns;
        this.player1 = player1;
        this.player2 = player2;
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

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
