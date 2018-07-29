package link;

public class Flag {
	private boolean value;
	
	public Flag() {
		value = false;
	}
	
	public Flag(boolean b) {
		value = b;
	}
	
	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String toString() {
		return "Flag [value=" + value + "]";
	}
	
	public void display(){toString();}
}
