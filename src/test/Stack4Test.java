package test;

import main.stack.Stack4;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Stack4Test {
    @Test
    void test1() {
        String s = "()";
        assertThat(Stack4.testBalance(s)).isTrue();
    }

    @Test
    void test2() {
        String s = "()(";
        assertThat(Stack4.testBalance(s)).isFalse();
    }

    @Test
    void test3() {
        String s = "((";
        assertThat(Stack4.testBalance(s)).isFalse();
    }

    @Test
    void test4() {
        String s = "()()";
        assertThat(Stack4.testBalance(s)).isTrue();
    }

    @Test
    void test5() {
        String s = ")()(";
        assertThat(Stack4.testBalance(s)).isFalse();
    }

    @Test
    void test6() {
        String s = "((()))";
        assertThat(Stack4.testBalance(s)).isTrue();
    }

    @Test
    void test7() {
        String s = "(()((())()))";
        assertThat(Stack4.testBalance(s)).isTrue();
    }

    @Test
    void test8() {
        String s = "(()()(()))";
        assertThat(Stack4.testBalance(s)).isTrue();
    }

}