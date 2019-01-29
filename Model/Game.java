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

    public Game(int rows, int columns, Player player1, Player player2, int amountOfMoves) {
        this.rows = rows;
        this.columns = columns;
        this.player1 = player1;
        this.player2 = player2;
        this.amountOfMoves = amountOfMoves;
    }

    public void init() {
        player1.initField(rows, columns);
        player2.initField(rows, columns);
        player1.setGame(this);
        player2.setGame(this);

    }

    public void placeShips() {
        player1.placeShips(player1.getOpponentField());
        player2.placeShips(player2.getOpponentField());
        //player2.getOpponentField().toStringWithShips();
        //player1.getOpponentField().toStringWithShips();
        //for debugging
    }

    public void play() throws InvalidLocationException {
        Scanner scanner = new Scanner(System.in);
        GUI.gameField gameField = new GUI.gameField(this);
        if (this.amountOfMoves == 0) {
            do {
                if (player1.getType() == 0) {
                    System.out.println("Enter a valid location (e.g. A5): ");
                    player2.getOpponentField().processValidMove(player1.selectMove(scanner.next()));

                }

                if (player1.getType() == 1)
                    player2.getOpponentField().processValidMove(player1.selectMove(""));


                if (player2.getType() == 0) {
                    System.out.println("Enter a valid location (e.g. A5): ");
                    player1.getOpponentField().processValidMove(player2.selectMove(scanner.next()));

                }

                if (player2.getType() == 1)
                    player1.getOpponentField().processValidMove(player2.selectMove(""));

                GUI.gameField.revalidate(this);
            } while (!player1.hasWon() && !player2.hasWon());
        } else {
            int counter = 0;
            do {
                counter++;
                if (player1.getType() == 0) {
                    System.out.println("Enter a valid location (e.g. A5): ");
                    player2.getOpponentField().processValidMove(player1.selectMove(scanner.next()));
                }

                if (player1.getType() == 1)
                    player2.getOpponentField().processValidMove(player1.selectMove(""));

                if (player2.getType() == 0) {
                    System.out.println("Enter a valid location (e.g. A5): ");
                    player1.getOpponentField().processValidMove(player2.selectMove(scanner.next()));
                }


                if (player2.getType() == 1)
                    player1.getOpponentField().processValidMove(player2.selectMove(""));

                GUI.gameField.revalidate(this);
            } while (this.amountOfMoves != counter);

        }
        this.showResult();
    }

    public void showResult() {
        if (player1.hasWon()) {
            System.out.println(player1.getName() + " has won 1!");
            System.out.println("Scores: ");
            System.out.println(player1.getName() + ":  " + player1.getScore());
            System.out.println(player2.getName() + ":  " + player2.getScore());
            player2.getOpponentField().toStringWithShips();
        } else if (player2.hasWon()) {
            System.out.println(player2.getName() + " has won 2!");
            System.out.println("Scores: ");
            System.out.println(player1.getName() + ":  " + player1.getScore());
            System.out.println(player2.getName() + ":  " + player2.getScore());
            player1.getOpponentField().toStringWithShips();
        } else {
            System.out.println("Out of Moves!");
            System.out.println("Scores: ");
            System.out.println(player1.getScore());
            player2.getOpponentField().toStringWithShips();
            System.out.println(player2.getScore());
            player1.getOpponentField().toStringWithShips();
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
