import java.util.LinkedList;

public class FIFOQueue implements FIFOQueueInterface {

	private int head;
	private int tail;	
	public FIFOQueue() {
		
		head = 0;
		tail = 0;
		
	}
	
	@Override
	public void enqueue(LinkedList<Vertex> queue, Vertex v) {

		
		queue.add(v);
		
		if(tail == queue.size() - 1) {
			tail = 0;
		} else {
			tail = tail + 1;
		}
		
	}

	@Override
	public Vertex dequeue(LinkedList<Vertex> queue) {
		
		Vertex v = queue.removeLast();
		
		if(head == queue.size() - 1) {
 			head = 0;
		} else {
			head = head + 1;
		}
		
		return v;
		
	}

}
