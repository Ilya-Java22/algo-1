package test;

import main.queue.Queue2Stacks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Queue2StacksTest {
    private Queue2Stacks<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue2Stacks<>();
        queue.enqueue(1);
    }

    @Test
    void whenPushPoll() {
        assertThat(queue.dequeue()).isEqualTo(1);
    }

    @Test
    void when2PushPoll() {
        queue.enqueue(2);
        assertThat(queue.dequeue()).isEqualTo(1);
    }

    @Test
    void when2PushPollPushPoll() {
        queue.dequeue();
        queue.enqueue(2);
        assertThat(queue.dequeue()).isEqualTo(2);
    }

    @Test
    void whenEmptyPoll() {
        Queue2Stacks<Integer> queue = new Queue2Stacks<>();
        assertThatThrownBy(queue::dequeue)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void when2PushPollPushPollEmpty() {
        queue.dequeue();
        queue.enqueue(2);
        queue.dequeue();
        assertThatThrownBy(queue::dequeue)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenPushPushPollAndPush() {
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        assertThat(queue.dequeue()).isEqualTo(2);
    }
}