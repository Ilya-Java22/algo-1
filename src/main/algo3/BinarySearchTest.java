package main.algo3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BinarySearchTest {
    @Test
    void testTryToFind1() {
        BinarySearch binarySearch = new BinarySearch(new int[] {1,10});
        binarySearch.Step(1);
        assertThat(binarySearch.GetResult()).isEqualTo(1);
    }

    @Test
    void testTryToFind1and11and10() {
        BinarySearch binarySearch = new BinarySearch(new int[] {10});
        binarySearch.Step(1);
        assertThat(binarySearch.GetResult()).isEqualTo(-1);
        binarySearch.Step(11);
        assertThat(binarySearch.GetResult()).isEqualTo(-1);
        binarySearch.Step(10);
        assertThat(binarySearch.GetResult()).isEqualTo(1);
    }

    @Test
    void testTryToFind11Twiceand17() {
        BinarySearch binarySearch = new BinarySearch(new int[] {10,11,12,13,14,15,16,17});
        binarySearch.Step(11);
        assertThat(binarySearch.GetResult()).isEqualTo(0);
        binarySearch.Step(11);
        assertThat(binarySearch.GetResult()).isEqualTo(1);
        binarySearch.Step(11);
        assertThat(binarySearch.GetResult()).isEqualTo(0);
        binarySearch.Step(11);
        assertThat(binarySearch.GetResult()).isEqualTo(1);
        binarySearch.Step(17);
        assertThat(binarySearch.GetResult()).isEqualTo(0);
        binarySearch.Step(17);
        assertThat(binarySearch.GetResult()).isEqualTo(0);
        binarySearch.Step(17);
        assertThat(binarySearch.GetResult()).isEqualTo(0);
        binarySearch.Step(17);
        assertThat(binarySearch.GetResult()).isEqualTo(1);

    }

}