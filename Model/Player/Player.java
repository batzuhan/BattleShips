package Model.Player;

public abstract class Player {
/*The classes that represent the players of the game. The 􏰀irst one is an abstract base class of the other two, which implement the different behaviors of a human player and of a player controlled by the computer.
Each player stores its name and score, as well as the field on which he is playing (on which his opponent’s ships are placed).
The class contains accessor methods for these 􏰀ields, as well as the following methods:
  initField(int r, int c)
Creates the 􏰀ield of the player, with the given number of rows and columns.
1We may re-use the built-in InputMismatchException exception type since its meaning is appropriate for the error that we wish to handle here.
 4
placeShips(Field otherField)
Places the player’s ships on the given 􏰀ield (which will be the opponent’s 􏰀ield). The Field
class is presented below.
hasWon()
Checks if the player has sunk all the ships on his 􏰀ield.
  selectMove()
Implements the selection of position for the player’s move. If the selected position is valid, it returns a Location reference corresponding to the position selected by the player; other- wise it throws an exception of type InvalidLocationException (see below) and does not return anything. In this method only the validity of the position is checked, and not whether it constitutes a valid move (i.e., if it has alredy been selected in a previous move, in which case it cannot be selected again).
For a human player, a line of text is read from the keyboard and, 􏰀irst, is checked if it corre- sponds to a command (eg. save); in this case an exception of type MoveIsCommandException (see below) is thrown and the method is terminated.2 If the line read was not a command, the method tries to analyse it as a move, in the form “A11” as mentioned above; in this case, the corresponding location of the 􏰀ield is returned, and if not, an exception of type InvalidLocationException is thrown.
For a computer player you may improvise for selecting a move. The simplest way would be to select it randomly (random row and column).
It is expected that these class will contain additional 􏰀ields and methods to better organize some functions such as the ship placement.
*/
}
