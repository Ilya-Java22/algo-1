package main.orderedlist;

import java.util.ArrayList;

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
        if (v1 instanceof Number) {
            double v_1 = ((Number) v1).doubleValue();
            double v_2 = ((Number) v2).doubleValue();
            return v_1 != v_2 ? (int) ((v_1 - v_2) / Math.abs(v_1 - v_2)) : 0;
        }
        if (v1 instanceof String) {
            String v_1 = ((String) v1).trim();
            String v_2 = ((String) v2).trim();
            int _v1 = v_1.length();
            int _v2 = v_2.length();
            for (int i = 0; i < Math.min(_v1, _v2); i++) {
                int result = Character.compare(v_1.charAt(i), v_2.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
            return _v1 != _v2 ? ((_v1 - _v2) / Math.abs(_v1 - _v2)) : 0;
        }
        return 0;
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
        while (node != null && sign * compare(value, node.value) > 0) {
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
            prevNode.next = newNode;
            newNode.prev = prevNode;
            tail = newNode;
            return;
        }
        newNode.next = node;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        node.prev = newNode;
    }

    public Node<T> find(T val)
    {
        int sign = _ascending ? 1 : -1;
        if (tail == null || sign * compare(tail.value, val) == -1 || sign * compare(head.value, val) == 1) {
            return null;
        }
        Node<T> node = head;
        int comp;
        while (node != null && (comp = sign * compare(node.value, val)) != 1)
        {
            if (comp == 0) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

//    public Node<T> find(T val)
//    {
//        Node<T> node = head;
//        while(node != null)
//        {
//            if (compare(val, node.value) == 0) {
//                break;
//            }
//            node = node.next;
//        }
//        return node;
//    }

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
