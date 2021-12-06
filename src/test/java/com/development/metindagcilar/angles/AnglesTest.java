package com.development.metindagcilar.angles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AnglesTest {

    Angles angles = new Angles();

    @Test
    void angles(){
        String angles = this.angles.angles("><>");
        Assertions.assertThat(angles).isEqualTo("<<>>");
    }

    @Test
    void angles1(){
        String angles2 = angles.angles("<<>>>>><<<>>");
        Assertions.assertThat(angles2).isEqualTo("<<<<<>>>>><<<>>>");
    }

    @Test
    void angles2(){
        String angles2 = angles.angles("><");
        Assertions.assertThat(angles2).isEqualTo("<><>");
    }

}