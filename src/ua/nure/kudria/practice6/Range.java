package ua.nure.kudria.practice6;

import java.util.Iterator;

import ua.nure.your_last_name.practice6.Range.RangeIterator;

public class Range implements Iterable<Integer> {
	int n;
	int m;
	boolean reverse;

	public Range(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}

	public Range(int n, int m, boolean reverse) {
		super();
		this.n = n;
		this.m = m;
		this.reverse = reverse;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RangeIterator();
	}

	public class RangeIterator implements Iterator<Integer> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Integer next() {
			return null;
		}

	}

}