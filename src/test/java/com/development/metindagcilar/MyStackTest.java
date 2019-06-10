package com.development.metindagcilar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyStackTest {

    MyStack stack;

    @BeforeEach
    private void setup() {
        stack = new MyStack();
    }

    @Test
    void pop() {
        stack.push("A");
        assertThat(stack.pop()).isEqualTo("A");
    }

    @Test
    void peek() {
        stack.push("A");
        assertThat(stack.peek()).isEqualTo("A");
    }

    @Test
    void isEmpty() {
        assertThat(stack.isEmpty()).isTrue();
    }
}