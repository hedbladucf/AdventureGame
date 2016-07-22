// Oscar Hedblad && Rodolfo Magasrevy
// COP 3330, ARUP GOSH
// provides information about the layout of the board used in the program.
// includes the 2d array used to illustrate unique cave spots
// aswell as the ability to randomly select an unoccupied spot that is 'in-bounds' 

public class Board{
	
	//field declaration
	int rows, cols;
	//instansiating the game board object
	static Cave[][] board= new Cave[AdventureGame.DEFAULT_ROWS][ AdventureGame.DEFAULT_COLS];
	//generates a random board given the Adventure game board standards, then fills in the random unique locations.
	//top left is always reserved initially for the adventurer and the bottom right is always reserved for the treasure.
	public Board(int ROWS, int COLS){
		rows = ROWS;
		cols = COLS;
		//fill in each individual location on the board with the specified possibilities
		for(rows=0; rows<board.length; rows++){
			for(cols=0; cols<board[rows].length; cols++){
					//instantiate cave object
			    	Cave Cave1 = new Cave(rows, cols);
					//40% chance of pits
					double boardRandom = Math.random();
					if(boardRandom <= .4){
						Cave1.makePit();
					}
					//40% chance of block space
					else if(boardRandom > .4 && boardRandom <= .8){
						
						Cave1.makeBlocked();
					}
					//10% chance of open space
					else if(boardRandom > .8 && boardRandom <= .9){
						
						Cave1.makeOpen();
					}
					//10% chance of teleport
					else if(boardRandom > .9 && boardRandom <= 1){
						
						Cave1.makeTeleport();
					}	
						board[rows][cols]=Cave1;
						
				}
			
			}
			//Adventurer
			board[0][0]=new Cave(0,0);
			board[0][0].makeOpen();
			//treasure
			board[rows-1][cols-1]=new Cave(rows-1,cols-1);
			board[rows-1][cols-1].makeOpen();
		}
		//returns the cave location at the specified row and column
		public Cave getCave(int r, int c){
			if(ok(r,c)==true){
				return board[r][c];
			}
			else{
				return null;
			}
		}
		//Is this a valid board location?
		public boolean ok(int r, int c){
			if(r>rows-1 || r<0 || c>cols-1 || c<0){ //Is this location out of bounds?
				return false;
			}
			else{
				return true;
			}
		}
		//returns an open location
		public Cave getUnoccupiedOpenLocation(){
			//Generates a random row and a random column 
			int row1=(int)(Math.random()*rows);
			int col1=(int)(Math.random()*cols);
			//if the random location happens to be where the adventurer or treasure is located
			//recursively call the function again until this condition is not met.
			if((row1==0&&col1==0)||(row1==9&&col1==9)){
				return getUnoccupiedOpenLocation();
			}
			//if the cave is open and unoccupied, return it!	
			if(getCave(row1, col1).isOpen()&& !getCave(row1, col1).isOccupied()){
				return getCave(row1, col1);
			}
			//if the random location is occupied...
			//recursively call the function again until this condition is not met.
			else{
				return getUnoccupiedOpenLocation();
			}
		}
}