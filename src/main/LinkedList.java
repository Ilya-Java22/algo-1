package main;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
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
        if (this.head == null) {
            return false;
        }
        Node node = this.head;
        if (node.value == _value) {
            this.head = node.next;
            return true;
        }
        if (head == tail) {
            return false;
        }
        while (node != null) {
            if (node.next.value == _value) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if (this.head == null) {
            return;
        }
        Node node = this.head;
        if (node.value == _value) {
            this.head = node.next;
            return;
        }
        if (head == tail) {
            return;
        }
        while (node != null) {
            if (node.next.value == _value) {
                node.next = node.next.next;
            }
            node = node.next;
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            Node _nodeAfterAfter = this.head;
            this.head = _nodeToInsert;
            _nodeToInsert.next = _nodeAfterAfter;

        }
        Node _nodeAfterAfter = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next = _nodeAfterAfter;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}