package com.development.metindagcilar.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CacheTest {

    private Cache cache;

    @BeforeEach
    void setup() {
        cache = new Cache(10);
    }

    @Test
    void getValue() {
        cache.setKeyValue(1, "Book");
        assertThat(cache.getValue(1)).isEqualTo("Book");
    }

    @Test
    void removeKey() {
        cache.setKeyValue(2, "BlockKey");
        cache.removeKey(2);
        assertThat(cache.getValue(2)).isNull();
    }
}
