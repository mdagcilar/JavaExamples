package com.development.metindagcilar.adventOfCode2023.day2;

import java.util.List;

public class Day2 {

    public int sumOfGameIds(List<String> sampleAsLines) {
        List<Game> games = sampleAsLines.stream()
                .map(this::extractGames)
                .filter(this::isValidGame)
                .toList();

        return sumGameIds(games);
    }

    public int powerOfGameIds(List<String> sampleAsLines) {
        List<Game> games = sampleAsLines.stream()
                .map(this::extractGames)
                .toList();

        return games.stream()
                .map(Game::minCubesForGame)
                .mapToInt(MinCubeSet::power)
                .sum();
    }

    public int powerOfGameIdsOption2(List<String> sampleAsLines) {
        List<Game> games = sampleAsLines.stream()
                .map(this::extractGames)
                .toList();

        int totalPower = games.stream()
                .mapToInt(Game::powerOfGame)
                .sum();

        return totalPower;
    }

    private Game extractGames(String rawGameInput) {
        String subGameDelimiter = ";";
        String[] gameInputs1 = rawGameInput.split(":");

        Integer gameId = Integer.parseInt(gameInputs1[0].replaceAll("\\D", ""));

        String games = gameInputs1[1].substring(1);
        String[] subGames = games.split(subGameDelimiter);

        return Game.toGame(gameId, subGames);
    }

    private boolean isValidGame(Game game) {
        return game
                .subGames()
                .stream()
                .allMatch(this::isValidSubGame);
    }

    private boolean isValidSubGame(SubGame subGame) {
        return subGame
                .cubes()
                .stream()
                .allMatch(Cube::isCubeValid);
    }

    private Integer sumGameIds(List<Game> validGames) {
        return validGames.stream()
                .mapToInt(Game::gameId)
                .sum();
    }

}
