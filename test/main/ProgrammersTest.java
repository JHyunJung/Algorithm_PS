package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammersTest {

    @Test
    void solution() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] expected = {4,1,3,0};
        int[] result = Programmers.solution(genres, plays);

        assertArrayEquals(expected, result);
    }
}