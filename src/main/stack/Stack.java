package main.stack;

import java.util.*;

public class Stack<T>
{
    private LinkedList<T> list;

    public Stack()
    {
        list = new LinkedList<>();
    }

    public int size()
    {
        return list.size();
    }

    public T pop()
    {
        return !list.isEmpty() ? list.removeFirst() : null;
    }

    public void push(T val)
    {
        list.addFirst(val);
    }

    public T peek()
    {
        return !list.isEmpty() ? list.getFirst() : null;
    }
}