package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammersTest {

    @Test
    void 음양더하기() {
        boolean[] signs = {true, false, true};
        int[] absolutes = {4, 7, 12};
        int expected = 9;
        int result = Programmers.음양더하기(absolutes, signs);

        assertEquals(expected, result);

        boolean[] signs2 = {false, false, true};
        int[] absolutes2 = {1, 2, 3};
        expected = 0;
        result = Programmers.음양더하기(absolutes2, signs2);

        assertEquals(expected, result);
    }

    @Test
    void 두개뽑아서더하기() {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] expected = {2, 3, 4, 5, 6, 7};;
        int[] result = Programmers.두개뽑아서더하기(numbers);

        assertArrayEquals(expected, result);

        int[] numbers2 = {5, 0, 2, 7};
        int[] expected2 = {2, 5, 7, 9, 12};;
        result = Programmers.두개뽑아서더하기(numbers2);

        assertArrayEquals(expected2, result);
    }

    @Test
    void 가운데글자가져오기() {
        String s = "abcde";
        String expected = "c";;
        String result = Programmers.가운데글자가져오기(s);

        assertEquals(expected, result);

        s = "qwer";
        expected = "we";
        result = Programmers.가운데글자가져오기(s);

        assertEquals(expected, result);
    }
}