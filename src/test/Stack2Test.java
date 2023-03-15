package test;

import main.stack.Stack2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Stack2Test {
    private Stack2<Integer> stack;

    @BeforeEach
    void init() {
        stack = new Stack2<>();
        stack.push(1);
        stack.push(2);
    }

    @Test
    void test1() {
        stack.push(3);
        stack.push(4);
        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.peek()).isEqualTo(3);
        assertThat(stack.size()).isEqualTo(3);
    }

    @Test
    void test2() {
        stack.pop();
        stack.push(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(1);
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void test3() {
        stack.pop();
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.size()).isZero();
        assertThat(stack.pop()).isNull();
        assertThat(stack.peek()).isNull();
    }
}