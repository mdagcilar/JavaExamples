package com.development.metindagcilar.LFUCache;

import org.junit.jupiter.api.Test;

class LFUCacheTest {

    @Test
    void lfuCache() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(1));       // returns 1
    }
}