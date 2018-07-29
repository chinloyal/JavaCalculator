package link;

public class Queue {
	private QueueNode front;
	
	public Queue() {
		front= null;
	}
	public Queue(QueueNode front){
		this.front = front;
	}
	public QueueNode getFront(){
		return front;
	}
	public void setFront(QueueNode front){
		this.front = front;
	}
	public boolean isEmpty(){
		return (front == null);
	}
	public boolean isFull() {
		return (new QueueNode() == null);
	}
	
	public void enqueue(String data){
		if(isFull())
			System.out.println("Link Is Full...");
		else {
			QueueNode newNode = new QueueNode(data);
			if(isEmpty())
				 front = newNode;
			else {
				QueueNode current = front;
				while(current.getLink() != null) {
					current = current.getLink();
				}
				current.setLink(newNode);
			}
		}
	}
	
	public String dequeue(){
		String value ="";
		if(isEmpty()) return null;

		value = front.getData();
		front = front.getLink();
		
		/*QueueNode current = front;
		front = current.getLink();
		value = current.getData();
		current = null;*/
		
		return value;
	}
	
	public void destroy(){
		while(dequeue() != null);
	}
	
	public StringBuilder display(){
		QueueNode current = front;
		StringBuilder temp = new StringBuilder("");
		while(current != null){
			temp.append(" "+current.getData());
			current = current.getLink();
		}
		return temp;
	}
}

