package ua.nure.kudria.practice6.part7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    private int n;
    private int m;

    public Range(int n, int m) {
        if (n <= m) {
            this.n = n;
            this.m = m;
        }
    }

    Range(int n, int m, boolean reverse) {
        if (!reverse) {
            if (n <= m) {
                this.n = n;
                this.m = m;
            }
        } else {
            if (m >= n) {
                this.n = m;
                this.m = n;
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(n, m);
    }

    private static final class RangeIterator implements Iterator<Integer> {
        private int cursor;

        private int m;

        private boolean isGrow;

        RangeIterator(int n, int m) {
            this.cursor = n;
            this.m = m;
            this.isGrow = (n <= m);
        }

        @Override
        public boolean hasNext() {
            if (isGrow) {
                return (cursor <= m);
            } else {
                return (cursor >= m);
            }

        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int element = cursor;
            if (isGrow) {
                cursor++;
            } else {
                cursor--;
            }
            return element;
        }
    }
}
