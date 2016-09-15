package datastructure;

public interface VarBinNode {
	public boolean isLeaf();
}

class VarLeafNode implements VarBinNode {
	private String operand;
	
	public VarLeafNode(String val) {
		operand = val;
	}
	public boolean isLeaf() {
		return true;
	}
	public String value() {
		return  operand;
	}
}

class VarIntlNode implements VarBinNode {
	private VarBinNode left;
	private VarBinNode right;
	private Character operator;
	
	public VarIntlNode(Character op, VarBinNode l, VarBinNode r) {
		operator = op;
		left = l;
		right = r;
	}
	public boolean isLeaf() {
		return false;
	}
	public VarBinNode leftchild() {
		return left;
	}
	public VarBinNode rightchild() {
		return right;
	}
	public Character value() {
		return operator;
	}
	
	public static void traverse(VarBinNode rt) {
		if (rt == null) return;
		if (rt.isLeaf())
			Visit.VisitLeafNode(((VarLeafNode)rt).value());
		else {
			Visit.visitInternalNode(((VarIntlNode)rt).value());
		}
	}
}
