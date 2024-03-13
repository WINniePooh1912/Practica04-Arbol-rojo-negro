public class RBNode {
	int value;
	RBNode right;
	RBNode left;
	RBNode parent;

	private boolean isBlack;
	private boolean isSignal;

	int height;

	RBNode() {}

	RBNode(int value) {
		this.value = value;
	}

	RBNode(int value, RBNode signal) {
		this.value = value;
		right = signal;
		left = signal;
		parent = signal;
	}

	public int getValue(){
		return value;
	}

	public RBNode getLeft() {
		if(left != null && !left.isSignal)
			return left;
		else
			return null;
	}

	public RBNode getRight() {
		if(right != null && !right.isSignal)
			return right;
		else
			return null;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public boolean isRed() {
		return !isBlack;
	}

	public void setBlack() {
		isBlack = true;
	}

	public void setRed() {
		isBlack = false;
	}

	public static RBNode signalRB() {
		RBNode branch = new RBNode();
		branch.isSignal = true;
		branch.setBlack();
		return branch;
	}

	public void print() {
		System.out.print(value + " ");
	}

	public void printColor() {
		if(isRed()){
			System.out.print("R" + value + "R");
		}
		System.out.print("B" + value + "B");
	}
}
