import Model.Player.Player;


public class Game {
    private int rows;
    private int columns;
    private int amountOfMoves=0;
    private Player player1;
    private Player player2;

    public Game(int rows, int columns, Player player1, Player player2,int amountOfMoves) {
        this.rows = rows;
        this.columns = columns;
        this.player1 = player1;
        this.player2 = player2;
        this.amountOfMoves=amountOfMoves;
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
        if(this.amountOfMoves==0){
            do{

            }while(!player1.hasWon() && !player2.hasWon());
        }else {
            int counter=0;
            do {
                 counter++;

            } while (this.amountOfMoves!=counter);

        }

    }
    public void showResult(){
        if(player1.hasWon()){
            System.out.println(player1.getName()+"has won!");
        }else{
            System.out.println(player2.getName()+"has won!");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
