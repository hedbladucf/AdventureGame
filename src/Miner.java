/* Oscar Hedblad && Rodolfo Magasrevy
 * COP 3330, ARUP GHOSH
 * 
 * DESCRIPTION: Miner class. It creates a miner character and give him an initial position. 
 * It finds out whether the miner is allowed to move and in which location he can go.
 * The characters name is returned at the end. 
 */
public class Miner extends Character{
/* Generates the miner and gives him an initial position */
	public Miner(Cave initLoc){
		super(initLoc);
		location=initLoc;
	}
/* Checks if the miner can modify the cave.*/
	public boolean modifyCave(Cave loc){
/* Sees can open an already blocked cave*/
		if(loc.isBlocked()){
			loc.makeOpen();
			return true;
		}
		else{
			return false;
		}
	}
	public String describeModification(){
/* If the miner can modify the cave the below message will print*/
		if(modifyCave(location)==true){
			return "The Blocked cave has been cleared by the Miner. It is safe to continue";
		}
		else{
			return "";
		}
	}
/* Finds out if the miner can move to another location. If possible the move method gets called
	 * in the super class. The Character class. */
	public boolean move(Cave to){
/* If the cave is already occupied the miner cannot enter*/
		if(to.isOccupied())
		{
			return false;
		}
/* Given that the cave is not already busy, the miner can enter*/
		else{
			super.move(to);
			return true;
		}
	}
/* Returns the name of the character*/
	public String getName(){
		return "Miner";
	}
}