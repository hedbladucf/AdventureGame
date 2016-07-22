/* Oscar Hedblad && Rodolfo Magasrevy
 * COP 3330, ARUP GHOSH
 * 
 * DESCRIPTION: Character class. This class holds data about the general game character. 
 * It implements the CaveWorker class which contains special operations on the cave, which is dependent on the type of character.
 * This class is also where the settings for free/occupied cave is performed.
 */
public abstract class Character implements CaveWorker{
/* The protected cave is the cave that is currently being occupied */
	protected Cave location;
/* Sets the characters initial position and sets the cave to become occupied */
	public Character(Cave initLoc){
		location = initLoc;
		location.setOccupied(true);
	}
/* Return the characters position */
	public Cave getLocation(){
		return location;
	}
/* Changes the characters current position to their new position determined by the player */
	public boolean move(Cave to){
/* Frees the old position */
		location.setOccupied(false);
		location= to;
/* Occupied the new position */
		to.setOccupied(true);
		return true;
	}
/* Abstract method that gets the name of the current selected character */
	public abstract String getName();
}
