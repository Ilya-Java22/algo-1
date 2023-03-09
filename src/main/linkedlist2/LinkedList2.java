package main.linkedlist2;

import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = head;
        while (node != null) {
            if (node.value == _value) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    public List<Node> findAll(int _value)
    {
        List<Node> nodes = new ArrayList<>();
        Node node = head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = find(_value);
        if (node == null) {
            return false;
        }
        if (head == tail) {
            clear();
            return true;
        }
        if (node == head) {
            head = node.next;
            node.next.prev = null;
            return true;
        }
        if (node == tail) {
            tail = node.prev;
            node.prev.next = null;
            return true;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return true;
    }

    public void removeAll(int _value)
    {
        boolean rmv = remove(_value);
        while (rmv) {
            rmv = remove(_value);
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int sum = 0;
        Node node = this.head;
        while (node != null) {
            sum++;
            node = node.next;
        }
        return sum;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == tail) {
            addInTail(_nodeToInsert);
            return;
        }
        if (_nodeAfter == null) {
            Node _nodeAfterAfter = head;
            head = _nodeToInsert;
            head.prev = null;
            head.next = _nodeAfterAfter;
            _nodeAfterAfter.prev = head;
            return;
        }
        Node _nodeAfterAfter = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next = _nodeAfterAfter;
        _nodeToInsert.prev = _nodeAfter;
        _nodeAfterAfter.prev = _nodeToInsert;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}