package lin.datastructure;


class BST {
	private BinNode root;
	private int nodecount;
	private int h;// 树的高度
	private int w;// 树的宽度

	BST() {
		root = null;
		nodecount = 0;
	}

	public void clear() {
		root = null;
		nodecount = 0;
	}

	// /////////////////////////////////////////////////////
	public void refreshHW() {
		h = getHeight();
		w = (int) (Math.pow(2, h - 1));
	}

	public void insert(int e) {
		root = inserthelp(root, e);
		nodecount++;
	}

	public BinNode inserthelp(BinNode rt, int e) {

		if (rt == null)
			return (new BinNode(e));

		if (e < rt.getElement()) {
			rt.setLeft(inserthelp(rt.getLeft(), e));
			return rt;
		} else {
			rt.setRight(inserthelp(rt.getRight(), e));
			return rt;
		}
	}

	public BinNode[] find2(BinNode r, BinNode parent, int e) {
		if (r == null) {
			BinNode[] rt = { null, parent };
			return rt;
		}
		if (e < r.getElement()) {
			return find2(r.getLeft(), r, e);
		} else if (e > r.getElement()) {
			return find2(r.getRight(), r, e);
		} else {
			BinNode[] rt = { r, parent };
			return rt;
		}
	}

	public BinNode[] find2(int e) {
		return this.find2(root, null, e);
	}

	public BinNode find(int e) {
		return find2(e)[0];
	}

	public boolean remove(int e) {
		BinNode f = find2(e)[0];
		BinNode p = find2(e)[1];
		// 没找到
		if (f == null)
			return false;
		// 找到了，是叶结点
		if (f.getLeft() == null && f.getRight() == null) {
			if (p == null)
				root = null;
			else {
				if (f.getElement() < p.getElement())
					p.setLeft(null);
				else
					p.setRight(null);
			}
		} else {// 找到了，非叶结点
			if (p == null) {
				BinNode sub = f.getRight();
				BinNode psub = f;
				while (sub.getLeft() != null) {
					psub = sub;
					sub = sub.getLeft();
				}
			}
		}

	}

	public int getHeight(BinNode rt) {
		if (rt == null)
			return 0;
		else {
			int h1 = getHeight(rt.getLeft());
			int h2 = getHeight(rt.getRight());
			if (h1 > h2)
				return h1 + 1;
			else
				return h2 + 1;
		}
	}

	public int getHeight() {
		return this.getHeight(root);
	}

	public void printtree(int gap, String symble) {

		if (root == null)
			return;
		refreshHW();
		int c = 2 * w - 1;

		int[][] a = new int[h][c];
		for (int i = 0; i < c; i++) {
			if (i % 2 == 0)
				a[h - 1][i] = -1;// 4
		}

		for (int j = h - 2; j >= 0; j--) {
			int temp = -1;
			for (int i = 0; i < c; i++) {
				if (a[j + 1][i] == -1 && temp != -1) {
					int mid = (i + temp) / 2;
					a[j][mid] = -1;
					temp = -1;
				} else if (a[j + 1][i] == -1 && temp == -1) {
					temp = i;
				}
			}
		}

		int[] step = new int[h];
		for (int i = 0; i < h; i++) {
			int tmp = (int) (Math.pow(2, (i + 1)));
			step[i] = (c + 1 - tmp) / tmp;
		}

		int ry = (c - 1) / 2;
		System.out.print("step : ");
		for (int i = 0; i < h; i++) {
			System.out.print(step[i] + " ");
		}
		System.out.println();

		traverse(root, a, 0, ry, step);// 遍历整个树，把非空结点标注到a矩阵

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] != 0) {
					if (a[i][j] == -1) {
						System.out.printf("%" + gap + "s", symble);// 这种方法可以一试!!!!!!!
					} else {
						System.out.printf("%" + gap + "d", a[i][j]);// 这种方法可以一试!!!!!!!
					}
				} else
					for (int k = 0; k < gap; k++) {
						System.out.printf(" ");
					}

			}
			System.out.println();
		}
	}

	public void traverse(BinNode p, int[][] a, int x, int y, int[] step) {
		if (p != null) {

			System.out.printf("Traverse : a[%d][%d] = %d\n", x, y,
					p.getElement());
			a[x][y] = p.getElement();

			if (p.getLeft() != null) {
				int xl = x + 1;
				int yl = y - 1 - step[x + 1];
				traverse(p.getLeft(), a, xl, yl, step);
			}
			if (p.getRight() != null) {
				int xr = x + 1;
				int yr = y + 1 + step[x + 1];
				traverse(p.getRight(), a, xr, yr, step);
			}
		}
	}

	public void inorder(BinNode r) {
		if (r == null)
			return;
		inorder(r.getLeft());
		System.out.print(r.getElement() + " ");
		inorder(r.getRight());
	}

	public void inorder() {
		this.inorder(root);
	}

	public static void main(String arg[]) {
		BST tree = new BST();
		int[] a = { 12, 4, 53, 23, 14, 6, 12, 26, 30, 88, 24, 10 };
		for (int i = 0; i < a.length; i++) {
			tree.insert(a[i]);
		}
		System.out.print("Inorder : ");
		tree.inorder();
		int h = tree.getHeight();
		System.out.println(tree.root);
		System.out.println("Height : " + h);
		System.out.println("Node Count : " + tree.nodecount);

		int digits = 0;
		if (tree.root != null) {
			BinNode m = tree.root;
			while (m.getRight() != null)
				m = m.getRight();
			int max = m.getElement();
			digits = 0;
			while (max != 0) {
				max = max / 10;
				digits++;
			}
		}
		tree.printtree(digits, "*");
		System.out.println("Find : " + (tree.find2(23))[0].getElement());
		System.out.println("Find : parent :  "
				+ (tree.find2(23))[1].getElement());

	}

}
