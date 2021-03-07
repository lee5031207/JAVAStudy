package builder;

public class Calculator {

	private int val = 0;
	
	public Calculator add(int val) {
		this.val += val;
		return this;
	}
	
	public Calculator subtract(int val) {
		this.val -= val;
		return this;
	}
	
	public int out() {
		return this.val;
	}
	
}
