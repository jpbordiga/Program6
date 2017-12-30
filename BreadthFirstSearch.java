import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch implements BreadthFirstSearchInterface {

	FIFOQueue q;
	AdjacencyListGraph aLGraph; 
	LinkedList<Vertex> queue;
	
	public BreadthFirstSearch(AdjacencyListGraph aLG) {
		q = new FIFOQueue();
		aLGraph = aLG;
		queue = new LinkedList<>(); // set of gray vertices
	}

	@Override
	public void breadthFirstSearch(ArrayList<LinkedList<Vertex>> G, Vertex source) { // performs a BFS on the input graph
	
		for(Vertex u : aLGraph.getVertexList()) {
			
			if(u.equals(source) == false) {
				u.setColor("WHITE");
				u.setDistance(Integer.MAX_VALUE);
				u.setPredecessor(null);
			}
			
		}
		
		source.setColor("GRAY");
		source.setDistance(0);
		source.setPredecessor(null);
	
		q.enqueue(queue, source);
		
		while(queue.size() != 0) {
			
			Vertex u = q.dequeue(queue);
			
			for(Vertex v : u.getAdjList()) {
				
				if(v.getColor() == "WHITE") {
					v.setColor("GRAY");
					v.setDistance(u.getDistance() + 1);
					v.setPredecessor(u);
					q.enqueue(queue, v);
				}
				
			}
			
			u.setColor("BLACK");
	
		}
		
	}

	@Override
	public String printPath(ArrayList<LinkedList<Vertex>> G, Vertex source, Vertex v) { // prints the path from s to v, if it exists
		
		if(v.equals(source) == true) {
			return Integer.toString(source.getVNumber());
		} else if(v.getPredecessor() == null) {
			return "no path from " + source.getVNumber() + " to " + v.getVNumber() + " exists.";
		} else {
			return printPath(G, source, v.getPredecessor()) + "-" + Integer.toString(v.getVNumber());
		}
		
	}
	
}
