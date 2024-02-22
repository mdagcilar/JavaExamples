package com.development.metindagcilar.adventOfCode2023.day2;

import lombok.Builder;

import static com.development.metindagcilar.adventOfCode2023.day2.Color.blue;
import static com.development.metindagcilar.adventOfCode2023.day2.Color.green;
import static com.development.metindagcilar.adventOfCode2023.day2.Color.red;

@Builder
public record Cube(
        int frequency,
        Color color
) {

    private static final int RED_CUBES = 12;
    private static final int GREEN_CUBES = 13;
    private static final int BLUE_CUBES = 14;

    public static Cube toCube(String cubeInput) {
        String[] splitCube = cubeInput.stripLeading().split(" ");

        return Cube.builder()
                .frequency(Integer.parseInt(splitCube[0]))
                .color(Color.valueOf(splitCube[1]))
                .build();
    }

    public static boolean isCubeValid(Cube cube) {
        int cubeFreq = cube.frequency();
        Color cubeColor = cube.color();

        if (cubeColor.equals(red)) {
            return cubeFreq <= RED_CUBES;
        } else if (cubeColor.equals(blue)) {
            return cubeFreq <= BLUE_CUBES;
        } else if (cubeColor.equals(green)) {
            return cubeFreq <= GREEN_CUBES;
        }
        throw new RuntimeException("No matching color found");
    }
}
