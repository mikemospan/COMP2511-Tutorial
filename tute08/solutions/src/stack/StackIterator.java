package stack;

import java.util.Iterator;
import java.util.List;

public class StackIterator<E> implements Iterator<E> {
    private List<E> elements;
    private int i;


    public StackIterator(List<E> elements) {
        this.elements = elements;
        i = elements.size() - 1;
    }

    public boolean hasNext() {
        return i >= 0;
    }

    public E next() {
        return elements.get(i--);
    }
}