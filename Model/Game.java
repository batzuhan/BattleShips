package Model;

import Model.Exceptions.InvalidLocationException;
import Model.Player.Player;

import java.util.Scanner;


public class Game {
    private int rows;
    private int columns;
    private int amountOfMoves;
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
        player1.setGame(this);
        player2.setGame(this);

    }
    public void placeShips(){
        player1.placeShips(player2.getOpponentField());
        player2.placeShips(player1.getOpponentField());
    }
    public void play()throws InvalidLocationException {
        Scanner scanner = new Scanner(System.in);
        if(this.amountOfMoves==0){
            do{
                if(player1.getType()==0)
                    player2.getOpponentField().processValidMove(player1.selectMove(scanner.next()));
                if(player1.getType()==1)
                    player2.getOpponentField().processValidMove(player1.selectMove(""));
                player2.getOpponentField().toStringWithShips();
                if(player2.getType()==0)
                    player1.getOpponentField().processValidMove(player2.selectMove(scanner.next()));
                if(player2.getType()==1)
                    player1.getOpponentField().processValidMove(player2.selectMove(""));
                player1.getOpponentField().toStringWithShips();
            }while(!player1.hasWon() && !player2.hasWon());
        }else {
            int counter=0;
            do {
                 counter++;
                player2.getOpponentField().processValidMove(player1.selectMove(scanner.next()));
                player1.getOpponentField().processValidMove(player2.selectMove(scanner.next()));
            } while (this.amountOfMoves!=counter);

        }

    }
    public void showResult(){
        if(player1.hasWon()){
            System.out.println(player1.getName()+" has won!");
        }else{
            System.out.println(player2.getName()+" has won!");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
