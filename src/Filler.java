/* Oscar Hedblad && Rodolfo Magasrevy
 * COP 3330, ARUP GHOSH
 * 
 * DESCRIPTION: Filler class. It creates the character and sets an initial position. 
 * It then finds out whether the filler is allowed to move and in which location he can go. 
 * Finally, the characters name is returned. 
 */
public class Filler extends Character{
/* Creates the filler and sets his initial position */
	public Filler(Cave initLoc){
		super(initLoc);
		location=initLoc;
		
	}
/* Checks if the filler can modify the cave and if he can open up a path*/
	public boolean modifyCave(Cave loc){
/* The filler can turn a pit into an available path */
		if(loc.isPit()){
			loc.makeOpen();
			return true;
		}
		else{
			return false;
		}
	}
/* Returns what modification the filler performed to the cave */
	public String describeModification(){
		if(modifyCave(location)==true){
			return "The Pit has been filled in by the Filler. It is safe to continue.";
		}
		else{
			return "";
		}
	}
/* Finds out if the filler can move to a new position. If possible, the move 
 * method gets called in the super class. If not, the character stays where he is. */
	public boolean move(Cave to){
/* If a cave is occupied the filler cannon move there */
		if(to.isOccupied())
		{
			return false;
		}
		else if(to.isBlocked()){
			return false;
		}
/* Filler can move into the cave only if the cave is not blocked/occupied */
		else{
			super.move(to);
			return true;
		}
	}
/* Returns the name of the filler */
	public String getName(){
		return "Filler"; 
	}
}