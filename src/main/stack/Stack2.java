package main.stack;

import java.util.*;

public class Stack2<T>
{
    private LinkedList<T> list;

    public Stack2()
    {
        list = new LinkedList<>();
    }

    public int size()
    {
        return list.size();
    }

    public T pop()
    {
        return !list.isEmpty() ? list.removeLast() : null;
    }

    public void push(T val)
    {
        list.addLast(val);
    }

    public T peek()
    {
        return !list.isEmpty() ? list.getLast() : null;
    }
}