/* Oscar Hedblad && Rodolfo Magasrevy
 * COP 3330, ARUP GHOSH
 * 
 * DESCRIPTION: Cave class. This class gets the position of the cave and will return all required 
 * information about it; such as column, row, etc. It also tells if a spot is marked as a pit, open, 
 * blocked, or if it contains a teleporter. 
 */

public class Cave{
/* Declaration of variables */ 
	public int Row, Column;
	boolean setO;
	boolean setM;
/* Enum containing the different variations of a cave */
	 public enum CaveType{
		OPEN, PIT, BLOCKED, TELEPORT;
	}
	private CaveType CaveDescription;
/* Generates an open cave which is originally free or not yet marked */
	public Cave(int r, int c){
		Row=r;
		Column=c;
		this.CaveDescription=null;
		
	}
/* Returns the row */
	public int getRow(){
		return Row;
	}
/* Returns the column */
	public int getCol(){
		return Column;
	}
/* Lets the game know if a cave is being occupied */
	public void setOccupied(boolean set){
		this.setO=set;
	}
/* Returns the condition of the cave (free/occupied) */
	public boolean isOccupied(){
		return setO;
		}
/* Lets the game know if a cave is being marked by the adventurer */
	public void setMarked(boolean set){
		this.setM=set;
	}
/* Returns the condition (free/occupied) whether the cave is being marked by the adventurer*/
	public boolean isMarked(){
			return setM;
	}
/* Opens up a cave */
	public void makeOpen(){
		this.CaveDescription=CaveType.OPEN;
	}
/* Returns the condition of the cave (open/not open) */
	public boolean isOpen(){
		if(CaveDescription==CaveType.OPEN){
			return true;
		}
		else{
			return false;
		}
	}
/* Blocks a cave */
	public void makeBlocked(){
		this.CaveDescription=CaveType.BLOCKED;
	}
/* Returns the condition of the cave (blocked/not blocked) */
	public boolean isBlocked(){
		if(CaveDescription==CaveType.BLOCKED){
			return true;
		}
		else{
			return false;
		}
	}
/* Turns a cave into a pit */
	public void makePit(){
		this.CaveDescription=CaveType.PIT;
	}
/* Returns if a cave is now a pit */
	public boolean isPit(){
		if(CaveDescription==CaveType.PIT){
			return true;
		}
		else{
			return false;
		}
	}
/* Turns a cave into a teleporting position */
	public void makeTeleport(){
		this.CaveDescription=CaveType.TELEPORT;
	}
/* Returns the condition of the cav, whether its a teleporting position or not */
	public boolean isTeleport(){
		if(CaveDescription==CaveType.TELEPORT){
			return true;
		}
		else{
			return false;
		}
	}
}