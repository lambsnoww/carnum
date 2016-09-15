package datastructure;

class UALdictionary<Key, E> implements Dictionary<Key, E> {
	private static final int defaultSize = 10;
	private AList<KVpair<Key, E>> list;

	UALdictionary() {
		this(defaultSize);
	}

	UALdictionary(int sz) {
		list = new AList<KVpair<Key, E>>(sz);
	}

	public void clear() {
		list.clear();
	}

	public void insert(Key k, E e) {
		KVpair<Key, E> temp = new KVpair<Key, E>(k, e);
		list.append(temp);
	}

	public E remove(Key k) {
		E temp = find(k);
		if (temp != null)
			list.remove();
		return temp;
	}

	public E removeAny() {
		if (size() != 0) {
			list.moveToEnd();
			list.prev();
			KVpair<Key, E> e = list.remove();
			return e.value();
		} else
			return null;
	}
	 public E find(Key k) {
		 for (list.moveToStart(); list.currPos() < list.length(); list.next()) {
			 KVpair<Key, E> temp = list.getValue();
			 if (k == temp.key())
				 return temp.value();
		 }
		 return null;
	 }

	@Override
	public int size() {
		return list.length();
	}
}
