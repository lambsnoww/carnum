package lin.datastructure;

public class BinNode {
    private int element;
    private BinNode left;
    private BinNode right;
    
    /** Constructors */
    BinNode(int val, BinNode l, BinNode r) {
    	element = val;
    	left = l;
    	right = r;
    }
    BinNode(int val) {
    	this(val, null, null);
    }
    public boolean isLeaf() {
    	return (left == null) && (right == null);
    }
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public BinNode getLeft() {
		return left;
	}
	public void setLeft(BinNode left) {
		this.left = left;
	}
	public BinNode getRight() {
		return right;
	}
	public void setRight(BinNode right) {
		this.right = right;
	}
}
