package com.development.metindagcilar.LRUCache;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LRUCacheTest {

    @Test
    public void testLruCacheExampleSequence() {
        // Initialize the LRU cache with capacity 2
        LRUCache cache = new LRUCache(2);

        // put(1, 1) -> cache is {1=1}
        cache.put(1, 1);

        // put(2, 2) -> cache is {1=1, 2=2}
        cache.put(2, 2);

        // get(1) -> returns 1
        assertThat(cache.get(1))
                .as("Fetching key 1 should return 1 and move it to the head")
                .isEqualTo(1);

        // put(3, 3) -> LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        cache.put(3, 3);

        // get(2) -> returns -1 (not found)
        assertThat(cache.get(2))
                .as("Key 2 should have been evicted when key 3 was added")
                .isEqualTo(-1);

        // put(4, 4) -> LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        cache.put(4, 4);

        // get(1) -> return -1 (not found)
        assertThat(cache.get(1))
                .as("Key 1 should have been evicted when key 4 was added")
                .isEqualTo(-1);

        // get(3) -> return 3
        assertThat(cache.get(3))
                .as("Fetching key 3 should return 3")
                .isEqualTo(3);

        // get(4) -> return 4
        assertThat(cache.get(4))
                .as("Fetching key 4 should return 4")
                .isEqualTo(4);
    }

}