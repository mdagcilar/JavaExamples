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

}
