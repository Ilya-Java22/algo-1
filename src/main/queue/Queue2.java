package main.queue;

public class Queue2 {
    public static <T> void rotate(Queue<T> queue, int N) {
        while (N-- > 0) {
            queue.enqueue(queue.dequeue());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        rotate(q, 2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
