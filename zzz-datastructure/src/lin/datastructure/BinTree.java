package lin.datastructure;

public class BinTree {
    private BinNode root;//root
    private int nodecount;
    
    BinTree() { root = null; nodecount = 0; }
    BinTree(BinNode rt, int n) {
        root = rt;
        nodecount = n;
    }
    
}