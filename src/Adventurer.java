/* Oscar Hedblad && Rodolfo Magasrevy
 * COP 3330, ARUP GHOSH
 * 
 * DESCRIPTION: Adventurer class. This class creates the character and sets its initial position;
 * it then modifies the cave that he is allowed to and returns what changes were made. In the end this class
 * returns the name of the character.  
 */
public class Adventurer extends Character{
/* Generates the adventurer and gives him his initial position */
	public Adventurer(Cave initLoc){
		super(initLoc);
		location=initLoc;
	}
/* Checks to see if the adventurer can modify the cave and if he can it becomes a marked cave */
	public boolean modifyCave(Cave loc){
/* The adventurer marks a teleportation spot */
		if(loc.isTeleport()){
			loc.setMarked(true);
			return true;
		}
		else{
			return false;
		}
	}
/* Returns the description of what modifications the adventurer performed */
	public String describeModification(){
		if(modifyCave(location)==true){
			return "There exists a Teleporter at this position"; 
		}
		else{
			return "";
		}
	}
/* Finds out if the adventurer can move to his new position. If possible, the move
 * method gets called in the super class. The move then gets performed, if not possible,
 * the character will stay in his current position. */
	public boolean move(Cave to){
/* The adventurer cannot move into an already occupied cave */
		if(to.isOccupied())
		{
			return false;
		}
/* The adventurer cannon move into an already blocked cave */
		else if(to.isBlocked()){
			return false;
		}
/* Lets the adventurer move into any cave that is neither occupied/marked */
		else{
			super.move(to);
			return true;
		}
	}
/* Returns the name */
	public String getName(){
		return "Adventurer"; 
	}
}
