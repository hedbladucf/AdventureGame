// Oscar Hedblad && Rodolfo Magasrevy
// COP 3330, ARUP GHOSH
// This class will describe what modifications are allowed by certain
// characters and actually carries out those modifications, if it is allowed
// for that given location for a specific character type.
public interface CaveWorker{
	//Makes modifications to a given cave if this worker can
	//modify this type of cave
	boolean modifyCave(Cave loc);
	//Gives a description of the type of modification made
	String describeModification();
}