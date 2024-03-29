package main.deque;

import java.util.LinkedList;

public class Deque<T>
{
    private LinkedList<T> list;

    public Deque()
    {
        list = new LinkedList<>();
    }

    public void addFront(T item)
    {
        list.addFirst(item);
    }

    public void addTail(T item)
    {
        list.addLast(item);
    }

    public T removeFront()
    {
        return size() != 0 ? list.removeFirst() : null;
    }

    public T removeTail()
    {
        return size() != 0 ? list.removeLast() : null;
    }

    public int size()
    {
        return list.size();
    }
}
