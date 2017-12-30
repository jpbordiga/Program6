import java.util.ArrayList;
import java.util.LinkedList;

public interface BreadthFirstSearchInterface {

	public void breadthFirstSearch(ArrayList<LinkedList<Vertex>> G, Vertex source); //
	public String printPath(ArrayList<LinkedList<Vertex>> G, Vertex source, Vertex v);
	
}
