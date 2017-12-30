import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjacencyListGraph {

	ArrayList<LinkedList<Vertex>> vertexAdjLists = new ArrayList<>();
	private LinkedList<Vertex> vertexList = new LinkedList<>();
	
	public AdjacencyListGraph(Scanner iF, int n) { // creates and Adjacency List Graph from the input data
		
		for(int i = 0; i < n; i++) {
			
			Vertex v = new Vertex(i);
			vertexList.add(v);
			
		}
		
		while((iF.hasNextLine() == true) && (iF.hasNextInt() == true)) {
			
			int a = iF.nextInt();
			int b = iF.nextInt();
			
			vertexList.get(a).addToAdjList(vertexList.get(b));
			vertexList.get(b).addToAdjList(vertexList.get(a));
		
		}
		
		for(int i = 0; i < n; i++) {
			
			vertexAdjLists.add(vertexList.get(i).getAdjList());
			
		}
		
	}
	
	public ArrayList<LinkedList<Vertex>> getGraph() {
		return vertexAdjLists;
	}
	
	public LinkedList<Vertex> getVertexList() {
		return vertexList;
	}	
	
}
