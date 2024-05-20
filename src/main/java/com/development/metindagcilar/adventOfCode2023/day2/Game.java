package com.development.metindagcilar.adventOfCode2023.day2;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public record Game(
        Integer gameId,
        List<SubGame> subGames
) {

    public static Game toGame(Integer gameId, String[] subGames) {
        List<SubGame> processSubGames = Arrays.stream(subGames)
                .map(SubGame::toSubGame)
                .toList();

        return Game.builder()
                .gameId(gameId)
                .subGames(processSubGames)
                .build();
    }

    public MinCubeSet minCubesForGame() {
        int maxRed = subGames.stream()
                .mapToInt(subGame -> subGame.maxFrequencyOfColor(Color.red))
                .max()
                .orElse(0);

        int maxGreen = subGames.stream()
                .mapToInt(subGame -> subGame.maxFrequencyOfColor(Color.green))
                .max()
                .orElse(0);

        int maxBlue = subGames.stream()
                .mapToInt(subGame -> subGame.maxFrequencyOfColor(Color.blue))
                .max()
                .orElse(0);

        return new MinCubeSet(maxRed, maxGreen, maxBlue);
    }

    public int powerOfGame() {
        int[] maxFrequencies = subGames.stream()
                .flatMap(subGame -> subGame.cubes().stream())
                .collect(() -> new int[3],
                        (result, cube) -> {
                            if (cube.color() == Color.red) {
                                result[0] = Math.max(result[0], cube.frequency());
                            } else if (cube.color() == Color.green) {
                                result[1] = Math.max(result[1], cube.frequency());
                            } else if (cube.color() == Color.blue) {
                                result[2] = Math.max(result[2], cube.frequency());
                            }
                        },
                        (result1, result2) -> {
                            result1[0] = Math.max(result1[0], result2[0]);
                            result1[1] = Math.max(result1[1], result2[1]);
                            result1[2] = Math.max(result1[2], result2[2]);
                        });

        return maxFrequencies[0] * maxFrequencies[1] * maxFrequencies[2];
    }

}
