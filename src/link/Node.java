package link;

public class Node {
	private Flag data;
	private Node link;
	
	public Node(){
		link = null;
		data = null;
	}
	
	public Node(Flag d){
		this(d, null);
	}
	
	public Flag getData() {
		return data;
	}

	public void setData(Flag data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public Node(Flag data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
}
