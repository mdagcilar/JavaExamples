package com.development.metindagcilar.adventOfCode2023.day2;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public record SubGame(
        List<Cube> cubes
) {

    public static SubGame toSubGame(String subGame) {
        // e.g. 2 red, 6 green, 5 blue
        String[] cubesSplit = subGame.split(", ");
        List<Cube> cubes = Arrays.stream(cubesSplit)
                .map(Cube::toCube)
                .toList();

        return SubGame.builder()
                .cubes(cubes)
                .build();
    }

}
