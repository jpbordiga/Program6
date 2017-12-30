import java.util.LinkedList;

public interface FIFOQueueInterface {

	public void enqueue(LinkedList<Vertex> queue, Vertex v);
	public Vertex dequeue(LinkedList<Vertex> queue);
	
}
