package link;

public class CharNode {
    private char data;
    private CharNode link;
    
    public CharNode() {
    	this.data='\0';
    }
    public CharNode(char data) {
    	this(data,null);
    }
	public CharNode(char data, CharNode link) {
		this.data = data;
		this.link = link;
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public CharNode getLink() {
		return link;
	}
	public void setLink(CharNode link) {
		this.link = link;
	}
}

