package main.queue;

import java.util.LinkedList;

public class Queue<T>
{
    private LinkedList<T> list;

    public Queue()
    {
        list = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        list.addFirst(item);
    }

    public T dequeue()
    {
        return size() != 0 ? list.removeLast() : null;
    }

    public int size()
    {
        return list.size();
    }

}
