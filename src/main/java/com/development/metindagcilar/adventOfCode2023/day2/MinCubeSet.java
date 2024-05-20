package com.development.metindagcilar.adventOfCode2023.day2;

public record MinCubeSet(
        int redCubes,
        int greenCubes,
        int blueCubes
) {
    public int power() {
        return redCubes * greenCubes * blueCubes;
    }
}
