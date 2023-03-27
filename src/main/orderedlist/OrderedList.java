package main.orderedlist;

import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        double v_1 = (double) v1;
        double v_2 = (double) v2;
        return v_1 != v_2 ? (int) ((v_1 - v_2) / Math.abs(v_1 - v_2)) : 0;
    }

    public void add(T value)
    {
        Node<T> node = this.head;
        int sign = _ascending ? 1 : -1;
        while (node != null) {
            if (sign * compare(value, node.value) < 0) {
                break;
            }
            node = node.next;
        }
        Node<T> newNode = new Node<>(value);
        if (node == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;
    }

    public Node<T> find(T val)
    {
        Node<T> node = head;
        while(node != null)
        {
            if (compare(val, node.value) == 0) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    public void delete(T val)
    {
        Node<T> node = find(val);
        if (node == null) {
            return;
        }
        if (head == tail) {
            clear(_ascending);
            return;
        }
        if (node == head) {
            head = node.next;
            node.next.prev = null;
            return;
        }
        if (node == tail) {
            tail = node.prev;
            node.prev.next = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count()
    {
        int sum = 0;
        Node<T> node = this.head;
        while (node != null) {
            sum++;
            node = node.next;
        }
        return sum;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
