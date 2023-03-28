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

public class OrderedList<T extends Number>
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
        double v_1 = v1.doubleValue();
        double v_2 = v2.doubleValue();
        return v_1 != v_2 ? (int) ((v_1 - v_2) / Math.abs(v_1 - v_2)) : 0;
    }

    public void add(T value)
    {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node<T> prevNode = null;
        Node<T> node = this.head;
        int sign = _ascending ? 1 : -1;
        while (node != null && sign * compare(value, node.value) >= 0) {
            prevNode = node;
            node = node.next;
        }
        if (prevNode == null) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }
        if (node == null) {
            tail = newNode;
            prevNode.next = newNode;
            return;
        }
        newNode.next = node;
        newNode.prev = prevNode;
        prevNode.next = newNode;
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
