package link;

public class QueueNode {
    private String data;
    private QueueNode link;
    
    public QueueNode() {
    	this.data=null;
    }
    public QueueNode(String data) {
    	this(data,null);
    }
	public QueueNode(String data, QueueNode link) {
		super();
		this.data = data;
		this.link = link;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public QueueNode getLink() {
		return link;
	}
	public void setLink(QueueNode link) {
		this.link = link;
	}
}
