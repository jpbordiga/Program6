import java.util.LinkedList;

public class Vertex {

	private int vNumber;
	private String color;
	private Vertex predecessor;
	private int distance;
	private LinkedList<Vertex> adjList = new LinkedList<>();
	
	public Vertex(int vN) {
		
		vNumber = vN;
		color = null;
		predecessor = null;
		distance = 0;
		
	}
	
	public String getColor() {
		return color;
	}
	
	public Vertex getPredecessor() {
		return predecessor;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public LinkedList<Vertex> getAdjList() {
		return this.adjList;
	}
	
	public int getVNumber() {
		return this.vNumber;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public void setPredecessor(Vertex p) {
		predecessor = p;
	}
	
	public void setDistance(int d) {
		distance = d;
	}
	
	public void addToAdjList(Vertex v) {
		this.adjList.add(v);	
	}
	
	public void removeFromAdjList(Vertex v) {
		adjList.remove(v);
	}
	
}
