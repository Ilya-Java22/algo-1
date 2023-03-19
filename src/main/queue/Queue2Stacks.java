package main.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Queue2Stacks<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void enqueue(T item)
    {
        stack1.push(item);
    }

    public T dequeue()
    {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}

