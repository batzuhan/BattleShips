package Model;

public class Field {
/*The 􏰀ield of each player.
Stores its number of rows and of cols (columns), as well as a (simple) 2-dimensional array with the locations of the 􏰀ield. Finally, it stores a reference to the player who plays on this 􏰀ield.
  getLocation(int r, int c)
Returns the location at the row and column given. It is assumed that the values of the row
and column are valid for this 􏰀ield.
  getLocation(String locString)
Returns the location at the row and column indicated by the string given (eg. “A11”). If the string is not of the correct form or the row and/or column are out of bounds for this 􏰀ield, this method throws an InvalidLocationException, with a suitable informative message (eg. “Invalid row”).
  placeShipRandomly(Ship s, int maxTries, boolean checkMarked)
Places the ship at a random (valid) location on the 􏰀ield. The method generates random row, column and direction for the ship and places it according to them, provided the position is valid. If it is not valid, the procedure is repeated at most maxTries times (if maxTries is zero, the procedure is repeated until a valid position is found).
The parameter checkMarked must be true if we wish the validity check to include whether the positions of the ship have already been selected (for example, during moving a ship), or false otherwise.
The method returns true if a valid position is found, or false if not. placeShip(Ship s, boolean checkMarked)
Attempts to place the ship in the 􏰀ield. The ship must already have stored the data of the (desired) position and direction. If its position is valid, the method puts it in place and up-
2This may be an abuse of the exception mechanism, since the input is valid but it is not valid as a move. 5

dates all relevant information, and returns true. Otherwise it returns false. The parameter
checkMarked has the same meaning as in the previous method. removeShip(Ship s)
Removes the ship given through the parameter from the 􏰀ield.
  processValidMove(Location moveLoc)
Process a move of a player. Assumes that the move is valid. It checks if any ship was hit, sunk,
or threatened, does the necessary adjustments and prints suitable messages.
toString()
Returns a string for the whole 􏰀ield which can be used to print it as described at the beginning
of the section “Main game”.
  toStringWithShips()
Returns a string for thw whole 􏰀ield that can be used to print it as described at the section “End of the game”.
Apart from the above methods, it is expected that the Field class will contain other methods to implement speci􏰀ic functionalities, such as the threats to ships.
*/
}
